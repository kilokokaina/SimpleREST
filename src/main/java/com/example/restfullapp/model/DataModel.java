package com.example.restfullapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "data_t")
public class DataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.IdAndData.class)
    private Long id;

    @JsonView(Views.IdAndData.class)
    private String text;

    @Column(updatable = false)
    @JsonView(Views.FullData.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDate = LocalDateTime.now();
}
