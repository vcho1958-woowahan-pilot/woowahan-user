package com.woowahan.pilot.user.common.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ExceptionController {
  @GetMapping("/custom")
  public void customExceptionAdvice() {
    throw new BaseException(CustomException.DUPLICATED_NICKNAME);
  }

  @GetMapping("/internal")
  public void InternalExceptionAdvice() {
    throw new IllegalArgumentException("내부 오류 테스트입니다.");
  }
}
