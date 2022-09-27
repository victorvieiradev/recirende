package com.Recirende.Fidelidade.Repository;

import com.Recirende.Fidelidade.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
