package sistemaDeProdutos.sistemaDeProdutos.repository;

import org.springframework.data.repository.CrudRepository;

import sistemaDeProdutos.sistemaDeProdutos.model.ProdutoTO;

public interface ProdutoRepository extends CrudRepository<ProdutoTO, String>{
	
	ProdutoTO findById(long id);
}
