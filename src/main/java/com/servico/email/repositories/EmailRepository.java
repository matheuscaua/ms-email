package com.servico.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servico.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{

}
