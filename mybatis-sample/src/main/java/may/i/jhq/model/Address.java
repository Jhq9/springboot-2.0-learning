package may.i.jhq.model;

import java.io.Serializable;
import lombok.Data;

/**
 *  收货地址
 *  @author    May
 *  @date      2018/4/21 19:07
 *  @version   1.0
 */
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String detail;

    private Long userId;
}
