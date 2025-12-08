package net.oussama.inventoryservice;

import net.oussama.inventoryservice.entites.Product;
import net.oussama.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return  args -> {
            productRepository.save(Product.builder().name("Computer").price(2300).quantity(2).build());
            productRepository.save(Product.builder().name("printer").price(1200).quantity(20).build());
            productRepository.save(Product.builder().name("smart phone").price(3400).quantity(12).build());

        };
    }
}
