package polls;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PollsController {

	@Autowired
	private PollsRepository pollsRepository;

	@Autowired
	private QuestionsRepository questionsRepository;

	@Autowired
	private AnswersRepository answersRepository;

	@RequestMapping("/testInit")
	public void init(Authentication auth) {
		pollsRepository.deleteAll();

		Poll poll = new Poll("test poll", auth.getName());
		Question q = new Question("test question");
		Answer a = new Answer("a");
		answersRepository.insert(a);
		Answer b = new Answer("b");
		answersRepository.insert(b);
		q.addAnswer(a);
		q.addAnswer(b);
		questionsRepository.insert(q);
		poll.addQuestion(q);
		pollsRepository.insert(poll);
	}

	@RequestMapping("/getPollsList")
	public List getPollsListHandler() {
		return pollsRepository.findAll();
	}

	@RequestMapping("/getPoll")
	public Poll getPollHandler(@RequestParam("id") String id) {
		return pollsRepository.findById(id).orElse(null);
	}

	@RequestMapping("/getMyPollsList")
	public List getMyPollsListHandler(Authentication auth) {
		return pollsRepository.findByAuthor(auth.getName());
	}

	@RequestMapping("/getPollWithStats")
	public Poll getPollWithStatsHandler(Authentication auth, @RequestParam("id") String id) {
		Optional<Poll> optPoll = pollsRepository.findById(id);
		if (!optPoll.isPresent()) {
			return null;
		}
		Poll poll = optPoll.get();
		if (!poll.getAuthor().equals(auth.getName())) {
			return null;
		}
		return poll;
	}

	@RequestMapping("/createPoll")
	public Poll createPollHandler(Authentication auth, @RequestBody Poll poll) {
		Poll newPoll = new Poll(poll.getName(), auth.getName());
		for (Question q : poll.getQuestions()) {
			questionsRepository.insert(q);
			for (Answer a : q.getAnswers()) {
				answersRepository.insert(a);
			}
			newPoll.addQuestion(q);
		}
		pollsRepository.insert(newPoll);
		return newPoll;
	}
}
