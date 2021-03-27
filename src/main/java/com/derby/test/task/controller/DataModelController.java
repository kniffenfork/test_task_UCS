package com.derby.test.task.controller;

import com.derby.test.task.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/db2any")
public class DataModelController {

    private final DataService dataService;


    public DataModelController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(path="/bykey/getjson", params="key")
    public ResponseEntity<?> findDataById(@RequestParam("key") Long id) {
        return dataService.findById(id);
    }
}
