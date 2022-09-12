package com.example.restfullapp.service;

import com.example.restfullapp.model.DataModel;

import java.util.List;
import java.util.Optional;

public interface DataService {
    boolean save(DataModel dataModel);
    DataModel findById(Long id);
    DataModel findByText(String text);
    List<DataModel> findAll();
    void delete(Long id);
}
