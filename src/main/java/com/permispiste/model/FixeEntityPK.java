package com.permispiste.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by seljo on 5/4/2017.
 */
public class FixeEntityPK implements Serializable {
    private int nummission;
    private int numobjectif;

    @Column(name = "NUMMISSION", insertable = false, updatable = false)
    @Id
    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @Column(name = "NUMOBJECTIF", insertable = false, updatable = false)
    @Id
    public int getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(int numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FixeEntityPK that = (FixeEntityPK) o;

        if (nummission != that.nummission) return false;
        if (numobjectif != that.numobjectif) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + numobjectif;
        return result;
    }
}
