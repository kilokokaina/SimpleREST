package com.example.restfullapp.controller;

import com.example.restfullapp.model.DataModel;
import com.example.restfullapp.model.Views;
import com.example.restfullapp.service.impl.DataServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("data")
public class MainController {
    private final DataServiceImpl dataService;

    @Autowired
    public MainController(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    @JsonView(Views.IdAndData.class)
    public List<DataModel> list() {
        return dataService.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullData.class)
    public DataModel getOne(@PathVariable(value = "id") DataModel dataModel) {
        return dataModel;
    }

    @PostMapping
    public DataModel create(@RequestBody DataModel dataModel) {
        dataService.save(dataModel);
        return dataModel;
    }

    @PutMapping("{id}")
    public DataModel update(@PathVariable(value = "id") DataModel dataFromDB,
                            @RequestBody DataModel dataModel) {
        dataFromDB.setText(dataModel.getText());
        dataService.save(dataFromDB);

        return dataFromDB;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value = "id") DataModel dataModel) {
        dataService.delete(dataModel.getId());
    }
}
