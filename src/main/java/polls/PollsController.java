package polls;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void init() {
		pollsRepository.deleteAll();

		Poll poll = new Poll("test poll");
		Question q = new Question("test question");
		Answer a = new Answer("a");
		answersRepository.save(a);
		Answer b = new Answer("b");
		answersRepository.save(b);
		q.addAnswer(a);
		q.addAnswer(b);
		questionsRepository.save(q);
		poll.addQuestion(q);
		pollsRepository.save(poll);
	}

	@RequestMapping("/getPollsList")
	public List getPollsListHandler() {
		return pollsRepository.findAll();
	}

	@RequestMapping("/getPoll")
	public Poll getPollHandler() {
		return pollsRepository.findByName("test poll");
	}

	@RequestMapping("/getMyPollsList")
	public List getMyPollsListHandler() {
		return new ArrayList<String>();
	}

	@RequestMapping("/getPollWithStats")
	public Poll getPollWithStatsHandler() {
		return pollsRepository.findByName("test poll");
	}
}
