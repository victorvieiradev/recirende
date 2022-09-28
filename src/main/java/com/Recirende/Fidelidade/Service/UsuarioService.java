package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Repository.PremioRepository;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PremioRepository premioRepository;

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
            //throw new NoSuchObjectException("usuarioModel");
            return null;
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

        public void resgatarPremios(Long idPremio, String cpfUsuario){
            Optional<PremiosModel> premiosModelOptional = premioRepository.findById(idPremio);
            PremiosModel premiosModel = new PremiosModel();
            BeanUtils.copyProperties(premiosModelOptional.get(), premiosModel);
            Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(cpfUsuario);
            UsuarioModel usuarioModel = new UsuarioModel();
            BeanUtils.copyProperties(usuarioModelOptional.get(), usuarioModel);
            usuarioModel.setPontos(usuarioModel.getPontos() - premiosModel.getValorPremio());
            premioRepository.deleteById(idPremio);
            usuarioRepository.save(usuarioModel);



        }

}
