package br.com.alura.alura.spring.data.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UnidadeDeTrabalho {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    private String endereco;

    @ManyToMany(mappedBy = "unidadesDeTrabalho")
    private List<Funcionario> funcionarios;

    public UnidadeDeTrabalho() {
    }
}
