package fr.erickfranco.cv_api.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Erick Franco
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "nom", length = 50)
    private String nom;

    @Size(max = 50)
    @Column(name = "prenom", length = 50)
    private String prenom;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login", length = 50, unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;


}


