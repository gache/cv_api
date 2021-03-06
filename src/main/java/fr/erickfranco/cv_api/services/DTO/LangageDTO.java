package fr.erickfranco.cv_api.services.DTO;

import java.util.Objects;

public class LangageDTO {
    private Integer id;
    private String langageInformatique;
    private String porcentage;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLangageInformatique() {
        return langageInformatique;
    }

    public void setLangageInformatique(String langageInformatique) {
        this.langageInformatique = langageInformatique;
    }

    public String getPorcentage() {
        return porcentage;
    }

    public void setPorcentage(String porcentage) {
        this.porcentage = porcentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LangageDTO)) return false;
        LangageDTO that = (LangageDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getLangageInformatique(), that.getLangageInformatique()) && Objects.equals(getPorcentage(), that.getPorcentage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLangageInformatique(), getPorcentage());
    }

    @Override
    public String toString() {
        return "LangageDTO{" +
                "id=" + id +
                ", langageInformatique='" + langageInformatique + '\'' +
                ", porcentage='" + porcentage + '\'' +
                '}';
    }
}
