package pprs.Services;

import pprs.Models.GlobalPlanQualificationForm;
import java.util.List;

public interface GlobalPlanQualificationFormService {

    List<GlobalPlanQualificationForm> listAllForms();
    void saveForm(GlobalPlanQualificationForm globalPlanQualificationForm);
    GlobalPlanQualificationForm getForm(String id);
    void deleteForm(GlobalPlanQualificationForm globalPlanQualificationForm);
    void deleteById(String id);
    boolean alreadyExists(String id);
}
