package com.woowahan.pilot.user.domain.general;

import com.woowahan.pilot.user.domain.general.dto.UserCreateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @PostMapping
  public boolean join(@RequestBody UserCreateDto userCreateDto){
    return false;
  }
}
