package may.i.jhq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 *  @author    May
 *  @date      2018/4/17 13:24
 *  @version   1.0
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages = "may.i.jhq")
public class MongodbSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(MongodbSampleApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
    return args -> {
      customerRepository.deleteAll();
      customerRepository.save(new Customer("Jin", "Huaquan"));

      System.out.println(customerRepository.findAll());
    };
  }
}
