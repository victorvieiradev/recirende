package com.Recirende.Fidelidade.Model;

import com.Recirende.Fidelidade.Model.enuns.PremioEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "premios")
public class PremiosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private PremioEnum tipo;
}
