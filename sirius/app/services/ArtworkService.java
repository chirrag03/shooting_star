package services;

import models.dao.ArtworkDao;
import models.dao.BaseDao;
import models.entities.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chirrag on 15/01/18.
 */
@Service("artworkService")
@Transactional
public class ArtworkService extends BaseService<Artwork> {

    @Autowired
    private ArtworkDao artworkDao;

    @Override
    BaseDao<Artwork> getDao() {
        return artworkDao;
    }

    @Override
    Class<Artwork> getTypeClass() {
        return Artwork.class;
    }

}
