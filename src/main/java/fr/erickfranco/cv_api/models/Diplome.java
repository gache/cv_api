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
@Table(name = "diplomes")
public class Diplome implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String nomDiplome;

    @Column(length = 40, nullable = false)
    private String ecole;

    @Column(length = 30, nullable = false)
    private String ville;

    @Column(columnDefinition = "Text")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date annee;

    private static final long serialVersionUID = 1L;

}
