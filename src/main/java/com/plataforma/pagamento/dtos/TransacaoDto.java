package com.plataforma.pagamento.dtos;

import java.math.BigDecimal;

public record TransacaoDto(BigDecimal valor,Long remetenteId, Long destinatarioId) {
}

