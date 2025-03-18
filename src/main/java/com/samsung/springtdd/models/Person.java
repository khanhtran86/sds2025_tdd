package com.samsung.springtdd.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
