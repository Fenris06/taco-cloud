package rsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GratuityClientApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(GratuityClientApplication.class, args);
        Thread.sleep(10000);
    }
}
