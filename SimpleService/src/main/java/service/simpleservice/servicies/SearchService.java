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

public class SearchService {

    @Autowired
    MarkRepository markrepo;

    @Autowired
    ModelRepository modelrepo;

    @Autowired
    ModificationRepository modificationrepo;

    @Autowired
    SearchReposirory searchrepo;

    public Mark getMarkByName(String markName) {
        return markrepo.findMarkByMarkName(markName);
    }

    public List<Model> getModelByName(String modelName) {
        return modelrepo.findModelByModelName(modelName);
    }

    public Mark getMarkAnandModel(String markName, String modelName) {
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            if (model.getName().equals(modelName)) {
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }
        return mark;
    }

    public Mark getMarkAndModelAndModification(String markName, String modelName, String body) {
        List<Modification> modifics = new ArrayList<>();
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        mark.setModels(null);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            for (Modification modification : model.getModifications()) {

                if (modification.getBody().equals(body)) {
                    modifics.add(modification);
                    model.setModifications(null);
                    model.setModifications(modifics);
                }
            }

            if (model.getName().equals(modelName) && modifics.size() != 0) {
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }

        if (modifics.size() == 0) {
            mark = null;
        }
        return mark;
    }

    public Mark getMarkAndModelAndBeginPeriod(String markName, String modelName, int BeginPeriod) {
        List<Modification> modifics = new ArrayList<>();
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        mark.setModels(null);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            for (Modification modification : model.getModifications()) {

                if (modification.getBeginPeriod() >= BeginPeriod) {
                    modifics.add(modification);
                }
            }


            if (model.getName().equals(modelName) && modifics.size() != 0) {
                model.setModifications(null);
                model.setModifications(modifics);
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }

        if (modifics.size() == 0) {
            mark = null;
        }
        return mark;
    }

    public Mark getMarkAndModelAndEndPeriod(String markName, String modelName, int EndPeriod) {
        List<Modification> modifics = new ArrayList<>();
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        mark.setModels(null);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            for (Modification modification : model.getModifications()) {

                if (modification.getEndPeriod() <= EndPeriod) {
                    modifics.add(modification);

                }
            }

            if (model.getName().equals(modelName) && modifics.size() != 0) {
                model.setModifications(null);
                model.setModifications(modifics);
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }

        if (modifics.size() == 0) {
            mark = null;
        }
        return mark;
    }

    public Mark getMarkAndModelAndBodyAndEndPeriod(String markName, String modelName, String body, int EndPeriod) {
        List<Modification> modifics = new ArrayList<>();
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        mark.setModels(null);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            for (Modification modification : model.getModifications()) {

                if (modification.getEndPeriod() <= EndPeriod && modification.getBody().equals(body)) {
                    modifics.add(modification);

                }
            }

            if (model.getName().equals(modelName) && modifics.size() != 0) {
                model.setModifications(null);
                model.setModifications(modifics);
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }

        if (modifics.size() == 0) {
            mark = null;
        }
        return mark;
    }

    public Mark getMarkAndModelAndBodyAndBeginPeriod(String markName, String modelName, String body, int BeginPeriod) {
        List<Modification> modifics = new ArrayList<>();
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        mark.setModels(null);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            for (Modification modification : model.getModifications()) {

                if ((modification.getBeginPeriod() >= BeginPeriod) && (modification.getBody().equals(body))) {
                    modifics.add(modification);
                }
            }

            if (model.getName().equals(modelName) && modifics.size() != 0) {
                model.setModifications(null);
                model.setModifications(modifics);
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }
        if (modifics.size() == 0) {
            mark = null;
        }
        return mark;
    }

    public boolean getPeriod(int Begin1, int Begin2, int End1, int End2){

        return true;
    }

