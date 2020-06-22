package com.mg.backend001.config;

import com.mg.backend001.entity.*;
import com.mg.backend001.model.*;
import org.modelmapper.ModelMapper;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Mapper extends ModelMapper {

    public <E, M> M toModel(E entity){
        if(entity==null){
            return null;
        }
        if(entity.getClass().getSimpleName().startsWith("Person")){
            return this.map(entity, (Type) PersonModel.class);
        }
        return null;
    }

    public <E, M> List<M> toModels(List<E> entities){
        if(entities==null){
            return null;
        }
        if(entities.get(0).getClass().getSimpleName().startsWith("Person")){
            List<PersonModel> models = new ArrayList<>();
            for(E entity : entities){
                models.add(toModel(entity));
            }
            return (List<M>) models;
        }
        return null;
    }

    public <M, E> E toEntity(M model){
        if(model==null){
            return null;
        }
        if(model.getClass().getSimpleName().startsWith("PersonModel")){
            return this.map(model, (Type) Person.class);
        }
        return null;
    }

    public <M, E> List<E> toEntities(List<M> models){
        if(models==null){
            return null;
        }
        if(models.get(0).getClass().getSimpleName().startsWith("CountryModel")){
            List<Person> entities = new ArrayList<>();
            for(M model : models){
                entities.add(toEntity(model));
            }
            return (List<E>) entities;
        }
        return null;
    }

}
