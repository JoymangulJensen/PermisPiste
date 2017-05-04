package com.permispiste.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by seljo on 5/4/2017.
 */
public class InscriptionEntityPK implements Serializable {
    private int numapprenant;
    private int numjeu;

    @Column(name = "NUMAPPRENANT", insertable = false, updatable = false)
    @Id
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Column(name = "NUMJEU", insertable = false, updatable = false)
    @Id
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntityPK that = (InscriptionEntityPK) o;

        if (numapprenant != that.numapprenant) return false;
        if (numjeu != that.numjeu) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + numjeu;
        return result;
    }
}
