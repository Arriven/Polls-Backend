package polls;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Poll {
	@Id
	private String id;

	private String name;
	private String author;
	private List<Question> questions = new ArrayList<Question>();
	
	@Transient
	@JsonSerialize
	private long count = 0;

	public Poll(){
	}//for jackson deserialization only

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

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
}
