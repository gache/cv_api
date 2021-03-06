package fr.erickfranco.cv_api.services.DTO;

import java.util.Objects;

public class ProjetDTO {
    private Integer id;
    private String nom;
    private String description;
    private String langage;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjetDTO)) return false;
        ProjetDTO projetDTO = (ProjetDTO) o;
        return Objects.equals(getId(), projetDTO.getId()) && Objects.equals(getNom(), projetDTO.getNom()) && Objects.equals(getDescription(), projetDTO.getDescription()) && Objects.equals(getLangage(), projetDTO.getLangage()) && Objects.equals(getUrl(), projetDTO.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getDescription(), getLangage(), getUrl());
    }

    @Override
    public String toString() {
        return "ProjetDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", langage='" + langage + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
