package com.permispiste.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by seljo on 5/4/2017.
 */
@Entity
@Table(name = "objectif", schema = "permispiste")
public class ObjectifEntity implements IEntity {
    private int numobjectif;
    private String libobectif;

    private Set<MissionEntity> missions = new HashSet<>();
    private Set<ActionEntity> actions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "objectives")
    public Set<ActionEntity> getActions() {
        return actions;
    }

    public void setActions(Set<ActionEntity> actions) {
        this.actions = actions;
    }



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "objectives")
    public Set<MissionEntity> getMissions() {
        return missions;
    }

    public void setMissions(Set<MissionEntity> missions) {
        this.missions = missions;
    }

    @Id
    @Column(name = "NUMOBJECTIF")
    public int getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(int numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Basic
    @Column(name = "LIBOBECTIF")
    public String getLibobectif() {
        return libobectif;
    }

    public void setLibobectif(String libobectif) {
        this.libobectif = libobectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectifEntity that = (ObjectifEntity) o;

        if (numobjectif != that.numobjectif) return false;
        if (libobectif != null ? !libobectif.equals(that.libobectif) : that.libobectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numobjectif;
        result = 31 * result + (libobectif != null ? libobectif.hashCode() : 0);
        return result;
    }
}
