package may.i.jhq.mapper;

import java.util.List;
import may.i.jhq.model.Role;
import org.apache.ibatis.annotations.*;

/**
 * 角色Mapper
 * @author May
 * @version 1.0
 * @date 2018/4/17 22:55
 */
@Mapper
public interface RoleMapper {

  /**
   * 根据id获取角色详情
   *
   * @param id 角色id
   * @return Role 角色详情
   */
  @Select("SELECT id, name FROM m_role WHERE id = #{id}")
  Role findById(@Param("id") Long id);

  @Select("SELECT id, name FROM m_role WHERE name = #{name}")
  Role findByName(@Param("name") String name);

  /**
   * 查询出所有的角色列表
   *
   * @return List<Role> 所有的角色
   */
  @Select("SELECT id, name FROM m_role")
  List<Role> findAll();

  /**
   * 保存一个新的角色
   *
   * @param role 要保存的角色
   */
  @Insert("INSERT INTO m_role (name) VALUES (#{role.name})")
  @Options(useGeneratedKeys = true, keyProperty = "role.id")
  void save(@Param("role") Role role);

  /**
   * 对角色信息进行更新
   *
   * @param role 要进行更新的角色信息
   * @return int 返回更新条数
   */
  @Update("<script> UPDATE m_role"
      + "<set>"
      + "<if test = \"role.name != null and role.name != ''\">"
      + "name = #{role.name}"
      + "</if>"
      + "</set>"
      + "WHERE id = #{role.id} </script>")
  int update(@Param("role") Role role);

  /**
   * 根据类别id删除角色
   *
   * @param id 角色id
   * @return 删除的条数
   */
  @Delete("DELETE FROM m_role WHERE id = #{id}")
  int delete(@Param("id") Long id);
}
