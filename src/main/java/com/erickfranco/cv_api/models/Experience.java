package com.erickfranco.cv_api.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String titrePoste;

    @Column(length = 60, nullable = false)
    private String entreprise;

    @Column(columnDefinition = "Text")
    private String description;

    @Column(length = 30, nullable = false)
    private String ville;

    @JsonFormat(pattern = "YYYY-MM-DD", shape = JsonFormat.Shape.STRING)
    private String date;

    @Column(columnDefinition = "Text")
    private String description2;

}
