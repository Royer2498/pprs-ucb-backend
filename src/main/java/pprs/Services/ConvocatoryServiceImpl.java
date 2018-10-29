package pprs.Services;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pprs.Models.Convocatory;
import pprs.Repositories.ConvocatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ConvocatoryServiceImpl implements ConvocatoryService {

    private ConvocatoryRepository convocatoryRepository;
    private final MongoOperations mongoOperations;

    @Autowired
    public ConvocatoryServiceImpl(ConvocatoryRepository convocatoryRepository, MongoOperations mongoOperations) {
        this.convocatoryRepository = convocatoryRepository;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<Convocatory> listAllConvocatories() {
        return convocatoryRepository.findAll();
    }

    @Override
    public List<Convocatory> listConvocatoriesByDepartment(String department) {
        Query query = new Query();
        query.addCriteria(Criteria.where("department").is(department));
        if (mongoOperations.exists(query, Convocatory.class))
            return mongoOperations.find(query, Convocatory.class);
        else
            return null;
    }

    @Override
    public void saveConvocatory(@RequestBody Convocatory convocatory) {
        convocatoryRepository.save(convocatory);
    }

    @Override
    public Convocatory getConvocatory(String id) {
        return convocatoryRepository.findOne(id);
    }

    @Override
    public void deleteConvocatory(@RequestBody Convocatory convocatory) {
        convocatoryRepository.delete(convocatory);
    }

    @Override
    public void deleteById(String id) {
        convocatoryRepository.delete(id);
    }

    @Override
    public boolean alreadyExists(String id) {
        return convocatoryRepository.exists(id);
    }
}
