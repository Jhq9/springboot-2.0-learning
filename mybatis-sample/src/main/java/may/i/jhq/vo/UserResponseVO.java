package may.i.jhq.vo;

import lombok.Data;
import may.i.jhq.enums.SexEnum;
import may.i.jhq.model.Role;

@Data
public class UserResponseVO {

  private Long id;

  private String name;

  private SexEnum sex;

  private Role role;

}
