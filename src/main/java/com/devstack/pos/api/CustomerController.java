package com.devstack.pos.api;

import com.devstack.pos.db.Database;
import com.devstack.pos.dto.request.RequestCustomerDto;
import com.devstack.pos.service.CustomerService;
import com.devstack.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(
            @RequestBody RequestCustomerDto dto
    ) {
        var savedData = customerService.createCustomer(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"customer saved!",savedData),
                HttpStatus.CREATED
        );
    }


    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateCustomer(
            @RequestParam int id,
            @RequestBody RequestCustomerDto customerDto
    ) throws ClassNotFoundException {

        var savedData = Database.updateCustomer(customerDto,id);
        return new ResponseEntity<>(
                new StandardResponse(201,"customer Updated!",savedData),
                HttpStatus.CREATED
        );
    }



    @DeleteMapping(params = "id")
    public ResponseEntity<StandardResponse> deleteCustomer(
            @RequestParam int id
    ) throws ClassNotFoundException {
        Database.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"customer Deleted!",null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable int id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "customer Data!", customerService.findCustomer(id)),
                HttpStatus.OK
        );
    }


    @GetMapping(value = "/list", params = {"page","size","searchText"})
    public ResponseEntity<StandardResponse> getAllCustomers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String searchText
    ) {

        return new ResponseEntity<>(
                new StandardResponse(200,"customer list"
                        ,Database.searchAllCustomers(page, size, searchText)),
                HttpStatus.OK
        );
    }


}
