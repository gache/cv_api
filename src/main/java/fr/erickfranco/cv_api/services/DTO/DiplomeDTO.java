package fr.erickfranco.cv_api.services.DTO;

import java.util.Objects;

public class DiplomeDTO {

    private Integer id;
    private String nomDiplome;
    private String ecole;
    private String ville;
    private String description;
    private String annee;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomDiplome() {
        return nomDiplome;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiplomeDTO)) return false;
        DiplomeDTO that = (DiplomeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nomDiplome, that.nomDiplome) && Objects.equals(ecole, that.ecole) && Objects.equals(ville, that.ville) && Objects.equals(description, that.description) && Objects.equals(annee, that.annee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomDiplome, ecole, ville, description, annee);
    }

    @Override
    public String toString() {
        return "DiplomeDTO{" +
                "id=" + id +
                ", nomDiplome='" + nomDiplome + '\'' +
                ", ecole='" + ecole + '\'' +
                ", ville='" + ville + '\'' +
                ", description='" + description + '\'' +
                ", annee='" + annee + '\'' +
                '}';
    }
}
