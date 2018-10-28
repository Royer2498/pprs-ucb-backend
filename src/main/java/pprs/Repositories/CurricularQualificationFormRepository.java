package pprs.Repositories;
import pprs.Models.CurricularQualificationForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurricularQualificationFormRepository extends MongoRepository<CurricularQualificationForm,String> {
}
