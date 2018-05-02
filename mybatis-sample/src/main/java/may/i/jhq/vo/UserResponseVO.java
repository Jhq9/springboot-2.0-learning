package may.i.jhq.vo;

import java.util.List;
import lombok.Data;
import may.i.jhq.enums.SexEnum;
import may.i.jhq.model.Address;
import may.i.jhq.model.Role;

@Data
public class UserResponseVO {

  private Long id;

  private String name;

  private SexEnum sex;

  private Role role;

  List<Address> addresses;
}
