package com.plataforma.pagamento.services;

import com.plataforma.pagamento.domain.transaction.Transacao;
import com.plataforma.pagamento.domain.user.Usuario;
import com.plataforma.pagamento.dtos.TransacaoDto;
import com.plataforma.pagamento.repositories.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;


@Service
public class TransacaoServicos {

    @Autowired
    private UsuarioServicos usuarioServicos;

    @Autowired
    private TransacaoRepositorio repositorio;

    @Autowired
    private AutorizacaoServico autorizacaoServico;

    @Autowired
    private NotificacaoServico notificacaoServico;

    public Transacao CriarTransacao(TransacaoDto transaction) throws Exception {

        Usuario remetente = this.usuarioServicos.findUsuarioById(transaction.remetenteId());
        Usuario destinatario = this.usuarioServicos.findUsuarioById(transaction.destinatarioId());

        usuarioServicos.validarTransacao(remetente,transaction.valor());

        boolean autorizado = this.autorizacaoServico.autorizacaoTransacao(remetente, transaction.valor());

        if (!autorizado){
            throw new Exception("Operação não autorizada");
        }

        Transacao newTransacao =  new Transacao();
        newTransacao.setValor(transaction.valor());
        newTransacao.setDestinatario(destinatario);
        newTransacao.setRemetente(remetente);
        newTransacao.setTimestamp(LocalDateTime.now());

        remetente.setSaldo(remetente.getSaldo().subtract(transaction.valor()));
        destinatario.setSaldo(destinatario.getSaldo().add(transaction.valor()));

        this.repositorio.save(newTransacao);
        this.usuarioServicos.salvarUsuario(remetente);
        this.usuarioServicos.salvarUsuario(destinatario);

        this.notificacaoServico.enviarNotificacao(remetente,"Operação realizada com Sucesso");
        this.notificacaoServico.enviarNotificacao(destinatario,"Operação recebida com Sucesso");

        return newTransacao;

    }



}
