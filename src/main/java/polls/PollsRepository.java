package polls;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollsRepository extends MongoRepository<Poll, String> {
    public Poll findByName(String name);
    public List<Poll> findByAuthor(String author);
}
