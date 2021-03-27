package com.derby.test.task.service.implementation;

import com.derby.test.task.model.DataModel;
import com.derby.test.task.repository.DataRepository;
import com.derby.test.task.service.DataService;
import com.derby.test.task.service.exception.IdNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataServiceImplTest {

    @Autowired
    private DataService                 dataService;

    @MockBean
    private DataRepository              dataRepository;

    private static DataModel            testData;
    private static final Long           TEST_ID = 1L;
    private static final String         TEST_VALUE = "TEST_VALUE";

    @BeforeEach
    void setup() {
        testData = new DataModel();
        testData.setId(TEST_ID);
        testData.setValue(TEST_VALUE);
    }

    @Test
    void checkDataIsValidWithNullData() {
        testData = new DataModel();
        try {
            dataService.checkDataIsValid(testData);
            assertEquals("Exception catched", "Exception catched");
        } catch (IdNotFoundException e) {
            assertEquals("Exception catched", "Exception haven't catched.");
        }
    }

    @Test
    void findByIdWhenIdExists() {
        Mockito.when(dataRepository.findByIdEquals(TEST_ID)).thenReturn(testData);
        assertEquals(HttpStatus.OK, dataService.findById(TEST_ID).getStatusCode());
    }

    @Test
    void findByIdWhenIdNotExists() {
        testData = null;
        Mockito.when(dataRepository.findByIdEquals(TEST_ID)).thenReturn(testData);
        assertEquals(HttpStatus.NOT_FOUND, dataService.findById(TEST_ID).getStatusCode());
    }
}