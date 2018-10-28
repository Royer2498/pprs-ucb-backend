package pprs.Services;

import pprs.Models.Subject;
import pprs.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> listAllSubjects() {
        return subjectRepository.findAll() ;
    }

    @Override
    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public Subject getSubject(String id) {
        return subjectRepository.findOne(id);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Override
    public void deleteById(String id) {
        subjectRepository.delete(id);
    }

    @Override
    public boolean alreadyExists(String id) {
        return subjectRepository.exists(id);
    }
}
