package service.simpleservice.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.simpleservice.domain.Mark;
import service.simpleservice.domain.Model;
import service.simpleservice.domain.Modification;
import service.simpleservice.domain.Search;
import service.simpleservice.repositories.MarkRepository;
import service.simpleservice.repositories.ModelRepository;
import service.simpleservice.repositories.ModificationRepository;
import service.simpleservice.repositories.SearchReposirory;

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

    @Autowired
    SearchReposirory searchrepo;

    public List getAllMarks() {
        List marks = new ArrayList();
        markrepo.findAll().forEach(book -> marks.add(book));
        return marks;
    }

    public void getMark(Mark mark) {
        markrepo.save(mark);
    }

    public Mark findMarks(long id) {

        return markrepo.findById(id).get();
    }

    public void getModel(Model model, Long id) {
        model.setMark(findMarks(id));
        modelrepo.save(model);

    }

    public Model getModelById(Long modelId) {
        return modelrepo.findById(modelId).get();
    }


    public void getModification(Modification mod, Long modelid) {
        mod.setModel(getModelById(modelid));
        modificationrepo.save(mod);

    }


    public Modification getModificationById(Long modId) {
        return modificationrepo.findById(modId).get();
    }

}

