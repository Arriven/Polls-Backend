package polls;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Question {
	@Id
	private String id;

	private String text;
	private List<Answer> answers = new ArrayList<Answer>();
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String selectedAnswer;

	public Question() {
	}//for jackson deserialization only

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

	public String getSelectedAnswer() {
		return selectedAnswer;
	}
}
