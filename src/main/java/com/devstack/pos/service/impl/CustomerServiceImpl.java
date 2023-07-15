package com.devstack.pos.service.impl;

import com.devstack.pos.dto.core.CustomerDto;
import com.devstack.pos.dto.request.RequestCustomerDto;
import com.devstack.pos.dto.response.ResponseCustomerDto;
import com.devstack.pos.dto.response.paginated.model.CustomerPaginatedDto;
import com.devstack.pos.repo.CustomerRepo;
import com.devstack.pos.service.CustomerService;
import com.devstack.pos.util.mapper.CustomerMapper;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private Exception ClassNotFoundException;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto) {

        CustomerDto customerDto = new CustomerDto(
                0,
                new Random().nextInt(100001),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                true,
                null,
                null,
                null,
                null
        );

//        Customer customer = new Customer(
//                0,
//                customerDto.getPublicId(),
//                customerDto.getName(),
//                customerDto.getAddress(),
//                customerDto.getSalary(),
//                customerDto.isActiveState(),
//                null
//        );

        customerRepo.save(customerMapper.toCustomer(customerDto));

        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState()
        );
    }

    @Override
    public ResponseCustomerDto findCustomer(long id) throws ClassNotFoundException {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);
        if (selectedCustomer.isPresent()){
            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()
            );
        }
        throw new ClassNotFoundException();
    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto, long id) throws Exception {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);
        if (selectedCustomer.isPresent()){
            selectedCustomer.get().setName(dto.getName());
            selectedCustomer.get().setAddress(dto.getAddress());
            selectedCustomer.get().setSalary(dto.getSalary());

            customerRepo.save(selectedCustomer.get());
        }
        throw ClassNotFoundException;
    }

    @Override
    public void deleteCustomer(long id) {

    }

    @Override
    public CustomerPaginatedDto searchAllCustomers(int page, int size, String searchText) {
        return null;
    }
}