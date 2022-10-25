package br.com.alura.alura.spring.data.jpa.repository;

import br.com.alura.alura.spring.data.jpa.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
