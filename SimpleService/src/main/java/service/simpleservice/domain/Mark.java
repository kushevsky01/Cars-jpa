package service.simpleservice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Mark {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private boolean markActive;
    private String markName;
    private String markCaption;

    @JsonManagedReference
    @OneToMany(mappedBy = "mark", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Model> models = new ArrayList<>();

    public Mark() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return markActive;
    }

    public void setActive(boolean active) {
        this.markActive = active;
    }



    public String getName() {
        return markName;
    }

    public void setName(String name) {
        this.markName = name;
    }

    public String getCaption() {
        return markCaption;
    }

    public void setCaption(String caption) {
        this.markCaption = caption;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
    public void addModels(Model model){
        models.add(model);
    }
}
