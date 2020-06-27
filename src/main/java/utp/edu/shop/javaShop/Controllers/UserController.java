package utp.edu.shop.javaShop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;

@Transactional
@Controller
public class UserController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
