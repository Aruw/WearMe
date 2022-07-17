package br.com.aruw.controller;

import java.util.List;
import br.com.aruw.beans.Address;
import br.com.aruw.dao.AddressDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin("*")
public class AddressController {

    @Autowired
    private AddressDAO addressDAO;

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAll(){
        List<Address> addresses = (List<Address>) addressDAO.findAll();
        if(addresses.size() == 0){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/address/{cod}")
    public ResponseEntity<Address> getAddress(@PathVariable int cod){
        Address address = addressDAO.findById(cod).orElse(null);
        if(address == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(address);
    }

    @PostMapping("/newaddress")
    public ResponseEntity<Address> addAddress(@RequestBody Address object){
        try{
            addressDAO.save(object);
            return ResponseEntity.ok(object);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(403).build();
        }
    }

}