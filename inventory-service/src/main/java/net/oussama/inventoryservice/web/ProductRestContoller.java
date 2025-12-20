package net.oussama.inventoryservice.web;

import net.oussama.inventoryservice.entites.Product;
import net.oussama.inventoryservice.repository.ProductRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestContoller {
    private ProductRepository  productRepository;
    public ProductRestContoller(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/product")
    public List<Product> productList(){
        return  productRepository.findAll();
    }
    @GetMapping("/product/{id}")
    public  Product findProductById(@PathVariable String id){
        return productRepository.findById(id).get();
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
