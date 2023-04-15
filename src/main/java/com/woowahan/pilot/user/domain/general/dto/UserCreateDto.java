package com.woowahan.pilot.user.domain.general.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
@AllArgsConstructor
public class UserCreateDto {
  @Email
  private String email;
  @Length(min = 3, max = 12, message = "length of nickname must be between 3 and 12")
  private String nickname;
  @Length(min = 8, max = 20, message = "length of password must be between 8 and 20")
  private String password;
  @Pattern(regexp = "^01(?:0|1|[6-9])(\\d{7,8})", message = "phone pattern is wrong")
  private String phone;
}
