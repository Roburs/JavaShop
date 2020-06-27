package utp.edu.shop.javaShop.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
@Data
public class SingleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer price;
    @NotNull
    private Integer amount;

    public SingleProduct(Integer productId, Integer price, Integer amount){
        this.productId = productId;
        this.price = price;
        this.amount = amount;
    }

    public SingleProduct(){}
}