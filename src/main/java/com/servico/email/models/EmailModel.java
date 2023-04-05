package com.servico.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.servico.email.enums.StatusEmail;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "tb_email")
public class EmailModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ownerRef;
	private String mailFrom;
	private String mailTo;
	private String subject;
	@Column(columnDefinition = "TEXT")
	private String text;
	private LocalDateTime sendDateEmail;
	@Enumerated(EnumType.STRING)
	private StatusEmail statusEmail;
}
