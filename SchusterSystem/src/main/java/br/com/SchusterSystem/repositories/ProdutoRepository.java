package br.com.SchusterSystem.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SchusterSystem.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	

	
}
