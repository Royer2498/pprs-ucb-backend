package pprs.Services;

import pprs.Models.MiniClassQualificationForm;
import java.util.List;

public interface MiniClassQualificationFormService {

    List<MiniClassQualificationForm> listAllForms();
    void saveForm(MiniClassQualificationForm miniClassQualificationForm);
    MiniClassQualificationForm getForm(String id);
    void deleteForm(MiniClassQualificationForm miniClassQualificationForm);
    void deleteById(String id);
    boolean alreadyExists(String id);
}
