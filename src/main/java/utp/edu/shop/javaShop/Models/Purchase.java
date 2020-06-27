package utp.edu.shop.javaShop.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "purchase")
@Entity
@Data
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer price;
    @NotNull
    private Integer readyToCollect;

    public Purchase(Integer orderId, Integer price, Integer readyToCollect){
        this.orderId = orderId;
        this.price = price;
        this.readyToCollect = readyToCollect;
    }

    public Purchase(){}
}