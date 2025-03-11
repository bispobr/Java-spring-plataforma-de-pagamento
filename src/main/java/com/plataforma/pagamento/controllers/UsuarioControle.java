package com.plataforma.pagamento.controllers;

import com.plataforma.pagamento.domain.user.Usuario;
import com.plataforma.pagamento.dtos.UsuarioDTO;
import com.plataforma.pagamento.services.UsuarioServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UsuarioControle {

    @Autowired
    private UsuarioServicos usuarioServicos;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuario){
        Usuario novoUsuario= usuarioServicos.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>>listarUsuarios(){
        List<Usuario> usuarios =  this.usuarioServicos.listarUsarios();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }

}
