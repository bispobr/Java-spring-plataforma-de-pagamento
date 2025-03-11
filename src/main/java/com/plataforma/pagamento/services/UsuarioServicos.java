package com.plataforma.pagamento.services;

import com.plataforma.pagamento.domain.user.TipoUsuario;
import com.plataforma.pagamento.domain.user.Usuario;
import com.plataforma.pagamento.dtos.UsuarioDTO;
import com.plataforma.pagamento.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsuarioServicos {
    @Autowired
    private UsuarioRepositorio repositorio;

    public void validarTransacao(Usuario remetente, BigDecimal valor) throws Exception{

        if (remetente.getTipoUsuario() == TipoUsuario.LOJISTA){
            throw new Exception("Usuarios lojistas não está autorizado a realizar transação");
        }

        if(remetente.getSaldo().compareTo(valor) < 0 ){
            throw new Exception("Saldo insuficiente");
        }
    }

    public Usuario findUsuarioById(Long id) throws Exception{
        return this.repositorio.findUserById(id).orElseThrow(() -> new Exception("usuario não encontrado"));
    }

    public Usuario criarUsuario(UsuarioDTO usuario){
        Usuario novoUsuario= new Usuario(usuario);
        this.salvarUsuario(novoUsuario);
        return novoUsuario;
    }

    public List<Usuario> listarUsarios(){
        return this.repositorio.findAll();
    }

    public void salvarUsuario (Usuario usuario){
        this.repositorio.save(usuario);

    }


}
