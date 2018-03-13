package polls;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Poll {
	private static AtomicLong counter = new AtomicLong();
	private List<Question> questions = new ArrayList<Question>();
	private final long id;
	private final String name;

	public Poll(String name) {
		this.id = counter.incrementAndGet();
		this.name = name;
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public long getId() {
		return id;
	}
}
