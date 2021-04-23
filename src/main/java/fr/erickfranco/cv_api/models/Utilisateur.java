package fr.erickfranco.cv_api.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author Erick Franco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 60)
    private String password;

    private Boolean enabled;

    @Size(max = 50)
    private String prenom;

    @Size(max = 50)
    private String nom;

    @Email
    @Size(min = 5, max = 255)
    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "utilisateurs_roles", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
            @UniqueConstraint(columnNames = {"utilisateur_id", "role_id"})})
    private List<Role> roles;


    private static final long serialVersionUID = 1L;

}


