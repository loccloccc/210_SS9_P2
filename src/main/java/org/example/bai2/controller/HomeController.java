package org.example.bai2.controller;

import org.example.bai2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/home")
    public String homePage(
            @CookieValue(value = "guest_name", required = false, defaultValue = "Khách lạ") String guestName,
            Model model
    ) {
        if ("Khách lạ".equals(guestName)) {
            model.addAttribute("msg", "Chào khách lạ!");
        } else {
            model.addAttribute("msg", "Chào mừng " + guestName + " trở lại!");
        }


        List<Product> products = List.of(
                new Product("Áo", 100000, "/images/a.jpg"),
                new Product("Quần", 200000, "/images/b.jpg"),
                new Product("Giày", 300000, "/images/c.jpg")
        );

        model.addAttribute("products", products);

        return "home-page";
    }
}
