package fr.erickfranco.cv_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Erick Franco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projets")
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String nomProjet;

    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String descriptionProjet;

    @Column(length = 30, nullable = false)
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String langageDuProjet;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String urlProjet;

    private String photo;

    private static final long serialVersionUID = 1L;
}
