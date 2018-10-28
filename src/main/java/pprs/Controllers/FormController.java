package pprs.Controllers;

import pprs.Models.*;
import pprs.Services.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
public class FormController {

    @Autowired
    private CurricularQualificationFormService curricularQualificationFormService;
    @Autowired
    private GlobalPlanQualificationFormService globalPlanQualificationFormService;
    @Autowired
    private InterviewQualificationFormService interviewQualificationFormService;
    @Autowired
    private MiniClassQualificationFormService miniClassQualificationFormService;

    @PostMapping(value = "/curricularQualificationForm")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCurricularQualificationForm(@RequestBody String formOne) throws HttpMessageNotReadableException {
        CurricularQualificationForm curricularQualificationFormAux = new CurricularQualificationForm();
        curricularQualificationFormAux.setContent(Document.parse(formOne));
        curricularQualificationFormService.saveForm(curricularQualificationFormAux);
    }

    @PostMapping(value = "/globalPlanQualificationForm")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveGlobalPlanQualificationForm(@RequestBody String formTwo) throws HttpMessageNotReadableException {
        GlobalPlanQualificationForm globalPlanQualificationFormAux = new GlobalPlanQualificationForm();
        globalPlanQualificationFormAux.setContent(formTwo);
        globalPlanQualificationFormService.saveForm(globalPlanQualificationFormAux);
    }

    @PostMapping(value = "/interviewQualificationForm")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveInterviewQualificationForm(@RequestBody String formThree) throws HttpMessageNotReadableException {
        InterviewQualificationForm interviewQualificationFormAux = new InterviewQualificationForm();
        interviewQualificationFormAux.setContent(formThree);
        interviewQualificationFormService.saveForm(interviewQualificationFormAux);
    }

    @PostMapping(value = "/miniClassQualificationForm")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMiniClassQualificationForm(@RequestBody String formFour) throws HttpMessageNotReadableException {
        MiniClassQualificationForm miniClassQualificationFormAux = new MiniClassQualificationForm();
        miniClassQualificationFormAux.setContent(formFour);
        miniClassQualificationFormService.saveForm(miniClassQualificationFormAux);
    }
}