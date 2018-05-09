package polls;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;

public class Poll {
	@Id
	private String id;

	private final String name;
	private List<Question> questions = new ArrayList<Question>();

	public Poll(String name) {
		this.name = name;
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Question> getQuestions() {
		return questions;
	}
}
