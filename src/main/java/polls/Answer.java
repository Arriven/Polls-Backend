package polls;

import org.springframework.data.annotation.Id;

public class Answer {
	@Id
	private String id;

	private final String text;

	public Answer(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String getId() {
		return id;
	}
}
