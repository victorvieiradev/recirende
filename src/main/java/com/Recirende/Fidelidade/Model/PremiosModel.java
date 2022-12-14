package com.Recirende.Fidelidade.Model;

import com.Recirende.Fidelidade.Model.enuns.PremioEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

@Data
@Entity
@Table(name = "premios")
public class PremiosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private PremioEnum tipo;

    @Column
    private String nomePremio;

    @Column
    private Long valorPremio;


    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "usuario1", referencedColumnName = "cpf")
    private UsuarioModel usuario1;


}
