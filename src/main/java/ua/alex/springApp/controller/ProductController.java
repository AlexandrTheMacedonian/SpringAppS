package ua.alex.springApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.alex.springApp.model.Product;
import ua.alex.springApp.service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listproducts", productService.getAll());
        return "products";
    }

    @RequestMapping(value = "products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product){
        if (product.getId()==0){
            productService.add(product);
        } else {
            productService.update(product);
        }
        return "redirect:/products";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("listproducts", productService.getAll());
        return "products";
    }

    @RequestMapping(value = "productdata/{id}")
    public String productData(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "productdata";
    }
}
