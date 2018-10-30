package pprs.Controllers;

import org.springframework.beans.factory.annotation.Value;
import pprs.Controllers.exception.ConvocatoriesNotFoundException;
import pprs.Controllers.exception.ConvocatoryNotFoundException;
import pprs.Models.Convocatory;
import pprs.Services.ConvocatoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConvocatoryController {

    @Autowired
    private ConvocatoryService convocatoryService;

    @GetMapping(value = "/convocatories")
    public List<Convocatory> listConvocatories(@RequestParam(value="department", required=false) String department) throws ConvocatoriesNotFoundException {
        List<Convocatory> convocatories;
        System.out.println(department);
        if (department != null)
            convocatories = convocatoryService.listConvocatoriesByDepartment(department);
        else
            convocatories = convocatoryService.listAllConvocatories();
        if (convocatories.isEmpty()) {
            throw new ConvocatoriesNotFoundException();
        }
        return convocatories;
    }

    @DeleteMapping(value = "/convocatory/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConvocatory(@PathVariable String id) throws ConvocatoryNotFoundException {
        if (!convocatoryService.alreadyExists(id)) {
            throw new ConvocatoryNotFoundException(id);
        }
        convocatoryService.deleteById(id);
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
    public void saveConvocatory(@Valid @RequestBody Convocatory convocatory) throws HttpMessageNotReadableException {
        convocatoryService.saveConvocatory(convocatory);
    }

    @PutMapping(value = "/convocatory")
    public void editConvocatory(@Valid @RequestBody Convocatory convocatory) throws HttpMessageNotReadableException {
        convocatoryService.saveConvocatory(convocatory);
    }
}