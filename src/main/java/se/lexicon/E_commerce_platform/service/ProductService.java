package se.lexicon.E_commerce_platform.service;

import se.lexicon.E_commerce_platform.dto.ProductRequest;
import se.lexicon.E_commerce_platform.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create (ProductRequest request);
    List<ProductResponse> findAll();
    List<ProductResponse> searchByName(String name);
}
