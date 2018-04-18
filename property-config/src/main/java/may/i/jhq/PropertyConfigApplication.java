package may.i.jhq;

import java.util.Arrays;
import java.util.List;
import javax.crypto.Cipher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 *
 *  @author    May
 *  @date      2018/4/16 12:58
 *  @version   1.0
 */
@SpringBootApplication
@ConfigurationProperties(prefix = "myrandom")
public class PropertyConfigApplication {

  @Value(value = "${myrandom.random-value}")
  private String value;

  @Value(value = "${myrandom.uuid}")
  private String uuid;

  @Value(value = "${myrandom.int-value}")
  private int intValue;

  @Value(value = "${myrandom.long-value}")
  private long longValue;

  @Value(value = "${myrandom.less-value}")
  private long lessValue;

  @Value(value = "${myrandom.range-value}")
  private int rangeValue;

  /**
   *  数组不能通过@Value注解来注入
   *  @author    May
   *  @date      2018/4/16 13:11
   *  @version   1.0
   */
  private List<String> arrays;

  public List<String> getArrays() {
    return arrays;
  }

  public void setArrays(List<String> arrays) {
    this.arrays = arrays;
  }

  public static void main(String[] args) {
    SpringApplication.run(PropertyConfigApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner() {

    return args -> Arrays.asList(value, uuid, intValue, lessValue, longValue, getArrays())
                          .forEach(System.out::println);

  }

  /**
   * Spring 2.0新增的获取配置数据的方式
   * @param environment
   * @return
   */
  @Bean
  public CommandLineRunner propertyBinder(Environment environment){

    return args -> Binder.get(environment).bind("myrandom.arrays", List.class)
                                            .ifBound(System.out::println);

  }
}
