package com.Recirende.Fidelidade.Repository;

import com.Recirende.Fidelidade.Model.EmbalagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbalagemRepository extends JpaRepository<EmbalagemModel, Long> {
}
