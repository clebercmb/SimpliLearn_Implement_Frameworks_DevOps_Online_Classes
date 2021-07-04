package com.example.spring.data.access.dto;

import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Data
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Stock {

    @NonNull
    @Size(max=10)
    String id;

    @NonNull
    @Size(max=100)
    String name;

    @NonNull
    @DecimalMin("0.01")
    Double price;


}
