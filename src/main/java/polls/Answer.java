package polls;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Answer {
	@Id
	private String id;

	private String text;

	@Transient
	@JsonSerialize
	private long count = 0;

	public Answer(){
	}//for jackson deserialization only

	public Answer(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
}
