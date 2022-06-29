package service.simpleservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import service.simpleservice.domain.Mark;
import service.simpleservice.domain.Model;
import service.simpleservice.domain.Modification;
import service.simpleservice.servicies.CarService;

import java.util.List;


@RestController
public class FormController {
    @Autowired
    CarService cars;

    @GetMapping("/marks")
    public List getMarks() {
        return cars.getAllMarks();
    }

    @GetMapping("/marks/{id}")
    public Mark findMark(@PathVariable("id") long id) {
        return cars.findMarks(id);
    }


    @PostMapping("/marks")
    public void addMark(@RequestParam(value = "name", defaultValue = "no mark name") String name, @RequestParam(value = "caption", defaultValue = "no caption") String caption, @RequestParam(value = "active", defaultValue = "false") Boolean active) {
        cars.getMark(name, caption, active);
    }

    @PostMapping("/marks/{id}/models")
    public void addModel(@RequestParam(value = "name", defaultValue = "no mark name") String name, @RequestParam(value = "caption", defaultValue = "no caption") String caption, @RequestParam(value = "active", defaultValue = "false") Boolean active, @PathVariable("id") long id) {
        cars.getModel(name, caption, active, id);
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
    public void addModification(@RequestParam(value = "name", defaultValue = "no mark name") String name, @RequestParam(value = "caption", defaultValue = "no caption") String caption, @RequestParam(value = "active", defaultValue = "false") Boolean active, @PathVariable("modelid") Long modelid) {
        cars.getModification(name, caption, active, modelid);
    }


    @GetMapping("/marks/{markid}/models/{modelid}/mod")
    public List<Modification> getModificationsByModel(@PathVariable("modelid") Long modelid) {
        Model model = cars.getModelById(modelid);
        return model.getModifics();
    }

    @GetMapping("/marks/{markid}/models/{modelid}/mod/{modid}")
    public Modification getModificById(@PathVariable("modid") Long modid) {
        return cars.getModificationById(modid);
    }

}
