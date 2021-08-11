package br.com.zupacademy.victor.transacao.kafka;

import br.com.zupacademy.victor.transacao.evento.EventoDeTransacao;
import br.com.zupacademy.victor.transacao.evento.Transacao;
import br.com.zupacademy.victor.transacao.evento.TransacaoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ListenerDeTransacao {

    private final TransacaoRepository transacaoRepository;

    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println("Começo nova transação");
        System.out.println();
        System.out.println(eventoDeTransacao);
        Transacao novaTransacao = eventoDeTransacao.toModel();
        transacaoRepository.save(novaTransacao);

        System.out.println("Salvou transação");
        System.out.println();

    }

}
