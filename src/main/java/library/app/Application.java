package library.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"library"})
@EntityScan(basePackages = "library.entity" )
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

