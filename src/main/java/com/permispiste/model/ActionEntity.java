package com.permispiste.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by seljo on 5/4/2017.
 */
@Entity
@Table(name = "action", schema = "permispiste")
public class ActionEntity implements  IEntity {
    private int numaction;
    private String libaction;
    private Integer scoremin;
    private ActionEntity actionByActNumaction;

    private Set<ObjectifEntity> objectives = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "est_associe", joinColumns = {
            @JoinColumn(name = "numaction", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "numobjectif",
                    nullable = false, updatable = false) })
    public Set<ObjectifEntity> getObjectives() {
        return objectives;
    }

    public void setObjectives(Set<ObjectifEntity> objectives) {
        this.objectives = objectives;
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
    @Column(name = "LIBACTION")
    public String getLibaction() {
        return libaction;
    }

    public void setLibaction(String libaction) {
        this.libaction = libaction;
    }

    @Basic
    @Column(name = "SCOREMIN")
    public Integer getScoremin() {
        return scoremin;
    }

    public void setScoremin(Integer scoremin) {
        this.scoremin = scoremin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (numaction != that.numaction) return false;
        if (libaction != null ? !libaction.equals(that.libaction) : that.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(that.scoremin) : that.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + (libaction != null ? libaction.hashCode() : 0);
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ACT_NUMACTION", referencedColumnName = "NUMACTION")
    public ActionEntity getActionByActNumaction() {
        return actionByActNumaction;
    }

    public void setActionByActNumaction(ActionEntity actionByActNumaction) {
        this.actionByActNumaction = actionByActNumaction;
    }
}
