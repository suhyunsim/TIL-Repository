package com.poogle.springbootgettingstarted;

import com.poogle.springbootstarter.Holoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    //이렇게 이 플젝에서 Bean을 재정의하면 에러메세지가 뜸
    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setName("k");
        holoman.setHowLong(60);
        return holoman;
    }
}
