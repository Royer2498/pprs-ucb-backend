package pprs.Services;

import pprs.Models.InterviewQualificationForm;
import pprs.Repositories.InterviewQualificationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewQualificationFormServiceImpl implements InterviewQualificationFormService {

    @Autowired
    private InterviewQualificationFormRepository interviewQualificationFormRepository;

    @Override
    public List<InterviewQualificationForm> listAllForms() {
        return interviewQualificationFormRepository.findAll();
    }

    @Override
    public void saveForm(InterviewQualificationForm interviewQualificationForm) {
        interviewQualificationFormRepository.save(interviewQualificationForm);
    }

    @Override
    public InterviewQualificationForm getForm(String id) {
        return interviewQualificationFormRepository.findOne(id);
    }

    @Override
    public void deleteForm(InterviewQualificationForm interviewQualificationForm) {
        interviewQualificationFormRepository.delete(interviewQualificationForm);
    }

    @Override
    public void deleteById(String id) {
        interviewQualificationFormRepository.delete(id);
    }

    @Override
    public boolean alreadyExists(String id) {
        return interviewQualificationFormRepository.exists(id);
    }
}
