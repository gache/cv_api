package fr.erickfranco.cv_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 30, nullable = false)
    private String langage;

    @Column(length = 100, nullable = false)
    private String url;

}
