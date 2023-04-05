package com.servico.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
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

	@Value("${mail-support}")
	private String mailFrom;
	public void enviarEmail(EmailModel emailModel) {
		SimpleMailMessage message = new SimpleMailMessage();
		emailModel.setSendDateEmail(LocalDateTime.now());
		try{
			message.setTo(emailModel.getMailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			mailSender.send(message);
			emailModel.setStatusEmail(StatusEmail.SENT);
		}catch (MailException e){
			e.getMessage();
			emailModel.setStatusEmail(StatusEmail.ERROR);
		}finally {
			emailModel.setMailFrom(mailFrom);
			emailRepository.save(emailModel);
		}
	}
}
