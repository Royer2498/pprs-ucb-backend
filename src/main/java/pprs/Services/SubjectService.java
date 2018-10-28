package pprs.Services;

import pprs.Models.Subject;
import java.util.List;

public interface SubjectService {

    List<Subject> listAllSubjects();
    void saveSubject(Subject subject);
    Subject getSubject(String id);
    void deleteSubject(Subject subject);
    void deleteById(String id);
    boolean alreadyExists(String id);
}
