package com.example.restfullapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "data_t")
public class DataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
}
