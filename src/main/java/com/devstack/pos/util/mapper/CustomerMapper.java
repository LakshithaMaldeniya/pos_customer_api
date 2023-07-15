package com.devstack.pos.util.mapper;

import com.devstack.pos.dto.core.CustomerDto;
import entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerDto dto);
}
