package br.com.aruw.controller;

import br.com.aruw.dao.OrderDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

}