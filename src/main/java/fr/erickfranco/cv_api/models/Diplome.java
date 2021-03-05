package fr.erickfranco.cv_api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Erick Franco
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diplome")
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 80, nullable = false)
    private String nomDiplome;

    @Column(length = 40, nullable = false)
    private String ecole;

    @Column(length = 30, nullable = false)
    private String ville;

    @Column(columnDefinition = "Text")
    private String description;

    @JsonFormat(pattern = "YYYY-MM-DD", shape = JsonFormat.Shape.STRING)
    private String annee;


}
