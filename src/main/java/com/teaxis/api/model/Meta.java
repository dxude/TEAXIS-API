package com.teaxis.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double progresso;

    @ManyToOne
    @JoinColumn(name = "usuario_id") 
    private Usuario usuario;  
}
