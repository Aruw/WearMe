package br.com.aruw.controller;

import java.util.List;
import br.com.aruw.beans.Product;
import br.com.aruw.dao.ProductDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = (List<Product>) productDAO.findAll();
        if(products.size() == 0){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{cod}")
    public ResponseEntity<Product> getProduct(@PathVariable int cod){
        Product product = productDAO.findById(cod).orElse(null);
        if(product == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping("/newproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product object){
        try{
            productDAO.save(object);
            return ResponseEntity.ok(object);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(403).build();
        }
    }

}