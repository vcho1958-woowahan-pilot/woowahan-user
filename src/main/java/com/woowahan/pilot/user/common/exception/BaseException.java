package com.woowahan.pilot.user.common.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseException extends RuntimeException {
  private HttpStatus status;
  private String message;
  private String code;

  public BaseException(Exception e) {
    status = HttpStatus.INTERNAL_SERVER_ERROR;
    message = e.getMessage();
    code = HttpStatus.INTERNAL_SERVER_ERROR.name();
  }

  public BaseException(CustomException e) {
    status = e.status;
    message = e.message;
    code = e.name();
  }
}
