package utp.edu.shop.javaShop.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
@Data
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer price;

    public Return(Integer orderId, Integer price){
        this.orderId = orderId;
        this.price = price;
    }

    public Return(){}
}