package polls;

import org.springframework.data.annotation.Id;

public class Stat {
	@Id
	private String id;

	private long count;

	public Stat() {
		count = 0;
	}

	public Stat(String id) {
		this.id = id;
		count = 0;
	}

	public long getCount() {
		return count;
	}

	public void incCount() {
		count++;
	}
}
