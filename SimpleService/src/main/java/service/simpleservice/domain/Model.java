package service.simpleservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Mod_TABLE")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private boolean active;
    private String name;
    private String caption;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @JsonBackReference
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Modification> modifications = new ArrayList<>();
    public Model(){

    }

    public Model(String name, boolean active, String caption, Mark mark){
        this.name=name;
        this.active=active;
        this.caption=caption;
        this.mark=mark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Modification> getModifics() {
        return modifications;
    }

    public void setModifics(List<Modification> modifics) {
        this.modifications = modifics;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}
