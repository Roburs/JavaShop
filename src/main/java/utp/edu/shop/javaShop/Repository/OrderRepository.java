package utp.edu.shop.javaShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.shop.javaShop.Models.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> { }

