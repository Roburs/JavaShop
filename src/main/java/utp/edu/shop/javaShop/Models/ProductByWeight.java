package utp.edu.shop.javaShop.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
@Data
public class ProductByWeight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer pricePerKg;
    @NotNull
    private Integer amountInKg;

    public ProductByWeight(Integer productId, Integer pricePerKg, Integer amountInKg){
        this.productId = productId;
        this.pricePerKg = pricePerKg;
        this.amountInKg = amountInKg;
    }

    public ProductByWeight(){}
}