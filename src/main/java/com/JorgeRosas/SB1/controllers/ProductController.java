package com.JorgeRosas.SB1.controllers;

import com.JorgeRosas.SB1.domain.Product;
import com.JorgeRosas.SB1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("jsonResourceService")
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProductsList(){
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

}