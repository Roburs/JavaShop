package utp.edu.shop.javaShop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.shop.javaShop.Models.*;
import utp.edu.shop.javaShop.Repository.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductByWeightRepository productByWeightRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReturnsRepository returnsRepository;
    @Autowired
    private RtvAgdProductRepository rtvAgdProductRepository;
    @Autowired
    private SingleProductRepository singleProductRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductByWeight> getInformationsAboutProductByWeight(){
        return productByWeightRepository.findAll();
    }
    public List<SingleProduct> getInformationsAboutSingleProduct(){
        return singleProductRepository.findAll();
    }
    public List<RtvAgdProduct> getInformationsAboutRtvAgdProducts(){
        return rtvAgdProductRepository.findAll();
    }

    public String getProductNameById(Integer productId){
        List<Product> productList = productRepository.findAll().stream()
                .filter(product -> product.getId().equals(productId))
                .collect(Collectors.toList());

        return productList.get(0).getName().toString();
    }

    public Orders saveOrders(Integer productId, String name, String surname){
        Orders order = new Orders(
                productId,
                getProductNameById(productId),
                name,
                surname
        );

        orderRepository.save(order);

        Purchase purchase = new Purchase(
                getNewOrder().getId(),
                findProductPriceById(productId),
                1
        );
        purchaseRepository.save(purchase);

        return order;
    }

    public Orders getNewOrder(){
        List<Orders> orders = orderRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Orders::getId)
                .reversed())
                .collect(Collectors.toList());

        return orders.get(0);
    }

    public Integer findProductPriceById(Integer productId){
        Integer price = 0;
        List<ProductByWeight> productByWeight = productByWeightRepository.findAll().stream()
                .filter(productByWeight1 -> productByWeight1.getProductId().equals(productId))
                .collect(Collectors.toList());

        if(productByWeight.size() == 0){
            List<SingleProduct> singleProduct = singleProductRepository.findAll().stream()
                    .filter(singleProduct1 -> singleProduct1.getProductId().equals(productId))
                    .collect(Collectors.toList());

            if(singleProduct.size() == 0){
                List<RtvAgdProduct> rtvAgdProduct = rtvAgdProductRepository.findAll().stream()
                        .filter(rtvAgdProduct1 -> rtvAgdProduct1.getProductId().equals(productId))
                        .collect(Collectors.toList());

                price = rtvAgdProduct.get(0).getPrice();
            }else{
                price = singleProduct.get(0).getPrice();
            }
        }else{
            price = productByWeight.get(0).getPricePerKg();
        }

        return price;
    }

}
