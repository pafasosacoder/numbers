package com.numbers.numbers;

import com.numbers.numbers.dto.NumberRequest;
import com.numbers.numbers.model.RequestLog;
import com.numbers.numbers.repository.RequestLogRepository;
import com.numbers.numbers.service.NumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NumberServiceTest {

    @Mock
    private RequestLogRepository requestLogRepository;

    @InjectMocks
    private NumberService numberService;

    @Test
    public void shouldGiveErrorOnGenerateStringWhenParameterIsInvalid() {

        NumberRequest numberRequest = NumberRequest.builder().finalNumber(0).build();
        ResponseEntity<List<String>> result = numberService.generateString(numberRequest);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.PRECONDITION_FAILED);
        verify(requestLogRepository,never()).saveAndFlush(any(RequestLog.class));
    }

    @Test
    public void shouldGenerateStringWhenMaxNumberIsThreeMultiple() {
        NumberRequest numberRequest = NumberRequest.builder().finalNumber(3).build();
        ResponseEntity<List<String>> result = numberService.generateString(numberRequest);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().get(0)).isEqualTo("1");
        assertThat(result.getBody().get(1)).isEqualTo("2");
        assertThat(result.getBody().get(2)).isEqualTo(NumberService.FIZZ);

        verify(requestLogRepository).saveAndFlush(any(RequestLog.class));

    }

    @Test
    public void shouldGenerateStringWhenMaxNumberIsFiveMultiple() {
        NumberRequest numberRequest = NumberRequest.builder().finalNumber(5).build();
        ResponseEntity<List<String>> result = numberService.generateString(numberRequest);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().get(0)).isEqualTo("1");
        assertThat(result.getBody().get(1)).isEqualTo("2");
        assertThat(result.getBody().get(2)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(3)).isEqualTo("4");
        assertThat(result.getBody().get(4)).isEqualTo(NumberService.BUZZ);

        verify(requestLogRepository).saveAndFlush(any(RequestLog.class));

    }

    @Test
    public void shouldGenerateStringWhenMaxNumberIsSevenMultiple() {
        NumberRequest numberRequest = NumberRequest.builder().finalNumber(7).build();
        ResponseEntity<List<String>> result = numberService.generateString(numberRequest);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().get(0)).isEqualTo("1");
        assertThat(result.getBody().get(1)).isEqualTo("2");
        assertThat(result.getBody().get(2)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(3)).isEqualTo("4");
        assertThat(result.getBody().get(4)).isEqualTo(NumberService.BUZZ);
        assertThat(result.getBody().get(5)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(6)).isEqualTo(NumberService.JAZZ);

        verify(requestLogRepository).saveAndFlush(any(RequestLog.class));

    }

    @Test
    public void shouldGenerateString() {
        NumberRequest numberRequest = NumberRequest.builder().finalNumber(21).build();
        ResponseEntity<List<String>> result = numberService.generateString(numberRequest);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().get(0)).isEqualTo("1");
        assertThat(result.getBody().get(1)).isEqualTo("2");
        assertThat(result.getBody().get(2)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(3)).isEqualTo("4");
        assertThat(result.getBody().get(4)).isEqualTo(NumberService.BUZZ);
        assertThat(result.getBody().get(5)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(6)).isEqualTo(NumberService.JAZZ);
        assertThat(result.getBody().get(7)).isEqualTo("8");
        assertThat(result.getBody().get(8)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(9)).isEqualTo(NumberService.BUZZ);
        assertThat(result.getBody().get(10)).isEqualTo("11");
        assertThat(result.getBody().get(11)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(12)).isEqualTo("13");
        assertThat(result.getBody().get(13)).isEqualTo(NumberService.JAZZ);
        assertThat(result.getBody().get(14)).isEqualTo(NumberService.FIZZ.concat(NumberService.BUZZ));
        assertThat(result.getBody().get(15)).isEqualTo("16");
        assertThat(result.getBody().get(16)).isEqualTo("17");
        assertThat(result.getBody().get(17)).isEqualTo(NumberService.FIZZ);
        assertThat(result.getBody().get(18)).isEqualTo("19");
        assertThat(result.getBody().get(19)).isEqualTo(NumberService.BUZZ);
        assertThat(result.getBody().get(20)).isEqualTo(NumberService.FIZZ.concat(NumberService.JAZZ));

        verify(requestLogRepository).saveAndFlush(any(RequestLog.class));
    }

}
