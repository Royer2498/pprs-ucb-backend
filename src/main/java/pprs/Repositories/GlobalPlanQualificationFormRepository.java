package pprs.Repositories;
import pprs.Models.GlobalPlanQualificationForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalPlanQualificationFormRepository extends MongoRepository<GlobalPlanQualificationForm,String> {
}
