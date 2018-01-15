package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.BaseDao;
import models.entities.BaseEntity;
import org.springframework.transaction.annotation.Transactional;
import play.libs.Json;

import java.util.List;

/**
 * Created by Chirrag on 15/01/18.
 */
public abstract class BaseService<T extends BaseEntity> {

    abstract BaseDao<T> getDao() ;

    abstract Class<T> getTypeClass() ;

    @Transactional
    public T find( int primaryKey) {
        return getDao().find(getTypeClass(), primaryKey);
    }

    @Transactional
    public List<T> list() {
        return getDao().list(getTypeClass());
    }

    @Transactional
    public T save(JsonNode jsonData) {
        T model = Json.fromJson(jsonData, getTypeClass());
        return getDao().save(model);
    }

    @Transactional
    public T edit(int id, JsonNode jsonData) {
        T model = Json.fromJson(jsonData, getTypeClass());
        return getDao().edit(model);
    }

    @Transactional
    public void remove(int primaryKey) {
        getDao().remove(getTypeClass(), primaryKey);
    }

}
