package com.devstack.pos.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RequestCustomerDto {
    private String name;

    private String address;
    private double salary;
}
