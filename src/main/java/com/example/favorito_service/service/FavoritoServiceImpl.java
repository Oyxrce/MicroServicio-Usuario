package com.example.favorito_service.service;

import com.example.favorito_service.model.Favorito;
import com.example.favorito_service.repository.FavoritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritoServiceImpl implements FavoritoService {
    
    private final FavoritoRepository repository;
    
    @Override
    @Transactional
    public Favorito crear(Favorito favorito) {
        if (repository.existsByUsuarioIdAndManualId(
                favorito.getUsuarioId(), favorito.getManualId())) {
            throw new RuntimeException("Este manual ya está en favoritos");
        }
        return repository.save(favorito);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Favorito> obtenerTodos() {
        return repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Favorito obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Favorito no encontrado: " + id));
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Favorito> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Favorito> obtenerPorManual(Long manualId) {
        return repository.findByManualId(manualId);
    }
    
    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Favorito no encontrado: " + id);
        }
        repository.deleteById(id);
    }
    
    @Override
    @Transactional
    public void eliminarPorUsuarioYManual(Long usuarioId, Long manualId) {
        repository.deleteByUsuarioIdAndManualId(usuarioId, manualId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean esFavorito(Long usuarioId, Long manualId) {
        return repository.existsByUsuarioIdAndManualId(usuarioId, manualId);
    }
}