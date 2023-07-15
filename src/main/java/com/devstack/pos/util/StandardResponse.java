package com.devstack.pos.util;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StandardResponse {
    private int code;
    private String massage;
    private Object data;
}
