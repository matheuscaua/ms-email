package com.servico.email.controllers;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servico.email.dto.EmailDTO;
import com.servico.email.models.EmailModel;
import com.servico.email.services.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;
	@PostMapping("/enviar-email")
	public ResponseEntity enviarEmail(@RequestBody @Valid EmailDTO emailDTO){
		try {
			EmailModel emailModel = new EmailModel();
			BeanUtils.copyProperties(emailDTO, emailModel);
			emailService.enviarEmail(emailModel);
			return ResponseEntity.status(200).build();
		}catch (Exception e){
			return ResponseEntity.status(400).body("Erro ao enviar email!");
		}
	}
}
