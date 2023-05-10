package com.woowahan.pilot.user.common.advice;

import com.woowahan.pilot.user.common.dto.BaseResponse;
import com.woowahan.pilot.user.common.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GeneralAdvice {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<BaseResponse<Object>> catchBaseException(HttpServletRequest req, BaseException e) {
    log.error(String.format("path: %s / status: %d / code: %s / message: %s", req.getPathInfo(),
        e.getStatus().value(), e.getCode(), e.getMessage()));
    return ResponseEntity.status(e.getStatus())
        .body(new BaseResponse<>(e));
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<BaseResponse<Object>> catchInternalException(HttpServletRequest req, Exception e) {
    log.error(
        String.format("path: %s / status: %d / code: %s / message: %s", req.getPathInfo(), 500,
            HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    return ResponseEntity.status(500)
        .body(new BaseResponse<>(e));
  }
}
