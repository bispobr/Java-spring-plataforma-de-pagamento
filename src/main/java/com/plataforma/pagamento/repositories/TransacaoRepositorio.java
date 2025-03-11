package com.plataforma.pagamento.repositories;

import com.plataforma.pagamento.domain.transaction.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepositorio extends JpaRepository<Transacao,Long> {
}
