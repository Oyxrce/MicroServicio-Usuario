package com.example.favorito_service.repository;

import com.example.favorito_service.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    List<Favorito> findByUsuarioId(Long usuarioId);
    List<Favorito> findByManualId(Long manualId);
    Optional<Favorito> findByUsuarioIdAndManualId(Long usuarioId, Long manualId);
    boolean existsByUsuarioIdAndManualId(Long usuarioId, Long manualId);
    void deleteByUsuarioIdAndManualId(Long usuarioId, Long manualId);
}