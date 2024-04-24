package apiaut.apiaut.repository;

import apiaut.apiaut.model.AutenticacaoTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutenticacaoRepository extends JpaRepository<AutenticacaoTO, Long> {

    AutenticacaoTO findByAuthorization(String authorization);
}
