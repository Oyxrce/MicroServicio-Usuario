package com.example.favorito_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "favorito")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favorito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El usuario es obligatorio")
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;
    
    @NotNull(message = "El manual es obligatorio")
    @Column(name = "manual_id", nullable = false)
    private Long manualId;
    
    @Column(name = "fecha_agregado")
    private LocalDate fechaAgregado;
    
    @PrePersist
    protected void onCreate() {
        if (fechaAgregado == null) {
            fechaAgregado = LocalDate.now();
        }
    }
}