package pprs;

import com.fasterxml.jackson.databind.ObjectMapper;
import pprs.Controllers.SubjectController;
import pprs.Models.Subject;
import pprs.Services.SubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SubjectController.class)
@AutoConfigureMockMvc
public class SubjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SubjectService subjectService;

    @Test
    public void saveSubjectTest() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Subject subject = new Subject();
        subject.setId("1");
        subject.setDepartment("Idiomas");
        subject.setInitials("IDI-123");
        subject.setMajor("Major");
        subject.setName("Lenguaje");
        doNothing().when(subjectService).saveSubject(subject);
        mvc.perform(post("/subject").content(mapper.writeValueAsString(subject))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenSubjectsWhenGetSubjectsThenReturnASubjectArray() throws Exception{
        Subject subject = new Subject();
        subject.setId("1");
        subject.setDepartment("Idiomas");
        subject.setInitials("IDI-123");
        subject.setMajor("Major");
        subject.setName("Lenguaje");
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
        when(subjectService.listAllSubjects()).thenReturn(subjects);
        mvc.perform(get("/subject")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(subjects.get(0).getId()))
                .andExpect(jsonPath("$[0].department").value(subjects.get(0).getDepartment()))
                .andExpect(jsonPath("$[0].initials").value(subjects.get(0).getInitials()))
                .andExpect(jsonPath("$[0].major").value(subjects.get(0).getMajor()))
                .andExpect(jsonPath("$[0].name").value(subjects.get(0).getName()));
    }

    @Test
    public void whenThereAreNotSubjectsThenReturnNotFoundResponse() throws Exception{
        List<Subject> subjects = new ArrayList<>();
        when(subjectService.listAllSubjects()).thenReturn(subjects);
        mvc.perform(get("/subject")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
