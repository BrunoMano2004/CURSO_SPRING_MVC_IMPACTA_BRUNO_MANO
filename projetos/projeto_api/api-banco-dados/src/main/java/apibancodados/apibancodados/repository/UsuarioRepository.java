package apibancodados.apibancodados.repository;

import apibancodados.apibancodados.model.UsuarioTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioTO, Long> {
    Optional<UsuarioTO> findByCpf(long cpf);

    boolean existsByCpf(long cpf);
}
