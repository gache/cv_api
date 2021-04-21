package fr.erickfranco.cv_api.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Erick Franco
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experiences")
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String titrePoste;

    @Column(length = 60, nullable = false)
    private String entreprise;

    @Column(columnDefinition = "Text")
    private String description;

    @Column(length = 30, nullable = false)
    private String ville;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(columnDefinition = "Text")
    private String description2;

    private static final long serialVersionUID = 1L;
}
