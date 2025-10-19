package com.example.favorito_service.service;

import com.example.favorito_service.model.Favorito;
import java.util.List;

public interface FavoritoService {
    Favorito crear(Favorito favorito);
    List<Favorito> obtenerTodos();
    Favorito obtenerPorId(Long id);
    List<Favorito> obtenerPorUsuario(Long usuarioId);
    List<Favorito> obtenerPorManual(Long manualId);
    void eliminar(Long id);
    void eliminarPorUsuarioYManual(Long usuarioId, Long manualId);
    boolean esFavorito(Long usuarioId, Long manualId);
}