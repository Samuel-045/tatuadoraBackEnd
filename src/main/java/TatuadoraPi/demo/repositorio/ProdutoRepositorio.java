package TatuadoraPi.demo.repositorio;

import TatuadoraPi.demo.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositorio extends JpaRepository<Produto,String> {
    @Query("SELECT p FROM Produto p")
    List<Produto> listarTodos();

    Optional<Produto> findByNome(String nome);

    @Query("SELECT p FROM Produto p "
            + "WHERE p.nome LIKE %:nome%")
    List<Produto> findByParteNome(String nome);

    @Modifying
    @Transactional
    @Query("DELETE FROM Produto p where p.id = :id")
    void deleteById(long id);

    Optional<Produto> findById(Long id);
}
