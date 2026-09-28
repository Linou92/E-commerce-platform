package se.lexicon.E_commerce_platform.service;

import org.springframework.stereotype.Service;
import se.lexicon.E_commerce_platform.dto.CustomerRequest;
import se.lexicon.E_commerce_platform.dto.CustomerResponse;
import se.lexicon.E_commerce_platform.entity.Customer;
import se.lexicon.E_commerce_platform.exception.DuplicateResourceException;
import se.lexicon.E_commerce_platform.exception.ResourceNotFoundException;
import se.lexicon.E_commerce_platform.mapper.CustomerMapper;
import se.lexicon.E_commerce_platform.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse register (CustomerRequest request){

        // check if email already exists
        if(customerRepository.findByEmail(request.email()).isPresent()){
            throw new DuplicateResourceException("Email already exists " + request.email());
        }

        // convert dto to entity
        Customer customer = customerMapper.toEntity(request);

        // save entity
        Customer savedCustomer = customerRepository.save(customer);

        // convert entity to dto
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public CustomerResponse findById (Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));
        return customerMapper.toResponse(customer);
    }

    @Override
    public CustomerResponse update (Long id, CustomerRequest request){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));

        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());

        customer.getAddress().setStreet(request.street());
        customer.getAddress().setCity(request.city());
        customer.getAddress().setZipCode(request.zipCode());

        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.toResponse(updatedCustomer);
    }
}
