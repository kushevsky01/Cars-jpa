package service.simpleservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Model {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private boolean modelActive;
    private String modelName;
    private String modelCaption;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @JsonManagedReference
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Modification> modifications = new ArrayList<>();
    public Model(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return modelActive;
    }

    public void setActive(boolean active) {
        this.modelActive = active;
    }

    public String getName() {
        return modelName;
    }

    public void setName(String name) {
        this.modelName = name;
    }



    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getCaption() {
        return modelCaption;
    }

    public void setCaption(String caption) {
        this.modelCaption = caption;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }
}
