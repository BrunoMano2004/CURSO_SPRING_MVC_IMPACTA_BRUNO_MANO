package cadastroMotorista.cadastroMotorista.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cadastroMotorista.cadastroMotorista.model.MotoristaTO;

@Repository
public interface MotoristaRepository extends CrudRepository<MotoristaTO, Integer>{
	MotoristaTO findById(int id);
}
