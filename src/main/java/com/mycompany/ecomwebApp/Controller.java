package com.mycompany.ecomwebApp;

import com.mycompany.ecomwebApp.Model.Item;
import com.mycompany.ecomwebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/product/{getItem}")
    public ResponseEntity<?> getProducts(@PathVariable("getItem") int getItem) {
        return new ResponseEntity<>(productService.getProductByid(getItem), HttpStatus.ACCEPTED) ;
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Item product , @RequestPart MultipartFile imageFile){
        return new ResponseEntity<>(productService.addorUpdateProduct(product,imageFile),HttpStatus.CREATED);
    }
    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
        Item product = productService.getAProduct(id);
        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id , @RequestPart Item product , @RequestPart MultipartFile imageFile){
        return new ResponseEntity<>(productService.addorUpdateProduct(product,imageFile),HttpStatus.OK);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        Item item = productService.getProductByid(id);

        if (item!=null) {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }

    }





}

