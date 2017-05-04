package com.permispiste.model;

import javax.persistence.*;

/**
 * Created by seljo on 5/4/2017.
 */
@Entity
@Table(name = "obtient", schema = "permispiste", catalog = "")
@IdClass(ObtientEntityPK.class)
public class ObtientEntity {
    private int numapprenant;
    private int numaction;
    private Integer valeur;
    private ApprenantEntity apprenantByNumapprenant;
    private ActionEntity actionByNumaction;

    @Id
    @Column(name = "NUMAPPRENANT")
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Id
    @Column(name = "NUMACTION")
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "VALEUR")
    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObtientEntity that = (ObtientEntity) o;

        if (numapprenant != that.numapprenant) return false;
        if (numaction != that.numaction) return false;
        if (valeur != null ? !valeur.equals(that.valeur) : that.valeur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + numaction;
        result = 31 * result + (valeur != null ? valeur.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMAPPRENANT", referencedColumnName = "NUMAPPRENANT", nullable = false)
    public ApprenantEntity getApprenantByNumapprenant() {
        return apprenantByNumapprenant;
    }

    public void setApprenantByNumapprenant(ApprenantEntity apprenantByNumapprenant) {
        this.apprenantByNumapprenant = apprenantByNumapprenant;
    }

    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "NUMACTION", nullable = false)
    public ActionEntity getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(ActionEntity actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }
}
