package may.i.jhq;

import may.i.jhq.mapper.RoleMapper;
import may.i.jhq.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *  Springboot mybatis sample
 *  @author    May
 *  @date      2018/4/17 21:51
 *  @version   1.0
 */
@EnableWebMvc
@SpringBootApplication
public class MybatisSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisSampleApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(RoleMapper roleMapper) {
    return args -> {
      if (roleMapper.findByName("ADMIN") == null) {
        Role role = new Role();

        role.setName("ADMIN");

        roleMapper.save(role);
      }
    };
  }
}
