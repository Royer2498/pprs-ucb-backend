package pprs;

import com.fasterxml.jackson.databind.ObjectMapper;
import pprs.Controllers.FormController;
import pprs.Models.MiniClassQualificationForm;
import pprs.Models.CurricularQualificationForm;
import pprs.Models.InterviewQualificationForm;
import pprs.Models.GlobalPlanQualificationForm;
import pprs.Services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FormController.class)
@AutoConfigureMockMvc
public class FormControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CurricularQualificationFormService curricularQualificationFormService;

    @MockBean
    private GlobalPlanQualificationFormService globalPlanQualificationFormService;

    @MockBean
    private InterviewQualificationFormService interviewQualificationFormService;

    @MockBean
    private MiniClassQualificationFormService miniClassQualificationFormService;

    @Test
    public void saveFormOneTest() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        CurricularQualificationForm form = new CurricularQualificationForm();
        form.setId("1");
        doNothing().when(curricularQualificationFormService).saveForm(form);
        mvc.perform(post("/curricularQualificationForm").content(mapper.writeValueAsString(form))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void saveFormTwoTest() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        GlobalPlanQualificationForm form = new GlobalPlanQualificationForm();
        form.setId("1");
        doNothing().when(globalPlanQualificationFormService).saveForm(form);
        mvc.perform(post("/globalPlanQualificationForm").content(mapper.writeValueAsString(form))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void saveFormThreeTest() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        InterviewQualificationForm form = new InterviewQualificationForm();
        form.setId("1");
        doNothing().when(interviewQualificationFormService).saveForm(form);
        mvc.perform(post("/interviewQualificationForm").content(mapper.writeValueAsString(form))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void saveFormFourTest() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        MiniClassQualificationForm form = new MiniClassQualificationForm();
        form.setId("1");
        doNothing().when(miniClassQualificationFormService).saveForm(form);
        mvc.perform(post("/miniClassQualificationForm").content(mapper.writeValueAsString(form))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
