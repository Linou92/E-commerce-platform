package se.lexicon.E_commerce_platform.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.E_commerce_platform.dto.AddressResponse;
import se.lexicon.E_commerce_platform.dto.CustomerRequest;
import se.lexicon.E_commerce_platform.dto.CustomerResponse;
import se.lexicon.E_commerce_platform.entity.Address;
import se.lexicon.E_commerce_platform.entity.Customer;

@Component
public class CustomerMapper {

    public CustomerResponse toResponse(Customer customer){

        AddressResponse addressResponse = new AddressResponse(
                customer.getAddress().getId(),
                customer.getAddress().getStreet(),
                customer.getAddress().getCity(),
                customer.getAddress().getZipCode()
        );

        String fullName = customer.getFirstName() + " " + customer.getLastName();

        return new CustomerResponse(
                customer.getId(),
                fullName,
                customer.getEmail(),
                addressResponse
        );
    }

    public Customer toEntity(CustomerRequest request){

        Address address = new Address();
        address.setStreet(request.street());
        address.setCity(request.city());
        address.setZipCode(request.zipCode());

        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());

        return customer;
    }
}
