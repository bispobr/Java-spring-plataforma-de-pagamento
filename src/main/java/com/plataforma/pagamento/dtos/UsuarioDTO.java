package com.plataforma.pagamento.dtos;

import com.plataforma.pagamento.domain.user.TipoUsuario;

import java.math.BigDecimal;

public record UsuarioDTO(String nome, String Sobrenome, String cpf, BigDecimal saldo, String email, String senha,
                         TipoUsuario tipoUsuario) {

}
