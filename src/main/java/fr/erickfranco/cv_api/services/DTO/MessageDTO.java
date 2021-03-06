package fr.erickfranco.cv_api.services.DTO;

import java.util.Objects;

public class MessageDTO {
    private Integer id;
    private String email;
    private String nom;
    private String prenom;
    private String sujet;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageDTO)) return false;
        MessageDTO that = (MessageDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom()) && Objects.equals(getSujet(), that.getSujet()) && Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getNom(), getPrenom(), getSujet(), getMessage());
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sujet='" + sujet + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
