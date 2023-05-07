package com.woowahan.pilot.user.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomException {
  DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "중복된 이메일입니다."),
  DUPLICATED_PHONE(HttpStatus.BAD_REQUEST, "중복된 휴대폰 번호입니다."),
  DUPLICATED_NICKNAME(HttpStatus.BAD_REQUEST, "중복된 닉네임입니다.");

  CustomException(HttpStatus status, String message) {
  }
}
