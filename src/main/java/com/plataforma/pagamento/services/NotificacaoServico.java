package com.plataforma.pagamento.services;



import com.plataforma.pagamento.domain.user.Usuario;
import com.plataforma.pagamento.dtos.NotificacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoServico {
    @Autowired
    private RestTemplate restTemplate;

    public void enviarNotificacao(Usuario usuario, String mensagem) throws Exception {
        String email = usuario.getEmail();
        NotificacaoDTO requisicaoNotoficacao = new NotificacaoDTO(email,mensagem);
        System.out.println("Notificação enviada para o usuario");
    }
}
