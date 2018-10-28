package pprs.Services;

import pprs.Models.InterviewQualificationForm;
import java.util.List;

public interface InterviewQualificationFormService {
    List<InterviewQualificationForm> listAllForms();
    void saveForm(InterviewQualificationForm interviewQualificationForm);
    InterviewQualificationForm getForm(String id);
    void deleteForm(InterviewQualificationForm interviewQualificationForm);
    void deleteById(String id);
    boolean alreadyExists(String id);
}
