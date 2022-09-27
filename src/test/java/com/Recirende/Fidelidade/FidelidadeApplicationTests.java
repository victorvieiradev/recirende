package com.Recirende.Fidelidade;

import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
@Service
class FidelidadeApplicationTests {

    @Test
    void cadastrarEmbralagem() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setPontos(1500l + usuario.getPontos());
        embalagemModel.setUsuario(embalagemModel);
        Assertions.assertArrayEquals(new );


    }

}
