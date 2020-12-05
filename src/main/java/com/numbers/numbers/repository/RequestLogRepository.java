package com.numbers.numbers.repository;

import com.numbers.numbers.model.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, LocalDateTime> {

}
