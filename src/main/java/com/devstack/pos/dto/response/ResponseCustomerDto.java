package com.devstack.pos.dto.response;

import lombok.*;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseCustomerDto {
    private long publicId;
    private String name;
    private String address;
    private double salary;
    private boolean activeState;
}
