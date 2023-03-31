package com.servico.email.services;

import java.time.LocalDateTime;

import com.servico.email.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.servico.email.enums.StatusEmail;
import com.servico.email.models.EmailModel;
import com.servico.email.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	@Autowired
	private JavaMailSender mailSender;
	public void enviarEmail(EmailModel emailModel) {
		emailModel.setSendDateEmail(LocalDateTime.now());
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailModel.getMailTo());
		message.setSubject(emailModel.getSubject());
		message.setText(emailModel.getText());

		mailSender.send(message);
	}
}
