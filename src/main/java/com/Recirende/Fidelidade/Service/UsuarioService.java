package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.NoSuchObjectException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
   private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel){

        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            throw new DuplicateKeyException(usuarioModel.getCpf());
        } else {
            return usuarioRepository.save(usuarioModel);
        }
    }

    public UsuarioModel atualizarUsuario(UsuarioModel usuarioModel){
        if (usuarioRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }else
        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            return usuarioRepository.save(usuarioModel);
        } else {
            throw new NoSuchObjectException("usuarioModel");
        }
    }

    public UsuarioModel deletarUsuario(String id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return null;
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

    }
        public List<UsuarioModel> mostrarTudo(){
        return usuarioRepository.findAll();
        }

}
