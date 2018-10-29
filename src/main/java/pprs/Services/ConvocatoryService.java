package pprs.Services;
import pprs.Models.Convocatory;
import java.util.List;

public interface ConvocatoryService {

    List<Convocatory> listAllConvocatories();
    List<Convocatory> listConvocatoriesByDepartment(String department);
    void saveConvocatory(Convocatory convocatory);
    Convocatory getConvocatory(String id);
    void deleteConvocatory(Convocatory convocatory);
    void deleteById(String id);
    boolean alreadyExists(String id);
}
