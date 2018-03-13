package polls;

import java.util.concurrent.atomic.AtomicLong;

public class Answer {
	private static AtomicLong counter = new AtomicLong();
	private final long id;
	private String text;

	public Answer(String text) {
		this.id = counter.incrementAndGet();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public long getId() {
		return id;
	}
}
