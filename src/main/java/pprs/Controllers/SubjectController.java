package pprs.Controllers;

import pprs.Controllers.exception.SubjectsNotFoundException;
import pprs.Models.Subject;
import pprs.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "/subject")
    public void saveSubject(@Valid @RequestBody Subject subject) throws HttpMessageNotReadableException {
        subjectService.saveSubject(subject);
    }

    @GetMapping(value = "/subjects")
    public List<Subject> listSubjects() throws SubjectsNotFoundException {
        List<Subject> allSubjects = subjectService.listAllSubjects();
        if(allSubjects.isEmpty()){
            throw new SubjectsNotFoundException("Materias no encontradas");
        }
        return allSubjects;
    }
}