package fr.erickfranco.cv_api.services.DTO;

import java.util.Objects;

public class ExperienceDTO {

    private Integer id;
    private String titrePoste;
    private String entreprise;
    private String description;
    private String ville;
    private String date;
    private String description2;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(String titrePoste) {
        this.titrePoste = titrePoste;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceDTO)) return false;
        ExperienceDTO that = (ExperienceDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitrePoste(), that.getTitrePoste()) && Objects.equals(getEntreprise(), that.getEntreprise()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getVille(), that.getVille()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getDescription2(), that.getDescription2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitrePoste(), getEntreprise(), getDescription(), getVille(), getDate(), getDescription2());
    }

    @Override
    public String toString() {
        return "ExperienceDTO{" +
                "id=" + id +
                ", titrePoste='" + titrePoste + '\'' +
                ", entreprise='" + entreprise + '\'' +
                ", description='" + description + '\'' +
                ", ville='" + ville + '\'' +
                ", date='" + date + '\'' +
                ", description2='" + description2 + '\'' +
                '}';
    }
}
