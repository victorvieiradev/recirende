package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.hibernate.ObjectDeletedException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.net.http.HttpClient;

@Service
public class UsuarioService {

    @Autowired
   private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel){
        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            throw new HttpClientErrorException(HttpStatus.CONFLICT);
        } else {
            return usuarioRepository.save(usuarioModel);
        }
    }

    public UsuarioModel atualizarUsuario(UsuarioModel usuarioModel){
        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            return usuarioRepository.save(usuarioModel);
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    public UsuarioModel deletarUsuario(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return null;
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

    }
}
