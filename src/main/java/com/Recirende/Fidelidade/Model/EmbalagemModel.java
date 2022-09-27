package com.Recirende.Fidelidade.Model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "embalagem")
public class EmbalagemModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String marca;


}
