package com.example.restfullapp.repository;

import com.example.restfullapp.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataModel, Long> {
    DataModel findDataModelByText(String text);
}
