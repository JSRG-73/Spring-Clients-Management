package com.JorgeRosas.SB1.controllers;

import com.JorgeRosas.SB1.domain.Customer;
import jakarta.servlet.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")

public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo", "g1", "pw1"),
            new Customer(456, "Alejandra", "a1","pw2"),
            new Customer(789, "Laura", "l1","pw3"),
            new Customer(100, "Carlos", "c1","pw4")
    ));

    //@GetMapping
    @RequestMapping(method =  RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers() {

        return ResponseEntity.ok(customers);
    }

    //@GetMapping("/{username}")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientByID(@PathVariable String username){
        for(Customer c : customers){
            if(c.getUsername().equalsIgnoreCase(username)) return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found for username: " + username);
    }

    //@PostMapping
    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<?> postClient(@RequestBody Customer customer){
        customers.add(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(customer);
        //return ResponseEntity.created(location).build();
        //return ResponseEntity.status(HttpStatus.CREATED).body("Client added successfully: " + customer.getUsername());
    }

    //@PutMapping
    @RequestMapping(method =  RequestMethod.PUT)
    public ResponseEntity<?> putClient(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername((customer.getUsername()));
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //@DeleteMapping("{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable int id){
        for(Customer c : customers){
            if(c.getID() == id) {
                customers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    //@PatchMapping
    @RequestMapping( method = RequestMethod.PATCH)
    public ResponseEntity<?> patchClient(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getID() == customer.getID()){
                if(customer.getName()!=null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername()!=null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword()!=null){
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity.ok("Client updated successfully: " + customer.getID());
            }
        }
        return ResponseEntity.notFound().build();
    }
}