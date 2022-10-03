package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Exception.PontosInsuficientesException;
import com.Recirende.Fidelidade.Exception.ProdutoNaoEncontradoException;
import com.Recirende.Fidelidade.Exception.UsuarioNaoEncontradoException;
import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Model.UsuarioResponse;
import com.Recirende.Fidelidade.Repository.PremioRepository;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PremioRepository premioRepository;

    public UsuarioResponse cadastrarUsuario(UsuarioModel usuarioModel){

        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            throw new DuplicateKeyException(usuarioModel.getCpf());
        } else {
            usuarioRepository.save(usuarioModel);
            UsuarioResponse usuarioResponse = new UsuarioResponse();
            usuarioResponse.setCpf(usuarioModel.getCpf());
            usuarioResponse.setNome(usuarioModel.getNome());

            return usuarioResponse;
        }
    }

    public UsuarioModel atualizarUsuario(UsuarioModel usuarioModel){
        if (usuarioRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }else
        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            return usuarioRepository.save(usuarioModel);
        } else {

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


    public List<UsuarioModel> mostrarUsuarios(){
        if (usuarioRepository.findAll().isEmpty()){
            throw new NullPointerException();
        }else
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarPorId(String cpf){
        if (usuarioRepository.existsById(cpf)){
        return usuarioRepository.findById(cpf);
        }else
            throw new NullPointerException();
    }
        @Transactional
        public void resgatarPremios(Long idPremio, String cpfUsuario) throws ProdutoNaoEncontradoException, UsuarioNaoEncontradoException, PontosInsuficientesException {
            Optional<PremiosModel> premiosModelOptional = premioRepository.findById(idPremio);

            if (!premiosModelOptional.isPresent()){
                throw new ProdutoNaoEncontradoException("O produto informado não existe.");
            }
            PremiosModel premiosModel = new PremiosModel();
            BeanUtils.copyProperties(premiosModelOptional.get(), premiosModel);
            Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(cpfUsuario);
            if (!usuarioModelOptional.isPresent()){
                throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
            }
            UsuarioModel usuarioModel = new UsuarioModel();
            BeanUtils.copyProperties(usuarioModelOptional.get(), usuarioModel);
            if (usuarioModel.getPontos()< premiosModel.getValorPremio()){
                throw new PontosInsuficientesException("Os seus pontos não são suficientes para resgatar o premio.");
            }
            usuarioModel.setPontos(usuarioModel.getPontos() - premiosModel.getValorPremio());
            usuarioModel.setListaDePremios(usuarioModel.getListaDePremios()  + premiosModel.getNomePremio() +", ");

            usuarioRepository.save(usuarioModel);
            premioRepository.deleteById(idPremio);


        }




}
