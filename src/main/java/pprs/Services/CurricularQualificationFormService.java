package pprs.Services;

import pprs.Models.CurricularQualificationForm;
import java.util.List;

public interface CurricularQualificationFormService {
    List<CurricularQualificationForm> listAllForms();
    void saveForm(CurricularQualificationForm curricularQualificationForm);
    CurricularQualificationForm getForm(String id);
    void deleteForm(CurricularQualificationForm curricularQualificationForm);
    void deleteById(String id);
    boolean alreadyExists(String id);
}
