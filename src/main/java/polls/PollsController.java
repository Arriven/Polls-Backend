package polls;

import java.util.List;
import java.util.ArrayList;
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

	@Autowired
	private StatsRepository statsRepository;

	@RequestMapping("/testInit")
	public void init(Authentication auth) {
		pollsRepository.deleteAll();
		questionsRepository.deleteAll();
		answersRepository.deleteAll();
		statsRepository.deleteAll();

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
		Stat pollStat = statsRepository.findById(poll.getId()).orElse(new Stat());
		poll.setCount(pollStat.getCount());
		for (Question q : poll.getQuestions()) {
			for (Answer answer : q.getAnswers()) {
				Stat answerStat = statsRepository.findById(answer.getId()).orElse(new Stat());
				answer.setCount(answerStat.getCount());
			}
		}
		return poll;
	}

	@RequestMapping("/createPoll")
	public Poll createPollHandler(Authentication auth, @RequestBody Poll poll) {
		for (Question q : poll.getQuestions()) {
			for (Answer a : q.getAnswers()) {
				answersRepository.insert(a);
			}
			questionsRepository.insert(q);
		}
		poll.setAuthor(auth.getName());
		pollsRepository.insert(poll);
		return poll;
	}

	@RequestMapping("/result")
	public void resultHandler(@RequestBody Result result) {
		List<Stat> statsToSave = new ArrayList<Stat>();
		if (!pollsRepository.findById(result.getPollId()).isPresent()) {
			return;
		}
		Stat pollStat = statsRepository.findById(result.getPollId())
				.orElse(new Stat(result.getPollId()));
		statsToSave.add(pollStat);
		for (String answerId : result.getAnswerIds()) {
			if (!answersRepository.findById(answerId).isPresent()) {
				return;
			}
			Stat answerStat = statsRepository.findById(answerId)
					.orElse(new Stat(answerId));
			statsToSave.add(answerStat);
		}

		for (Stat stat : statsToSave) {
			stat.incCount();
			statsRepository.save(stat);
		}
	}
}
