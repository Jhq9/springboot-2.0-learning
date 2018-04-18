package may.i.jhq.api;

import java.util.List;
import may.i.jhq.model.User;
import may.i.jhq.service.UserService;
import may.i.jhq.vo.UserResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApi {

  /** logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

  @Autowired
  private UserService userService;

  @PostMapping("/users")
  public Long saveUser(@RequestBody User user) {
    LOGGER.info("API 调用 ：保存一个新的用户");

    return userService.saveUser(user);
  }

  @GetMapping("/users")
  public List<User> listUser() {
    LOGGER.info("API 调用 : 列出所有的用户");

    return userService.listUser();
  }

  @GetMapping("/users/{id}")
  public UserResponseVO getUser(@PathVariable Long id) {
    LOGGER.info("API 调用 ：根据id获取用户");

    return userService.getUser(id);
  }

  @PutMapping("/users/{id}")
  public int updateUser(@PathVariable Long id, @RequestBody User use) {
    LOGGER.info("API 调用 ：更新某个用户的信息");

    return userService.updateUser(id, use);
  }
}
