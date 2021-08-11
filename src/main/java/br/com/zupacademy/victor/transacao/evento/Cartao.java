package br.com.zupacademy.victor.transacao.evento;

import javax.persistence.*;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartao;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String email;

    public Cartao(String id, String email) {

        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Deprecated
    public Cartao() {

    }
}
