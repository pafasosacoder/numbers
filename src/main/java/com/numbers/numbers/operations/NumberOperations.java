package com.numbers.numbers.operations;

import com.numbers.numbers.dto.NumberRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NumberOperations {

    ResponseEntity<List<String>> generateString(NumberRequest numberRequest);

}
