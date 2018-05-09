package polls;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionsRepository extends MongoRepository<Question, String> {
}
