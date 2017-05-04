package com.permispiste.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by seljo on 5/4/2017.
 */
public class ObtientEntityPK implements Serializable {
    private int numapprenant;
    private int numaction;

    @Column(name = "NUMAPPRENANT", insertable = false, updatable = false)
    @Id
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Column(name = "NUMACTION", insertable = false, updatable = false)
    @Id
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObtientEntityPK that = (ObtientEntityPK) o;

        if (numapprenant != that.numapprenant) return false;
        if (numaction != that.numaction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + numaction;
        return result;
    }
}
