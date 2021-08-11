package br.com.zupacademy.victor.transacao.cartao;

import javax.persistence.*;

@Entity
public class Cartao {

    @Id
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
