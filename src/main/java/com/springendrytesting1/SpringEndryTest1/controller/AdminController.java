package com.springendrytesting1.SpringEndryTest1.controller;

import com.springendrytesting1.SpringEndryTest1.model.*;
import com.springendrytesting1.SpringEndryTest1.repository.*;
import com.springendrytesting1.SpringEndryTest1.response.*;
import com.springendrytesting1.SpringEndryTest1.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2")
public class AdminController {

    @Autowired
    ProductRepository productRepo;

    //Get List of All Products
    @GetMapping("/products")
    public ResponseEntity<prodResp> getAllProducts() throws IOException{
        prodResp resp=new prodResp();

        try{

            resp.setOblist(productRepo.findAll());
        }
        catch(Exception e){
            resp.setMessage(e.getMessage());
        }

        return new ResponseEntity<prodResp>(resp,HttpStatus.ACCEPTED);

    }

    //Get the product details
    /*@GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value="id") Long productId)
            throws ResourceNotFoundException {

        Product product= productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product detail not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);

    }*/

    //Insert products into the database
    @PostMapping("/products/create")
    public ResponseEntity<prodResp> saveProduct(@RequestParam("file") MultipartFile prodImage,
                                                @RequestParam("productName") String productName,
                                                @RequestParam("description") String description,
                                                @RequestParam("price") String price,
                                                @RequestParam("quantity") String quantity
                                                ) throws IOException {

          Product prod= new Product();
          prod.setProductName(productName);
          prod.setDescription(description);
          prod.setPrice(Double.parseDouble(price));
          prod.setQuantity(Integer.parseInt(quantity));
          prod.setPhoto(prodImage.getBytes());
          productRepo.save(prod);

        if (prod != null) {
            return new ResponseEntity<prodResp>(new prodResp(), HttpStatus.OK);
        } else {
            return new ResponseEntity<prodResp>(new prodResp(), HttpStatus.BAD_REQUEST);
        }

    }

}
