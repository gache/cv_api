package fr.erickfranco.cv_api.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Erick Franco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message= "L'adresse mail est incorrecte")
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = false)
    @Pattern(regexp = "^[a-z \\-À-ÖØ-öø-ÿ]{2,155}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL})
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String nom;

    @Column(length = 30, nullable = false)
    @Pattern(regexp = "^[a-z \\-À-ÖØ-öø-ÿ]{2,155}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL})
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String prenom;

    @Column(length = 30, nullable = false)
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String sujet;

    @Column(columnDefinition = "Text")
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private String message;

    @Temporal(TemporalType.DATE)
    @NotEmpty(message = "Ce champ ne peut pas être vide")
    private Date date;

    private static final long serialVersionUID = 1L;
}