    public Mark getMarkAndModelAndBeginPeriodAndEndPeriod(String markName, String modelName, int BeginPeriod, int EndPeriod) {
        List<Modification> modifics = new ArrayList<>();
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        mark.setModels(null);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            for (Modification modification : model.getModifications()) {

                if (modification.getBeginPeriod() >= BeginPeriod && modification.getEndPeriod() <= EndPeriod) {
                    modifics.add(modification);
                }
            }

            if (model.getName().equals(modelName) && modifics.size() != 0) {
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }

        if (modifics.size() == 0) {
            mark = null;
        }
        return mark;
    }

    public Mark getMarkAndModelAndBodyAndBeginPeriodAndEndPeriod(String markName, String modelName, String body, int BeginPeriod, int EndPeriod) {
        List<Modification> modifics = new ArrayList<>();
        List<Model> modelss = new ArrayList<>();
        Mark mark = getMarkByName(markName);
        mark.setModels(null);
        List<Model> models = getModelByName(modelName);
        for (Model model : models) {
            for (Modification modification : model.getModifications()) {

                if (modification.getBeginPeriod() >= BeginPeriod && modification.getEndPeriod() <= EndPeriod && modification.getBody().equals(body)) {
                    modifics.add(modification);
                }
            }

            if (model.getName().equals(modelName) && modifics.size() != 0) {
                model.setModifications(null);
                model.setModifications(modifics);
                modelss.add(model);
                mark.setModels(null);
                mark.setModels(modelss);
            }
        }

        if (modifics.size() == 0) {
            mark = null;
        }
        return mark;
    }

    public Mark searching(Search search) {

        Mark mark = null;
        List param = search.notNullParameters(search);
        if (param.size() == 1) {

            if (search.getMarkName() != null) {
                System.out.println(search.getMarkName());
                return markrepo.findMarkByMarkName(search.getMarkName());
            }
        } else if (param.size() == 2) {

            if (search.getMarkName() != null && search.getModelName() != null) {
                return getMarkAnandModel(search.getMarkName(), search.getModelName());
            }
        } else if (param.size() == 3) {

            if (search.getMarkName() != null && search.getModelName() != null && search.getBody() != null) {
                return getMarkAndModelAndModification(search.getMarkName(), search.getModelName(), search.getBody());

            } else if (search.getMarkName() != null && search.getModelName() != null && search.getBeginPeriod() != 0) {
                return getMarkAndModelAndBeginPeriod(search.getMarkName(), search.getModelName(), search.getBeginPeriod());

            } else if (search.getMarkName() != null && search.getModelName() != null && search.getEndPeriod() != 0) {
                return getMarkAndModelAndEndPeriod(search.getMarkName(), search.getModelName(), search.getEndPeriod());
            }

        } else if (param.size() == 4) {

            if (search.getMarkName() != null && search.getModelName() != null && search.getBody() != null && search.getBeginPeriod() != 0) {
                return getMarkAndModelAndBodyAndBeginPeriod(search.getMarkName(), search.getModelName(), search.getBody(), search.getBeginPeriod());

            } else if (search.getMarkName() != null && search.getModelName() != null && search.getBody() != null && search.getEndPeriod() != 0) {
                return getMarkAndModelAndBodyAndEndPeriod(search.getMarkName(), search.getModelName(), search.getBody(), search.getEndPeriod());

            } else if (search.getMarkName() != null && search.getModelName() != null && search.getBeginPeriod() != 0 && search.getEndPeriod() != 0) {
                return getMarkAndModelAndBeginPeriodAndEndPeriod(search.getMarkName(), search.getModelName(), search.getBeginPeriod(), search.getEndPeriod());
            }

        } else if (param.size() == 5) {
            if (search.getMarkName() != null && search.getModelName() != null && search.getBody() != null && search.getBeginPeriod() != 0 && search.getEndPeriod() != 0) {
                return getMarkAndModelAndBodyAndBeginPeriodAndEndPeriod(search.getMarkName(), search.getModelName(), search.getBody(), search.getBeginPeriod(), search.getEndPeriod());
            }
        }
        return mark;
    }
}
