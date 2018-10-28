package pprs.Services;

import pprs.Models.CurricularQualificationForm;
import pprs.Repositories.CurricularQualificationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurricularQualificationFormServiceImpl implements CurricularQualificationFormService {

    @Autowired
    private CurricularQualificationFormRepository curricularQualificationFormRepository;

    @Override
    public List<CurricularQualificationForm> listAllForms() {
        return curricularQualificationFormRepository.findAll();
    }

    @Override
    public void saveForm(CurricularQualificationForm curricularQualificationForm) {
        curricularQualificationFormRepository.save(curricularQualificationForm);
    }

    @Override
    public CurricularQualificationForm getForm(String id) {
        return curricularQualificationFormRepository.findOne(id);
    }

    @Override
    public void deleteForm(CurricularQualificationForm curricularQualificationForm) {
        curricularQualificationFormRepository.delete(curricularQualificationForm);
    }

    @Override
    public void deleteById(String id) {
        curricularQualificationFormRepository.delete(id);
    }

    @Override
    public boolean alreadyExists(String id) {
        return curricularQualificationFormRepository.exists(id);
    }
}
