package com.plataforma.pagamento.domain.user;

import com.plataforma.pagamento.dtos.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Usuario")
@Table(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String senha;

    private BigDecimal Saldo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public  Usuario (UsuarioDTO usuario){
        this.nome = usuario.nome();
        this.sobrenome = usuario.Sobrenome();
        this.Saldo = usuario.saldo();
        this.tipoUsuario =  usuario.tipoUsuario();
        this.senha= usuario.senha();
        this.cpf = usuario.cpf();
        this.email =  usuario.email();

    }

}
