package se.lexicon.E_commerce_platform.service;

import se.lexicon.E_commerce_platform.dto.ProductRequest;
import se.lexicon.E_commerce_platform.dto.ProductResponse;
import se.lexicon.E_commerce_platform.entity.Category;
import se.lexicon.E_commerce_platform.entity.Product;
import se.lexicon.E_commerce_platform.exception.ResourceNotFoundException;
import se.lexicon.E_commerce_platform.mapper.ProductMapper;
import se.lexicon.E_commerce_platform.repository.CategoryRepository;
import se.lexicon.E_commerce_platform.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public  ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse create (ProductRequest request){

        // find category first
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category with id " + request.categoryId() + " not found"));

        // dto to entity
        Product product = productMapper.toEntity(request, category);

        // save
        Product savedProduct = productRepository.save(product);

        // entity to dto
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> findAll(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> searchByName(String name){
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}
