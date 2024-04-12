package revisao_api.revisao_api.repository;

import org.springframework.data.repository.CrudRepository;
import revisao_api.revisao_api.model.PessoaTO;

public interface PessoaRepository extends CrudRepository<PessoaTO, String> {
}
