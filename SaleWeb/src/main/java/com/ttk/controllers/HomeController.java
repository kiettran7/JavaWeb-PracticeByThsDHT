/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttk.controllers;

import com.ttk.services.CategoryServices;
import com.ttk.services.ProductServices;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryServices categoryService;
    @Autowired
    private ProductServices productService;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", this.categoryService.getCates());
        Map<String, String> params = new HashMap<>();
        model.addAttribute("products", this.productService.getProds(params));
        return "index";
    }
}
