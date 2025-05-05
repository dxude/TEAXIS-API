package com.teaxis.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoesFeitas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Meta> metas;
}
