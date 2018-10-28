package pprs.Services;

import pprs.Models.GlobalPlanQualificationForm;
import pprs.Repositories.GlobalPlanQualificationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalPlanQualificationFormServiceImpl implements GlobalPlanQualificationFormService {

    @Autowired
    private GlobalPlanQualificationFormRepository globalPlanQualificationFormRepository;

    @Override
    public List<GlobalPlanQualificationForm> listAllForms() {
        return globalPlanQualificationFormRepository.findAll();
    }

    @Override
    public void saveForm(GlobalPlanQualificationForm globalPlanQualificationForm) {
        globalPlanQualificationFormRepository.save(globalPlanQualificationForm);
    }

    @Override
    public GlobalPlanQualificationForm getForm(String id) {
        return globalPlanQualificationFormRepository.findOne(id);
    }

    @Override
    public void deleteForm(GlobalPlanQualificationForm globalPlanQualificationForm) {
        globalPlanQualificationFormRepository.delete(globalPlanQualificationForm);
    }

    @Override
    public void deleteById(String id) {
        globalPlanQualificationFormRepository.delete(id);
    }

    @Override
    public boolean alreadyExists(String id) {
        return globalPlanQualificationFormRepository.exists(id);
    }
}
