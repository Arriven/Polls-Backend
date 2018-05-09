package polls;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswersRepository extends MongoRepository<Answer, String> {
}
