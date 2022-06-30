package service.simpleservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import service.simpleservice.domain.Mark;
import service.simpleservice.domain.Model;
import service.simpleservice.domain.Modification;
import service.simpleservice.domain.Search;
import service.simpleservice.servicies.CarService;
import service.simpleservice.servicies.SearchService;

import java.util.List;


@RestController
public class FormController {
    @Autowired
    CarService cars;

    @Autowired
    SearchService Serv;

    @GetMapping("/marks")
    public List getMarks() {
        return cars.getAllMarks();
    }

    @GetMapping("/marks/{id}")
    public Mark findMark(@PathVariable("id") long id) {
        return cars.findMarks(id);
    }


    @PostMapping("/marks")
    public void addMark(@RequestBody Mark mark) {
        cars.getMark(mark);
    }

    @PostMapping("/marks/{id}/models")
    public void addModel(@RequestBody Model model, @PathVariable("id") long id) {
        cars.getModel(model, id);
    }


    @GetMapping("/marks/{id}/models")
    public List<Model> getModelsByMark(@PathVariable("id") Long id) {
        Mark mark = findMark(id);
        return mark.getModels();
    }

    @GetMapping("/marks/{markid}/models/{modelid}")
    public Model getCars(@PathVariable("modelid") Long modelid) {
        return cars.getModelById(modelid);
    }


    @PostMapping("/marks/{markid}/models/{modelid}/mod")
    public void addModification(@RequestBody Modification mod, @PathVariable("modelid") Long modelid) {
        cars.getModification(mod, modelid);
    }


    @GetMapping("/marks/{markid}/models/{modelid}/mod")
    public List<Modification> getModificationsByModel(@PathVariable("modelid") Long modelid) {
        Model model = cars.getModelById(modelid);
        return model.getModifications();
    }

    @GetMapping("/marks/{markid}/models/{modelid}/mod/{modid}")
    public Modification getModificById(@PathVariable("modid") Long modid) {
        return cars.getModificationById(modid);
    }

    @PostMapping("/search")
    public Mark getSearch(@RequestBody Search search) {
        return Serv.searching(search);
    }

}
