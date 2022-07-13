package com.example.demo.search;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}