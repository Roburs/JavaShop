package utp.edu.shop.javaShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.shop.javaShop.Models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> { }