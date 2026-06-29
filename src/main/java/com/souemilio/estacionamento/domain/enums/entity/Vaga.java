package com.souemilio.estacionamento.domain.enums.entity;

import com.souemilio.estacionamento.domain.enums.StatusVaga;
import com.souemilio.estacionamento.domain.enums.TipoVaga;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "vaga", uniqueConstraints = {@UniqueConstraint(name = "uk_vaga_numero", columnNames = "numero")})
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 20)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoVaga tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusVaga status;

    public Vaga() {
        //Spring exige construtor vazio
    }

    public Vaga(UUID id, String numero, TipoVaga tipo, StatusVaga status) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
    }

    public void ocupar(){
        this.status = StatusVaga.OCUPADA;
    }

    public void liberar(){
        this.status = StatusVaga.LIVRE;
    }

    public boolean estaLivre(){
        return StatusVaga.LIVRE.equals(this.status);
    }

    public UUID getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoVaga getTipo() {
        return tipo;
    }

    public void setTipo(TipoVaga tipo) {
        this.tipo = tipo;
    }

    public StatusVaga getStatus() {
        return status;
    }

}
