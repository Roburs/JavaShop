package utp.edu.shop.javaShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.shop.javaShop.Models.SingleProduct;

public interface SingleProductRepository extends JpaRepository<SingleProduct, Integer> { }