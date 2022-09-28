package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Controller.EmbalagemController;
import com.Recirende.Fidelidade.Model.EmbalagemModel;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static java.nio.file.Paths.get;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmbalagemServiceTeste  {


    @LocalServerPort //verificar porta
    private int port;//procura por ela sendo 8080 ou 8081
    @Autowired
    private EmbalagemService service;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void verificaSeVemVazio() throws Exception{
        Assertions.assertThat(service).isNotNull();
    }



}