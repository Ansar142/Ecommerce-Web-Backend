package com.mycompany.ecomwebApp;

import com.mycompany.ecomwebApp.Model.Item;
import com.mycompany.ecomwebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {
    @Autowired
    ProductService productService ;

    @GetMapping("/products")
    public ResponseEntity<List<Item>> getProducts() {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED) ;
        }
    }



