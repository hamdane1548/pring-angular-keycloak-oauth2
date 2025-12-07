package net.oussama.inventoryservice.repository;

import net.oussama.inventoryservice.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
    
}
