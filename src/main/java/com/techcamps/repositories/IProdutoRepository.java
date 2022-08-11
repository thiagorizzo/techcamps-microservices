package com.techcamps.repositories;

import com.techcamps.entities.Produto;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public interface IProdutoRepository extends JpaRepository<Produto, Integer> {

    // JPQL -> "SELECT c FROM produto c WHERE c.nome = :nome"
    // Native Query -> "SELECT * FROM produto c WHERE c.nome = :nome"
    @Query(value="SELECT * FROM produto p where p.nome LIKE  '%' || :nome || '%'", nativeQuery = true)
    List<Produto> listByNome(@Param("nome") String nome);
}
