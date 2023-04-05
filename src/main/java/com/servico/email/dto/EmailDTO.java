package com.servico.email.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
	@NotBlank
	private String ownerRef;
	@NotBlank
	private String mailTo;
	@NotBlank
	private String subject;
	@NotBlank
	private String text;
}
