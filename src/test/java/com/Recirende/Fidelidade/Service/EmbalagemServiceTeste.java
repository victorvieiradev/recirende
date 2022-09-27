package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Controller.EmbalagemController;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class EmbalagemServiceTeste {
     @Autowired
     private EmbalagemController embalagemController;
     @Test
     public void CadastraTeste(){
         embalagemController.cadastrarEmbalagem();


    }
}