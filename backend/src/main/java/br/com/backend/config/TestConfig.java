package br.com.backend.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.backend.services.DBService;
import br.com.backend.services.EmailService;
import br.com.backend.services.MockEmailService;

@Configuration // define que é uma classe de configuração
@Profile("test") // indica qual o profile esta classe esta configurando
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    } 

}
