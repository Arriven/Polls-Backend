package polls;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;

public class Poll {
	@Id
	private String id;

	private final String name;
	private final String author;
	private List<Question> questions = new ArrayList<Question>();

	public Poll(String name, String author) {
		this.name = name;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public List<Question> getQuestions() {
		return questions;
	}
}
