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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "langages_frameworks")
public class Langage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String langageInformatique;

    @Column(length = 30, nullable = false)
    private String porcentage;

    private static final long serialVersionUID = 1L;
}
