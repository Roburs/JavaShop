package utp.edu.shop.javaShop.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Boolean returnAbility;

    public Product(String name, Boolean returnAbility){
        this.name = name;
        this.returnAbility = returnAbility;
    }

    public Product(){}
}
