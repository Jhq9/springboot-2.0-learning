package may.i.jhq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EntityScan(basePackages = "may.i.jhq.model")
@EnableJpaRepositories(basePackages = "may.i.jhq.repository")
public class JpaSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSampleApplication.class, args);
    }
}
