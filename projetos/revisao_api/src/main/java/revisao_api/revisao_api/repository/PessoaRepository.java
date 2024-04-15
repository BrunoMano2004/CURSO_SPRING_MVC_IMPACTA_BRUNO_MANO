package revisao_api.revisao_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import revisao_api.revisao_api.model.PessoaTO;

public interface PessoaRepository extends JpaRepository<PessoaTO, Long> {
}
