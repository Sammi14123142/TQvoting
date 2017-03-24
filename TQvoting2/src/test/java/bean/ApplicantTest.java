package bean;

import org.junit.Assert;
import org.junit.Test;

public class ApplicantTest {

	@Test
	public void testIsValidScore() {
		Applicant applicant = new Applicant();
		Assert.assertFalse(applicant.isValidScore());
		applicant.setTechnique(99);
		Assert.assertFalse(applicant.isValidScore());
		applicant.setPersonality(99);
		Assert.assertFalse(applicant.isValidScore());
		applicant.setStage(20);
		Assert.assertTrue(applicant.isValidScore());
	}

}
