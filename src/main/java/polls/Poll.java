package polls;

import java.util.List;
import java.util.ArrayList;

public class Poll {
	private List<Question> questions = new ArrayList<Question>();

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public List<Question> getQuestions() {
		return questions;
	}
}
