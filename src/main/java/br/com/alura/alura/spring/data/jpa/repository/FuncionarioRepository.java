package br.com.alura.alura.spring.data.jpa.repository;

import br.com.alura.alura.spring.data.jpa.model.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
}
