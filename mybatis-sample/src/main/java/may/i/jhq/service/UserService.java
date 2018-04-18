package may.i.jhq.service;

import java.util.List;
import lombok.AllArgsConstructor;
import may.i.jhq.mapper.UserMapper;
import may.i.jhq.model.User;
import may.i.jhq.vo.UserResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

  /** logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  private final UserMapper userMapper;

  /**
   * 保存一个新的用户
   * @param user
   * @return
   */
  @Transactional(rollbackFor = TransactionException.class)
  public Long saveUser(User user) {
    userMapper.save(user);

    return user.getId();
  }

  /**
   * 列出所有的用户
   * @return
   */
  public List<User> listUser() {
    return userMapper.findAll();
  }

  /**
   * 更新用户信息
   * @param id
   * @param user
   * @return
   */
  @Transactional(rollbackFor = TransactionException.class)
  public int updateUser(Long id, User user) {
    user.setId(id);

    return userMapper.update(user);
  }

  public UserResponseVO getUser(Long id) {
    return userMapper.findById(id);
  }
}
