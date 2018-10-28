package pprs.Repositories;
import pprs.Models.MiniClassQualificationForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniClassQualificationFormRepository extends MongoRepository<MiniClassQualificationForm,String> {
}
