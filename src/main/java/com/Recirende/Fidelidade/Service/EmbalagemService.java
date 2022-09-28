package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Model.EmbalagemModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Repository.EmbalagemRepository;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmbalagemService {
    @Autowired
    private EmbalagemRepository embalagemRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    public List<EmbalagemModel> listarEmbalagens(){
        return embalagemRepository.findAll();
    }
    public EmbalagemModel cadastrarEmbalagem(EmbalagemModel embalagemModel){

        Long cpf = embalagemModel.getUsuario().getCpf();
        Optional<?> usuarioModelOptional = embalagemRepository.findById(cpf);
        if (usuarioModelOptional.isPresent()){
            UsuarioModel usuarioModel = new UsuarioModel();
            BeanUtils.copyProperties(usuarioModelOptional, usuarioModel);
            usuarioModel.setPontos(usuarioModel.getPontos() += 1500L);
            usuarioModel.setCpf(cpf);
            usuarioRepository.save(usuarioModel);
        }
        return embalagemRepository.save(embalagemModel);
    }
    public Optional<EmbalagemModel> buscarPorId(Long id){
        return embalagemRepository.findById(id);
    }
    public void excluir(EmbalagemModel embalagemModel){
        embalagemRepository.delete(embalagemModel);
    }
}
