package br.com.aruw.controller;

import java.util.List;
import br.com.aruw.beans.Order;
import br.com.aruw.dao.OrderDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> orders = (List<Order>) orderDAO.findAll();
        if(orders.size() == 0){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/order/{cod}")
    public ResponseEntity<Order> getOrder(@PathVariable int cod){
        Order order = orderDAO.findById(cod).orElse(null);
        if(order == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping("/neworder")
    public ResponseEntity<Order> addOrder(@RequestBody Order object){
        try{
            orderDAO.save(object);
            return ResponseEntity.ok(object);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(403).build();
        }
    }

}