package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/productlist")
    public String getAllProductsList(Model model) {
        model.addAttribute("products", repository.findAll());
        return "productlist";
    }
    
    @GetMapping("/addproduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long productId, Model model) {
        repository.deleteById(productId);
        return "redirect:/productlist";
    }
    
}
