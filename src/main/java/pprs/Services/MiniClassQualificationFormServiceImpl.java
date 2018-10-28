package pprs.Services;


import pprs.Models.MiniClassQualificationForm;
import pprs.Repositories.MiniClassQualificationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MiniClassQualificationFormServiceImpl implements MiniClassQualificationFormService {

    @Autowired
    private MiniClassQualificationFormRepository miniClassQualificationFormRepository;

    @Override
    public List<MiniClassQualificationForm> listAllForms() {
        return miniClassQualificationFormRepository.findAll();
    }

    @Override
    public void saveForm(MiniClassQualificationForm miniClassQualificationForm) {
        miniClassQualificationFormRepository.save(miniClassQualificationForm);
    }

    @Override
    public MiniClassQualificationForm getForm(String id) {
        return miniClassQualificationFormRepository.findOne(id);
    }

    @Override
    public void deleteForm(MiniClassQualificationForm miniClassQualificationForm) {
        miniClassQualificationFormRepository.delete(miniClassQualificationForm);
    }

    @Override
    public void deleteById(String id) {
        miniClassQualificationFormRepository.delete(id);
    }

    @Override
    public boolean alreadyExists(String id) {
        return miniClassQualificationFormRepository.exists(id);
    }
}
