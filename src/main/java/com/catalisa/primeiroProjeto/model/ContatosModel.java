package com.catalisa.primeiroProjeto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CONTATOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Usuário", example = "1")
    private Long id;

    @Schema(description = "Nome do Usuário", example = "Bruno Carlos")
    @Column(length = 50, nullable = false)
    private String nome;

    @Schema(description = "Telefone do Usuário", example = "(44)99999-1111")
    @Column(length = 15, nullable = false)
    private String telefone;

}
