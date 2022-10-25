package br.com.alura.alura.spring.data.jpa.orm;

import javax.persistence.*;

@Entity
@Table(name="cargos")
public class Cargo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    public Cargo() {
    }

    public Cargo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Cargo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
