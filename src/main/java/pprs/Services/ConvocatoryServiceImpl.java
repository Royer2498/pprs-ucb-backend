package pprs.Services;

import pprs.Models.Convocatory;
import pprs.Repositories.ConvocatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ConvocatoryServiceImpl implements ConvocatoryService {

    private ConvocatoryRepository convocatoryRepository;


    @Autowired
    public void setConvocatoryController(ConvocatoryRepository convocatoryRepository){
        this.convocatoryRepository = convocatoryRepository;
    }

    @Override
    public List<Convocatory> listAllConvocatories() {
        return convocatoryRepository.findAll();
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
