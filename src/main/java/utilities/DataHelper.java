package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	
	public static DataHelper getData() {
		return new DataHelper();
	}
	
	
	public String getCustomerName() {
		return faker.name().fullName();
	}
	
	public String getAddress() {
		return faker.address().streetAddress();
	}
	
	public String getState() {
		return faker.address().state();
	}
	public String getPhoneNumber() {
		return faker.phoneNumber().subscriberNumber(10);
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	public String getCity() {
		return faker.address().city();
	}
	public String getCityName() {
		return faker.address().city();
	}
	public String getPassword() {
		return faker.internet().password();
	}
}
