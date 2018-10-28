package pprs;
import com.fasterxml.jackson.databind.ObjectMapper;
import pprs.Controllers.ConvocatoryController;
import pprs.Models.Convocatory;
import pprs.Services.ConvocatoryService;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConvocatoryController.class)
@AutoConfigureMockMvc
public class ConvocatoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ConvocatoryService convocatoryService;

    @Test
    public void givenConvocatoriesWhenGetConvocatoriesThenReturnTheSameConvocatories() throws Exception {
        List<Convocatory> convocatories = new ArrayList<>();
        Convocatory convocatory = new Convocatory();
        convocatory.setDepartment("Exactas");
        convocatory.setDeadline("25/08/2018");
        convocatory.setSubjects(new ArrayList());
        convocatories.add(convocatory);
        given(convocatoryService.listAllConvocatories()).willReturn(convocatories);
        mvc.perform(get("/convocatories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].department").value(convocatories.get(0).getDepartment()))
                .andExpect(jsonPath("$[0].subjects").value(convocatories.get(0).getSubjects()))
                .andExpect(jsonPath("$[0].deadline").value(convocatories.get(0).getDeadline()));
    }

    @Test
    public void whenThereAreNotConvocatoriesThenReturnNotFoundResponse() throws Exception{
        List<Convocatory> EmptyListOfConvocatories = new ArrayList<Convocatory>();
        given(convocatoryService.listAllConvocatories()).willReturn(EmptyListOfConvocatories);
        mvc.perform(get("/convocatories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void givenAConvocatoryWhenGetConvocatoryThenReturnTheSameConvocatory() throws Exception{
        Convocatory convocatory = new Convocatory();
        convocatory.setDepartment("Leyes");
        convocatory.setDeadline("24/08/1998");
        convocatory.setSubjects(new ArrayList());
        given(convocatoryService.getConvocatory((any(String.class)))).willReturn(convocatory);
        mvc.perform(get("/convocatory/" + convocatory.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.department").value(convocatory.getDepartment()))
                .andExpect(jsonPath("$.subjects").value(convocatory.getSubjects()))
                .andExpect(jsonPath("$.deadline").value(convocatory.getDeadline()));
    }

    @Test
    public void givenAConvocatoryThatNotExistsWhenGetConvocatoryThenReturnANotFoundResponse() throws Exception{
        Convocatory convocatory = new Convocatory();
        convocatory.setDepartment("Leyes");
        convocatory.setDeadline("24/08/1998");
        convocatory.setSubjects(new ArrayList());
        given(convocatoryService.getConvocatory((any(String.class)))).willReturn(null);
        mvc.perform(get("/convocatory/" + convocatory.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void deleteAConvocatoryThatAlreadyExistsReturnStatusNoContent() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Convocatory convocatory = new Convocatory();
        convocatory.setId("1");
        convocatory.setDepartment("Leyes");
        convocatory.setDeadline("24/08/1998");
        convocatory.setSubjects(new ArrayList());
        when(convocatoryService.alreadyExists(convocatory.getId())).thenReturn(true);
        doNothing().when(convocatoryService).deleteConvocatory(convocatory);
        mvc.perform(delete("/convocatory/delete")
                .content(mapper.writeValueAsString(convocatory))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteAConvocatoryThatNoExistsReturnsANotFoundResponse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Convocatory convocatory = new Convocatory();
        convocatory.setId("1");
        convocatory.setDepartment("Leyes");
        convocatory.setDeadline("24/08/1998");
        convocatory.setSubjects(new ArrayList());
        when(convocatoryService.alreadyExists(convocatory.getId())).thenReturn(false);
        doNothing().when(convocatoryService).deleteConvocatory(convocatory);
        mvc.perform(delete("/convocatory/delete")
                .content(mapper.writeValueAsString(convocatory))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void saveAConvocatoryTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Convocatory convocatory = new Convocatory();
        convocatory.setDepartment("Leyes");
        convocatory.setDeadline("24/08/1998");
        convocatory.setSubjects(new ArrayList());
        doNothing().when(convocatoryService).saveConvocatory(convocatory);
        mvc.perform(post("/convocatory")
                .content(mapper.writeValueAsString(convocatory))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}

