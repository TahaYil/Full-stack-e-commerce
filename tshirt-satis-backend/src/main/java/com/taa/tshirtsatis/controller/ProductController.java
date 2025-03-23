package com.taa.tshirtsatis.controller;

import com.taa.tshirtsatis.dto.ProductDto;
import com.taa.tshirtsatis.entity.Product;
import com.taa.tshirtsatis.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable("id") int id) {
        byte[] image = productService.getProductImage(id);
        return ResponseEntity.ok().
                contentType(MediaType.IMAGE_JPEG).
                body(image);

    }
    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@RequestPart ProductDto productDto,
                                                    @RequestPart MultipartFile file) throws IOException {
        return ResponseEntity.ok(productService.create(productDto,file));
    }
}
