package polls;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollsController {

	private Poll poll = new Poll();

	public PollsController() {
		Question q = new Question("test question");
		q.AddAnswer("a");
		q.AddAnswer("b");
		poll.AddQuestion(q);
	}

	@RequestMapping("/getPoll")
	public Poll getPollHandler() {
		return poll;
	}
}
