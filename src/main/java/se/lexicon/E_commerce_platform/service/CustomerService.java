package se.lexicon.E_commerce_platform.service;

import se.lexicon.E_commerce_platform.dto.CustomerRequest;
import se.lexicon.E_commerce_platform.dto.CustomerResponse;

public interface CustomerService {

    CustomerResponse register (CustomerRequest request);
    CustomerResponse findById (Long id);
    CustomerResponse update (Long id, CustomerRequest request);
}
