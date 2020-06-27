package utp.edu.shop.javaShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.shop.javaShop.Models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> { }

