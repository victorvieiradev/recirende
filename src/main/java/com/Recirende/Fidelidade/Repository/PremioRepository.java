package com.Recirende.Fidelidade.Repository;

import com.Recirende.Fidelidade.Model.PremiosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremioRepository extends JpaRepository<PremiosModel, Long> {
}
