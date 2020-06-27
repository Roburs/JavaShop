package utp.edu.shop.javaShop.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "returns")
@Entity
@Data
@AllArgsConstructor
public class Returns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer price;

    public Returns(Integer orderId, Integer price){
        this.orderId = orderId;
        this.price = price;
    }

    public Returns(){}
}