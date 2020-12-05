package com.numbers.numbers.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestLog implements Serializable {

    @Id
    private LocalDateTime dateHour;

    @NotNull
    private Integer finalNumber;

}
