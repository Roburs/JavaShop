package utp.edu.shop.javaShop.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer price;
    @NotNull
    private Boolean readyToCollect;

    public Purchase(Integer orderId, Integer price, Boolean readyToCollect){
        this.orderId = orderId;
        this.price = price;
        this.readyToCollect = readyToCollect;
    }

    public Purchase(){}
}