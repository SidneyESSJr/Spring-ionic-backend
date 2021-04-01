package br.com.backend.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.backend.domains.Pedido;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

}
