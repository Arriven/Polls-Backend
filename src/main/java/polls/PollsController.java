package polls;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollsController {

	private Poll poll = new Poll("test poll");

	public PollsController() {
		Question q = new Question("test question");
		q.addAnswer(new Answer("a"));
		q.addAnswer(new Answer("b"));
		poll.addQuestion(q);
	}

	@RequestMapping("/getPoll")
	public Poll getPollHandler() {
		return poll;
	}
}
