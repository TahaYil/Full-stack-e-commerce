package com.taa.tshirtsatis.service;

import com.taa.tshirtsatis.dto.ProductDto;
import com.taa.tshirtsatis.entity.Product;
import com.taa.tshirtsatis.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAll() {
        List<Product> products=productRepository.findAll();
        List<ProductDto> productDtos=products.stream().
                map(ProductDto::new).
                toList();
        return productDtos;
    }
    public ProductDto getById(int id) {
        Product p=productRepository.findById(id);
        return new ProductDto(p);
    }
    public ProductDto create(ProductDto productDto, MultipartFile file) throws IOException {
        Product p=new Product();
        p.setCategories(productDto.getCategories());
        p.setName(productDto.getName());
        p.setDescription(productDto.getDescription());
        p.setPrice(productDto.getPrice());
        p.setQuantity(productDto.getQuantity());
        p.setImage(file.getBytes());
        productRepository.save(p);
        return new ProductDto(p);

    }
//    public Product update(Product product) {
//        return productRepository.save(product);
//    }

    public ProductDto update(ProductDto productDto, MultipartFile file) throws IOException {
        Product p=productRepository.findById(productDto.getId());
        p.setName(productDto.getName());
        p.setDescription(productDto.getDescription());
        p.setPrice(productDto.getPrice());
        p.setQuantity(productDto.getQuantity());
        p.setCategories(productDto.getCategories());
        if(file!=null && !file.isEmpty()) {
            p.setImage(file.getBytes());
        }
        productRepository.save(p);
        return new ProductDto(p);
    }
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByCategoryId(int categoryId){
        return productRepository.findByCategoryId(categoryId);
    }
    public List<Product> findByCategoryName(String categoryName){
        return productRepository.findByCategoryName(categoryName);
    }

    public byte[] getProductImage(int id) {
        return productRepository.findById(id).getImage();
    }

}
