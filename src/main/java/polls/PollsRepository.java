package polls;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollsRepository extends MongoRepository<Poll, String> {
    public Poll findByName(String name);
}
