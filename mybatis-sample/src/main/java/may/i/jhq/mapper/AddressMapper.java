package may.i.jhq.mapper;

import java.util.List;
import may.i.jhq.model.Address;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AddressMapper {

    /**
       * 根据id获取地址详情
       * @param id 地址id
       * @return Address 地址详情
       */
      @Select("SELECT id,detail,user_id FROM m_address WHERE id = #{id}")
      Address findById(@Param("id") Long id);

      /**
       * 根据用户id查询出所有的地址列表
       * @return List<Address> 所有的地址
       */
      @Select("SELECT id,detail,user_id FROM m_address WHERE user_id = #{userId}")
      List<Address> findByUserId(@Param("userId") Long userId);

      /**
       * 保存一个新的地址
       * @param address 要保存的地址
       */
      @Insert("INSERT INTO m_address (detail, user_id) VALUES (#{address.detail}, #{address.userId}) "
                  + "RETURNING id")
      @Options(useGeneratedKeys = true, keyProperty = "address.id")
      void save(@Param("address") Address address);

      /**
       * 根据类别id删除地址
       * @param id 地址id
       * @return 删除的条数
       */
      @Delete("DELETE FROM m_address WHERE id = #{id}")
      int delete(@Param("id") Long id);

}
