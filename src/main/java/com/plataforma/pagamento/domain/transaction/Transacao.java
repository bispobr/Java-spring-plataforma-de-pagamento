package com.plataforma.pagamento.domain.transaction;

import com.plataforma.pagamento.domain.user.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transacao")
@Table(name="transacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn (name = "remetente_id")
    private Usuario remetente;

    @ManyToOne
    @JoinColumn (name = "destinatario_id")
    private Usuario destinatario;

    private LocalDateTime timestamp;

}