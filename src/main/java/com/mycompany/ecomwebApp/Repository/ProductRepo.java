package com.mycompany.ecomwebApp.Repository;

import com.mycompany.ecomwebApp.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Item,Integer> {
}
