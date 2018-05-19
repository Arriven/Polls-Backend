package polls;

import org.springframework.data.annotation.Id;

public class Answer {
	@Id
	private String id;

	private String text;

	public Answer(){
	}//for jackson deserialization only

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
