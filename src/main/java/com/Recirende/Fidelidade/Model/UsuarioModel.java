package com.Recirende.Fidelidade.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "recirende")
public class UsuarioModel {

    @Id
    @Column(nullable = false, unique = true)
    @Size(min = 11, max = 11)
    private Long cpf;

    @Column(nullable = false)
    private String nome;

    @Column
    private Long pontos;





}
