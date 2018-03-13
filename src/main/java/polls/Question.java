package polls;

import java.util.Map;
import java.util.HashMap;

public class Question {
	private String text;
	private Map<Integer, String> answers = new HashMap<Integer, String>();
	private int counter = 0;

	public Question(String text) {
		this.text = text;
	}

	public void addAnswer(String answer) {
		answers.put(counter++, answer);
	}

	public String getText() {
		return text;
	}

	public Map<Integer, String> getAnswers() {
		return answers;
	}
}
