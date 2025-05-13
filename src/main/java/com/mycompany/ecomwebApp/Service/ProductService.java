package com.mycompany.ecomwebApp.Service;

import com.mycompany.ecomwebApp.Model.Item;
import com.mycompany.ecomwebApp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Item getProductByid(int product){
        return productRepo.findById(product).get();
    }

    public List<Item> getAllProducts() {
        return productRepo.findAll();
    }

    public Item addorUpdateProduct(Item i , MultipartFile imageFile ){
        i.setImageName(imageFile.getOriginalFilename());
        i.setImageType(imageFile.getContentType());
        try {
            i.setImageData(imageFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productRepo.save(i) ;
    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
}
