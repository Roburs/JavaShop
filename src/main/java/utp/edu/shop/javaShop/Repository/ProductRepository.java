package utp.edu.shop.javaShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.shop.javaShop.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> { }

