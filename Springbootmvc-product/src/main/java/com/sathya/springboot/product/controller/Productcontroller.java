package com.sathya.springboot.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springboot.product.entity.Productentity;
import com.sathya.springboot.product.model.Product;
import com.sathya.springboot.product.service.Productservice;

@Controller
public class Productcontroller {

    @Autowired
    Productservice productservice;

    @GetMapping("/productform")
    public String getproductform() {
        return "add-product";
    }

    @GetMapping("/getallproducts")
    public String getallproducts(Model model) {
        List<Productentity> productEntity = productservice.getallproduct();
        model.addAttribute("products", productEntity);
        return "product-list";
    }

    @PostMapping("/saveproduct")
    public String saveproduct(Product product) {
        productservice.saveProductDetails(product);
        System.out.println(product);
        return "success";
    }

    @GetMapping("/getsearchform")
    public String getsearchform() {
        return "Search-product";
    }

    @PostMapping("/searchbyid")
    public String searchByid(@RequestParam Long id, Model model) {
        Productentity product = productservice.searchByid(id);
        model.addAttribute("product", product);
        return "Search-product";
    }

    @GetMapping("/delete/{id}")
    public String deletebyid(@PathVariable("id") Long id) {
        productservice.deletebyid(id);
        return "redirect:/getallproducts";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") Long id, Model model) {
        Productentity product = productservice.searchByid(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "edit-product";
        } else {
            return "redirect:/getallproducts";
        }
    }

    @PostMapping("/editproductsave/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute Product product) {
        productservice.saveProductDetails(product);
        return "redirect:/getallproducts";
    }
}