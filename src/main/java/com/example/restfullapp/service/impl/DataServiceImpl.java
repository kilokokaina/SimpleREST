package com.example.restfullapp.service.impl;

import com.example.restfullapp.config.NotFoundException;
import com.example.restfullapp.model.DataModel;
import com.example.restfullapp.repository.DataRepository;
import com.example.restfullapp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;

    @Autowired
    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public boolean save(DataModel dataModel) {
        dataRepository.save(dataModel);
        return true;
    }

    @Override
    public DataModel findById(Long id) {
        return dataRepository.findById(id).orElseThrow(
                NotFoundException::new
        );
    }

    @Override
    public DataModel findByText(String text) {
        return dataRepository.findDataModelByText(text);
    }

    @Override
    public List<DataModel> findAll() {
        return dataRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        dataRepository.deleteById(id);
    }
}
