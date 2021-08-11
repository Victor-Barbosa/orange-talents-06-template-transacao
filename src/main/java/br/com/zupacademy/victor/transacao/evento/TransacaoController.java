package br.com.zupacademy.victor.transacao.evento;

import br.com.zupacademy.victor.transacao.cartao.CartaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/compras")
public class TransacaoController {

    private CartaoRepository cartaoRepository;
    private TransacaoRepository transacaoRepository;

    public TransacaoController(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{idCartao}")
    public ResponseEntity<Page<Transacao>> listarCompras(@PathVariable String idCartao, @PageableDefault(size = 10) Pageable pagina){

        if (!cartaoRepository.existsById(idCartao)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado");
        }

        Page<Transacao> transacoes = transacaoRepository.findAllByCartaoId(idCartao, pagina);

        return ResponseEntity.ok().body(transacoes);

    }
}
