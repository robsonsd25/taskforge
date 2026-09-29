package br.com.docodigoaocontrato.taskforge.repository;


import br.com.docodigoaocontrato.taskforge.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository  extends JpaRepository<Comentario, Long> {
    List<Comentario> findByDescricaoContaining(String descricao);
}
