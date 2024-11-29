package com.apirest.demo.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apirest.demo.domain.Customer;

@RestController
// unificación de rutas a nivel de clase
@RequestMapping("/clientes")
public class CustomerRestController {
    private List<Customer> customers = new ArrayList<>(
            Arrays.asList(
                    new Customer(1, "John", "UserJhon", "1234"),
                    new Customer(2, "Aljandro", "alejandro", "3456"),
                    new Customer(3, "Martinez", "martienz", "6789"),
                    new Customer(3, "Carlos", "carlos", "1254")));

    // Ambas significan los mismo, respodera a las peticiones GET
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        // return customers;
        // permite generar codigos de respuesta de tipo 200 (peticion exitosa)
        return ResponseEntity.ok(customers/* objeto que retornaremos */);
    }

    // para usar parametros web
    // @RequestMapping(value = "/{username}", method = RequestMethod.GET)
     @GetMapping("/{username}")
    public ResponseEntity<?/* el retorno puede variar */> getCliente(@PathVariable String username) {
        for (Customer v : customers) {
            if (v.getName().equalsIgnoreCase(username)) {
                System.out.println(v.getName());
                return ResponseEntity.ok(v);
            }
        }
        // return null;
        return ResponseEntity.status(HttpStatus.NOT_FOUND/* respuesta 404 (recurso no encontrado) */)
                .body("Cliente no encontrado con usernames: " + username/* Es mala practica retornar un null */);
    }

    // metodo post para recibir objetos de tipos JSon y transformarlo a Customer
    // El metodo permite o le diceal servidor registrar un nuevo registro con los
    // datosen JSon enviados desde el cliente

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername()).toUri();

        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado
        // exitosamente" + customer.getName());

        // return customer;
    }

    // metodo PUT para poder actualizar registros del servidor

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (customer.getID() == c.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    // metodo DELETE para eliminar registros
    // @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
     @DeleteMapping("/{Id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int Id) {
        for (Customer c : customers) {
            if (c.getID() == Id) {
                customers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    // metodo PATCHMapping para poder modificar solo algunos campos
    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                if (customer.getName() == null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() == null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() == null) {
                    c.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Objeto " + customer.getID() + " no encontrado");
    }

}
