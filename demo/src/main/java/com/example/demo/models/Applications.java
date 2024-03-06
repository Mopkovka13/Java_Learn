package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Applications {
    private int id;
    private String name;
    private String author;
    private String version;
}
