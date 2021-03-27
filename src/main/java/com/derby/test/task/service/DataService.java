package com.derby.test.task.service;

import com.derby.test.task.model.DataModel;
import org.springframework.http.ResponseEntity;

public interface DataService {
    ResponseEntity<?>           findById(Long id);
    void                        checkDataIsValid(DataModel data);
}
