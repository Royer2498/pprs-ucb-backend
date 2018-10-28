package pprs.Controllers;

import pprs.Controllers.exception.ConvocatoriesNotFoundException;
import pprs.Controllers.exception.ConvocatoryNotFoundException;
import pprs.Models.Convocatory;
import pprs.Services.ConvocatoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConvocatoryController {

    @Autowired
    private ConvocatoryService convocatoryService;

    @GetMapping(value = "/convocatories")
    public List<Convocatory> listConvocatories() throws ConvocatoriesNotFoundException {
        List<Convocatory> allConvocatories = convocatoryService.listAllConvocatories();
        if (allConvocatories.isEmpty()) {
            throw new ConvocatoriesNotFoundException();
        }
        return allConvocatories;
    }

    @DeleteMapping(value = "/convocatory/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConvocatory(@RequestBody Convocatory convocatory) throws ConvocatoryNotFoundException {
        String idConvocatory = convocatory.getId();
        if (!convocatoryService.alreadyExists(idConvocatory)) {
            throw new ConvocatoryNotFoundException(idConvocatory);
        }
        convocatoryService.deleteConvocatory(convocatory);
    }

    @GetMapping(value = "/convocatory/{id}")
    public Convocatory showConvocatory(@PathVariable String id) throws ConvocatoryNotFoundException {
        Convocatory convocatory = convocatoryService.getConvocatory(id);
        if (convocatory == null) {
            throw new ConvocatoryNotFoundException(id);
        }
        return convocatory;
    }

    @PostMapping(value = "/convocatory")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveConvocatory(@RequestBody Convocatory convocatory) throws HttpMessageNotReadableException {
        convocatoryService.saveConvocatory(convocatory);
    }

    @PutMapping(value = "/convocatory/edit/{id}")
    public void editConvocatory(@RequestBody Convocatory convocatory) throws HttpMessageNotReadableException {
        convocatoryService.saveConvocatory(convocatory);
    }
}