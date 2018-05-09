package polls;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;

public class Question {
	@Id
	private String id;

	private final String text;
	private List<Answer> answers = new ArrayList<Answer>();

	public Question(String text) {
		this.text = text;
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}

	public String getText() {
		return text;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public String getId() {
		return id;
	}
}
