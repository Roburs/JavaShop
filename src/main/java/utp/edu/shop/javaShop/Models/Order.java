package utp.edu.shop.javaShop.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer number;
    @NotNull
    private String productName;

    public Order(Integer productId, Integer number, String productName){
        this.productId = productId;
        this.number = number;
        this.productName = productName;
    }

    public Order(){}
}