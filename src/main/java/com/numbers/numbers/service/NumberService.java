package com.numbers.numbers.service;

import com.numbers.numbers.dto.NumberRequest;
import com.numbers.numbers.model.RequestLog;
import com.numbers.numbers.operations.NumberOperations;
import com.numbers.numbers.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService implements NumberOperations {

    @Autowired
    private RequestLogRepository requestLogRepository;

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String JAZZ = "Jazz";

    @Override
    @Transactional
    public ResponseEntity<List<String>> generateString(NumberRequest numberRequest) {
        List<String> stringList = new ArrayList<>();

        if (numberRequest.getFinalNumber() <= 0) {
            return new ResponseEntity(stringList, HttpStatus.PRECONDITION_FAILED);
        }

        for (int i = 1; i <= numberRequest.getFinalNumber(); i++) {

            String strValue = "";
            if (isThreeMultiple(i)) {
                strValue = strValue.concat(FIZZ);
            }
            if (isFiveMultiple(i)) {
                strValue = strValue.concat(BUZZ);
            }
            if (isSevenMultiple(i)) {
                strValue = strValue.concat(JAZZ);
            }

            if (!(isThreeMultiple(i) || isFiveMultiple(i) || isSevenMultiple(i))) {
                strValue = String.valueOf(i);
            }

            stringList.add(strValue);
        }

        requestLogRepository.saveAndFlush(RequestLog.builder().dateHour(LocalDateTime.now()).finalNumber(numberRequest.getFinalNumber()).build());
        return new ResponseEntity(stringList, HttpStatus.OK);
    }

    private boolean isSevenMultiple(int i) {
        return i % 7 == 0;
    }

    private boolean isFiveMultiple(int i) {
        return i % 5 == 0;
    }

    private boolean isThreeMultiple(int i) {
        return i % 3 == 0;
    }
}

