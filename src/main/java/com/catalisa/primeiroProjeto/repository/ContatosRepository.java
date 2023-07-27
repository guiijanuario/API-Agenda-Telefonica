package com.catalisa.primeiroProjeto.repository;

import com.catalisa.primeiroProjeto.model.ContatosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository<ContatosModel, Long> {
}
