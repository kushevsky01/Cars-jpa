package service.simpleservice.servicies;

import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.simpleservice.domain.Mark;
import service.simpleservice.domain.Model;
import service.simpleservice.domain.Modification;
import service.simpleservice.repositories.MarkRepository;
import service.simpleservice.repositories.ModelRepository;
import service.simpleservice.repositories.ModificationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    MarkRepository markrepo;

    @Autowired
    ModelRepository modelrepo;

    @Autowired
    ModificationRepository modificationrepo;

    public List getAllMarks() {
        List marks = new ArrayList();
        markrepo.findAll().forEach(book -> marks.add(book));
        return marks;
    }

    public void getMark(String name, String caption, Boolean active) {
        Mark mark = new Mark();
        mark.setName(name);
        mark.setCaption(caption);
        mark.setActive(active);
        markrepo.save(mark);
    }

    public Mark findMarks(long id) {

        return markrepo.findById(id).get();
    }

    public void getModel(String name, String caption, Boolean active, Long id) {

        Mark mark = findMarks(id);
        Model model = new Model();
        model.setName(name);
        model.setCaption(caption);
        model.setActive(active);
        model.setMark(findMarks(id));
        modelrepo.save(model);

    }

    public Model getModelById(Long modelId) {
        return modelrepo.findById(modelId).get();
    }


    public void getModification(String name, String caption, Boolean active, Long modelid) {
        Model model = getModelById(modelid);
        Modification mod = new Modification();
        mod.setName(name);
        mod.setCaption(caption);
        mod.setActive(active);
        mod.setModel(model);
        modificationrepo.save(mod);

    }

    public Modification getModificationById(Long modId) {
        return modificationrepo.findById(modId).get();
    }

}

