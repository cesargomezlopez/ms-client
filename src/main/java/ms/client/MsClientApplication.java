package ms.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class MsClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsClientApplication.class, args);
  }
}
