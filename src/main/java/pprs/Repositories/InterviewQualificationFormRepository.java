package pprs.Repositories;
import pprs.Models.InterviewQualificationForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewQualificationFormRepository extends MongoRepository<InterviewQualificationForm,String> {
}
