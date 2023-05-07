package com.woowahan.pilot.user.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.woowahan.pilot.user.common.exception.BaseException;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
  private final boolean success;
  private final T data;
  private final BaseException error;

  public BaseResponse(BaseException exception) {
    success = false;
    data = null;
    error = exception;
  }

  public BaseResponse(Exception exception) {
    success = false;
    data = null;
    error = new BaseException(exception);
  }
  public BaseResponse(T data) {
    success = true;
    this.data = data;
    error = null;
  }
}
