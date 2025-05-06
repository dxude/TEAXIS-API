package com.teaxis.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;
}
