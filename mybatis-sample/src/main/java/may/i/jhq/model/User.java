package may.i.jhq.model;

import java.io.Serializable;
import lombok.Data;
import may.i.jhq.enums.SexEnum;

/**
 *  用户
 *  @author    May
 *  @date      2018/4/17 22:06
 *  @version   1.0
 */
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private SexEnum sex;

  private Long roleId;
}
