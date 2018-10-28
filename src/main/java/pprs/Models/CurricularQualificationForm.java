package pprs.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Forms1")
public class CurricularQualificationForm {

    @Id
    private String id;
    private org.bson.Document content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public org.bson.Document getContent() {
        return content;
    }

    public void setContent(org.bson.Document content) {
        this.content = content;
    }
}
