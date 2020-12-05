package com.numbers.numbers.controller;

import com.numbers.numbers.dto.NumberRequest;
import com.numbers.numbers.operations.NumberOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class NumberController {

    @Autowired
    private NumberOperations numberOperations;

    @PostMapping("/get-numbers")
    public ResponseEntity<List<String>> getNumberList(@RequestBody NumberRequest numberRequest) {
        return numberOperations.generateString(numberRequest);
    }
}
