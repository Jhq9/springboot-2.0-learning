package may.i.jhq.mapper;

import java.util.List;
import may.i.jhq.enums.SexEnum;
import may.i.jhq.model.User;
import may.i.jhq.vo.UserResponseVO;
import org.apache.ibatis.annotations.*;

/**
 * 用户Mapper
 *
 * @author May
 * @version 1.0
 * @date 2018/4/17 22:08
 */
@Mapper
public interface UserMapper {

    @Select("SELECT id, name, sex, role_id FROM m_user")
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "sex", column = "sex", javaType = SexEnum.class),
        @Result(property = "roleId", column = "role_id")
    })
    List<User> findAll();

    @Select("SELECT id, name, sex, role_id FROM m_user WHERE id = #{id}")
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "sex", column = "sex", javaType = SexEnum.class),
        @Result(property = "role", column = "role_id",
            one = @One(select = "may.i.jhq.mapper.RoleMapper.findById")),
        @Result(property = "addresses", column = "id",
            many = @Many(select = "may.i.jhq.mapper.AddressMapper.findByUserId"))
    })
    UserResponseVO findById(@Param("id") Long id);

    /**
     * 对用户进行信息更新
     */
    @Update("<script>UPDATE m_user <set> <if test = \"user.name != null and user.name != '' \">"
                + "name = #{user.name}, </if> <if test = \"user.sex != null\"> sex = #{user.sex},"
                + "</if> <if test = \"user.roleId != null\"> role_id = #{user.roleId}></if> </set>"
                + "WHERE id = #{user.id} </script>")
    int update(@Param("user") User user);

    /**
     * 新增一个用户
     */
    @Insert("INSERT INTO m_user (name, sex, role_id) VALUES (#{user.name}, #{user.sex}, #{user.roleId})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    void save(@Param("user") User user);

}
