package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class ReusableMethods {

	public void waitUntil(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			
		}
	}

	 protected String generateRandomEmailID() {
			String email;
			email = RandomStringUtils.randomAlphanumeric(10).toUpperCase()+"@email.com";
			return email.toLowerCase();
		}
}
