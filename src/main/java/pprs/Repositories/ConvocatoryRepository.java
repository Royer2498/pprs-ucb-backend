package pprs.Repositories;
import pprs.Models.Convocatory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvocatoryRepository extends MongoRepository<Convocatory,String> {
}
