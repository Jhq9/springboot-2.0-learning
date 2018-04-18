package may.i.jhq;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 *  @author    May
 *  @date      2018/4/17 13:18
 *  @version   1.0
 */
@Data
public class Customer implements Serializable {

  /**
   * 客户编号
   */
  @Id
  private String id;
  /**
   * 客户名称
   */
  private String firstName;
  /**
   * 客户姓氏
   */
  private String lastName;

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
