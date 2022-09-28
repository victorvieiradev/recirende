package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Model.EmbalagemModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Repository.EmbalagemRepository;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Optional;

@Service
public class EmbalagemService {
    @Autowired
    private EmbalagemRepository embalagemRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    public List<EmbalagemModel> listarEmbalagens(){
        if (embalagemRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return embalagemRepository.findAll();
    }
    public EmbalagemModel cadastrarEmbalagem(EmbalagemModel embalagemModel){

        String cpf = embalagemModel.getUsuario().getCpf();
        Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(cpf);
        if (usuarioModelOptional.isPresent()){
            UsuarioModel usuarioModel = new UsuarioModel();
            BeanUtils.copyProperties(usuarioModelOptional.get(), usuarioModel);
            usuarioModel.setPontos(1500L + usuarioModelOptional.get().getPontos());
            var usuarioComPontos = usuarioRepository.save(usuarioModel);


        }

        return embalagemRepository.save(embalagemModel);
    }
    public Optional<EmbalagemModel> buscarPorId(String id){
        return embalagemRepository.findById(id);
    }
    public void excluir(EmbalagemModel embalagemModel){
        embalagemRepository.delete(embalagemModel);
    }
}
