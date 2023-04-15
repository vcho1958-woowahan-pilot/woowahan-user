package com.woowahan.pilot.user.domain.general.entity;

import com.woowahan.pilot.user.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class User extends BaseEntity {

  @Column(unique = true, length = 30)
  @Email
  private String email;
  @Column(unique = true, length = 15)
  @Length(min = 3, max = 12, message = "length of nickname must be between 3 and 12")
  private String nickname;
  @Column(length = 64)
  private String password;
  @Column(unique = true, length = 11)
  @Pattern(regexp = "^01(?:0|1|[6-9])(\\d{7,8})", message = "phone pattern is wrong")
  private String phone;

  public User(UUID id) {
    super(id);
  }
}
