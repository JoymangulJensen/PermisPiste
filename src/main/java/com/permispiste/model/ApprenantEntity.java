package com.permispiste.model;

import javax.persistence.*;

/**
 * Created by seljo on 5/4/2017.
 */
@Entity
@Table(name = "apprenant", schema = "permispiste", catalog = "")
public class ApprenantEntity {
    private int numapprenant;
    private String nomapprenant;
    private String prenomapprenant;

    @Id
    @Column(name = "NUMAPPRENANT")
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Basic
    @Column(name = "NOMAPPRENANT")
    public String getNomapprenant() {
        return nomapprenant;
    }

    public void setNomapprenant(String nomapprenant) {
        this.nomapprenant = nomapprenant;
    }

    @Basic
    @Column(name = "PRENOMAPPRENANT")
    public String getPrenomapprenant() {
        return prenomapprenant;
    }

    public void setPrenomapprenant(String prenomapprenant) {
        this.prenomapprenant = prenomapprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (numapprenant != that.numapprenant) return false;
        if (nomapprenant != null ? !nomapprenant.equals(that.nomapprenant) : that.nomapprenant != null) return false;
        if (prenomapprenant != null ? !prenomapprenant.equals(that.prenomapprenant) : that.prenomapprenant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + (nomapprenant != null ? nomapprenant.hashCode() : 0);
        result = 31 * result + (prenomapprenant != null ? prenomapprenant.hashCode() : 0);
        return result;
    }
}
