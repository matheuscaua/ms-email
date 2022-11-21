package com.servico.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.servico.email.enums.StatusEmail;
import com.servico.email.models.EmailModel;
import com.servico.email.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private MailSender mailSender;
	
	
	public void enviarEmail(EmailModel emailModel) {
		
		emailModel.setSendDateEmail(LocalDateTime.now());
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailModel.getMailFrom());
		message.setTo(emailModel.getMailTo());
		message.setSubject(emailModel.getSubject());
		message.setText(emailModel.getText());
		
		mailSender.send(message);
		
		emailModel.setStatusEmail(StatusEmail.SENT);
		}catch(MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERROR);;
		}finally {
			emailRepository.save(emailModel);
		}
	}
	
}
