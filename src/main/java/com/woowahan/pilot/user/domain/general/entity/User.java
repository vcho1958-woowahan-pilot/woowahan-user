package com.woowahan.pilot.user.domain.general.entity;

import com.woowahan.pilot.user.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.UUID;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class User extends BaseEntity {

  @Column(unique = true, length = 30)
  private String email;
  @Column(unique = true, length = 15)
  private String nickname;
  @Column(length = 30)
  private String password;
  @Column(unique = true, length = 11)
  private String phone;

  public User(UUID id) {
    super(id);
  }
}
