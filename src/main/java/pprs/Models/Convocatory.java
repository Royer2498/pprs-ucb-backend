package pprs.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Convocatories")
public class Convocatory {

    @Id
    @Size(min = 1)
    private String id;
    @Size(min = 1)
    private String department;
    @Size(min = 1)
    private String deadline;
    @Size(min = 1)
    private List subjects = new ArrayList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public List getSubjects() { return subjects; }

    public void setSubjects(List subjects) {
        this.subjects = subjects;
    }
}
