package com.erickfranco.cv_api.models;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @NotNull
    @NotBlank
    @Column(nullable = false, length = 150)
    private String email;

    @Column(length = 30, nullable = false)
    @Pattern(regexp = "^[a-z \\-À-ÖØ-öø-ÿ]{2,155}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL})
    private String nom;

    @Column(length = 30, nullable = false)
    @Pattern(regexp = "^[a-z \\-À-ÖØ-öø-ÿ]{2,155}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL})
    private String prenom;

    @Column(length = 30, nullable = false)
    private String sujet;

    @Column(columnDefinition = "Text")
    private String message;
}
