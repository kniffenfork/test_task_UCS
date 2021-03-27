package com.derby.test.task.service.implementation;

import com.derby.test.task.model.DataModel;
import com.derby.test.task.repository.DataRepository;
import com.derby.test.task.service.DataService;
import com.derby.test.task.service.exception.IdNotFoundException;
import com.derby.test.task.service.response.GetDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void checkDataIsValid(DataModel data) {
        if (data == null) {
            throw new IdNotFoundException();
        }
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        try {
            DataModel data = dataRepository.findByIdEquals(id);
            checkDataIsValid(data);
            return new ResponseEntity<GetDataResponse>(new GetDataResponse(data, "OK", id), HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<GetDataResponse>(new GetDataResponse(null, "NOT FOUND", id), HttpStatus.NOT_FOUND);
        }
    }
}
