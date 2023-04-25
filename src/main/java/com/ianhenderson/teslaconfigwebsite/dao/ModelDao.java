package com.ianhenderson.teslaconfigwebsite.dao;
import com.ianhenderson.teslaconfigwebsite.model.Model;
import java.util.List;


public interface ModelDao {
    Model getModel(int modelId);

    List<Model> getModels();
    Model createModel(Model newModel);

    void updateModel(Model updatedModel);
}

