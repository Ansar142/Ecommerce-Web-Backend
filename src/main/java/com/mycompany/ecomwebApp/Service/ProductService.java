package com.mycompany.ecomwebApp.Service;

import com.mycompany.ecomwebApp.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.ecomwebApp.Repository.ProductRepo;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Item> getAllProducts() {
        return productRepo.findAll();
    }
}
