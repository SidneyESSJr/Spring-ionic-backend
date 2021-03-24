package br.com.backend.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.backend.services.DBService;

@Configuration // define que é uma classe de configuração
@Profile("dev") // indica qual o profile esta classe esta configurando
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (strategy.equals("create")) {
            dbService.instantiateTestDatabase();
            return true;
        }

        return false;
    }

}
