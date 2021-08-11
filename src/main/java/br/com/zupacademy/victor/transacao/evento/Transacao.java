package br.com.zupacademy.victor.transacao.evento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacao;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private BigDecimal valor;
    @OneToOne(cascade = CascadeType.ALL)
    private Estabelecimento toModel;
    @OneToOne(cascade = CascadeType.ALL)
    private Cartao toModel1;
    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    public Transacao(String id, BigDecimal valor, Estabelecimento toModel, Cartao toModel1, LocalDateTime efetivadaEm) {

        this.id = id;
        this.valor = valor;
        this.toModel = toModel;
        this.toModel1 = toModel1;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getToModel() {
        return toModel;
    }

    public Cartao getToModel1() {
        return toModel1;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Deprecated
    public Transacao() {

    }
}
