package com.example.favorito_service.controller;

import com.example.favorito_service.model.Favorito;
import com.example.favorito_service.service.FavoritoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FavoritoController {
    
    private final FavoritoService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Favorito crear(@Valid @RequestBody Favorito favorito) {
        return service.crear(favorito);
    }
    
    @GetMapping
    public List<Favorito> obtenerTodos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public Favorito obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public List<Favorito> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return service.obtenerPorUsuario(usuarioId);
    }
    
    @GetMapping("/manual/{manualId}")
    public List<Favorito> obtenerPorManual(@PathVariable Long manualId) {
        return service.obtenerPorManual(manualId);
    }
    
    @GetMapping("/verificar/{usuarioId}/{manualId}")
    public boolean esFavorito(@PathVariable Long usuarioId, @PathVariable Long manualId) {
        return service.esFavorito(usuarioId, manualId);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
    
    @DeleteMapping("/usuario/{usuarioId}/manual/{manualId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPorUsuarioYManual(
            @PathVariable Long usuarioId, 
            @PathVariable Long manualId) {
        service.eliminarPorUsuarioYManual(usuarioId, manualId);
    }
}