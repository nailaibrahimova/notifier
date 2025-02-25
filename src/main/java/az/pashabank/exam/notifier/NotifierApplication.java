package az.pashabank.exam.notifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class NotifierApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotifierApplication.class, args);
    }

}
