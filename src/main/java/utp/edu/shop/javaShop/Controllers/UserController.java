package utp.edu.shop.javaShop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utp.edu.shop.javaShop.Models.*;
import utp.edu.shop.javaShop.Service.ShopService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Controller
public class UserController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/returns")
    public String returns() {
        return "returns";
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        List<Product> allProducts = shopService.getAllProducts();
        List<ProductByWeight> productsByWeight = shopService.getInformationsAboutProductByWeight();
        List<SingleProduct> singleProducts = shopService.getInformationsAboutSingleProduct();
        List<RtvAgdProduct> rtvAgdProducts = shopService.getInformationsAboutRtvAgdProducts();

        model.addAttribute("allProducts",allProducts);
        model.addAttribute("productsByWeight",productsByWeight);
        model.addAttribute("singleProducts",singleProducts);
        model.addAttribute("rtvAgdProducts",rtvAgdProducts);
        return "shop";
    }


    @PostMapping("/save/order/{productId}/{name}/{surname}")
    @ResponseBody
    public void saveOrder(@PathVariable Integer productId, @PathVariable String name, @PathVariable String surname){
        Integer orderProductId = productId;
        String orderName = name;
        String orderSurname = surname;
        shopService.saveOrders(orderProductId,orderName,orderSurname);
    }

    @GetMapping("/finishedOrder")
    public String showOrder(Model model){
        Orders order = shopService.getNewOrder();
        model.addAttribute("orders",order);
        model.addAttribute("prices",shopService.findProductPriceById(order.getProductId()));

        return "finished";
    }

}
