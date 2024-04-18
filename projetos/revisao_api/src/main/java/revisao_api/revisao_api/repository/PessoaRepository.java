package revisao_api.revisao_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import revisao_api.revisao_api.model.PessoaTO;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaTO, Long> {

    Optional<PessoaTO> findByNome(String nome);
}
