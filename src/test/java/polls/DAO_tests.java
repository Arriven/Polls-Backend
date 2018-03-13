package polls;

import org.junit.Test;
import org.junit.Assert;

public class DAO_tests {

	@Test
	public void simpleAnswerTest() {
		Answer a = new Answer("a");
		Answer b = new Answer("b");
		Assert.assertNotEquals(a.getId(), b.getId());
	}

	@Test
	public void simpleQuetionTest() {
		Question q = new Question("testQuestion");
		q.addAnswer(new Answer("c"));
		Assert.assertEquals(q.getAnswers().size(), 1);
		Question q2 = new Question("testQuestion2");
		q2.addAnswer(new Answer("c"));
		Assert.assertNotEquals(q.getId(), q2.getId());
		Assert.assertNotEquals(q.getAnswers().get(0), q2.getAnswers().get(0));
	}
}
