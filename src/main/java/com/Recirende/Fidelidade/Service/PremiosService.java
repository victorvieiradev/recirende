package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Exception.PontosInsuficientesException;
import com.Recirende.Fidelidade.Exception.ProdutoNaoEncontradoException;
import com.Recirende.Fidelidade.Exception.UsuarioNaoEncontradoException;
import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Repository.PremioRepository;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PremiosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PremioRepository premioRepository;

    public PremiosModel cadastrarPremio(PremiosModel premiosModel){
        return premioRepository.save(premiosModel);
    }

    public List<PremiosModel> verPremios(){
        if (premioRepository.findAll().isEmpty()){
            throw new NullPointerException();
        }else
            return premioRepository.findAll();
    }

    public PremiosModel alterarPremio(PremiosModel premiosModel){
        if (!(premioRepository.findById(premiosModel.getId()).isPresent())){
          throw new NoSuchElementException();
        }else {
        return  premioRepository.save(premiosModel);
        }
    }

    public PremiosModel deletarPremio(Long id){
        if (premioRepository.existsById(id)){
            premioRepository.deleteById(id);
            return null;
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    public void resgatarPremios(Long idPremio, String cpfUsuario) throws ProdutoNaoEncontradoException, UsuarioNaoEncontradoException, PontosInsuficientesException {
        // usuarioRepository.findById(cpfUsuario).get().getPremios().add(premioRepository.findById(idPremio));

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

        usuarioModel.setPremios(usuarioRepository.findById(idPremio));

        usuarioRepository.save(usuarioModel);
        premioRepository.deleteById(idPremio);


    }

}
