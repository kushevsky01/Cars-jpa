package service.simpleservice.domain;

import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Search {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String markName;
    private String modelName;
    private String body;
    private int beginPeriod;
    private int endPeriod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getBeginPeriod() {
        return beginPeriod;
    }

    public void setBeginPeriod(int beginPeriod) {
        this.beginPeriod = beginPeriod;
    }

    public int getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod) {
        this.endPeriod = endPeriod;
    }

    public List notNullParameters(Search search) {
        List param = new ArrayList();

        if (search.getMarkName() != null) {
            param.add(search.getMarkName());
        }
        if (search.getModelName() != null) {
            param.add(search.getModelName());
        }
        if (search.getBody() != null) {
            param.add(search.getBody());
        }
        if (search.getBeginPeriod() != 0) {
            param.add(search.getBeginPeriod());
        }
        if (search.getEndPeriod() != 0) {
            param.add(search.getEndPeriod());
        }
        return param;
    }
}
