package utp.edu.shop.javaShop.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "orders")
@Entity
@Data
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer productId;
    @NotNull
    private String productName;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    public Orders(Integer productId, String productName, String name, String surname){
        this.productId = productId;
        this.productName = productName;
        this.name = name;
        this.surname = surname;
    }

    public Orders(){}
}