package com.devstack.pos.service;

import com.devstack.pos.dto.request.RequestCustomerDto;
import com.devstack.pos.dto.response.ResponseCustomerDto;
import com.devstack.pos.dto.response.paginated.model.CustomerPaginatedDto;

public interface CustomerService {
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto);

    public  ResponseCustomerDto findCustomer(long id) throws ClassNotFoundException;

    public  ResponseCustomerDto updateCustomer(RequestCustomerDto dto, long id) throws Exception;

    public  void deleteCustomer(long id);

    public  CustomerPaginatedDto searchAllCustomers(int page, int size, String searchText);


}
