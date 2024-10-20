package qa.pages;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage { 
     WebDriver driver; 

   
    public Basepage(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this); 
    }
    
	public static  String randomeString()
    {
    	String generatedString=RandomStringUtils.randomAlphabetic(5);
    	return generatedString;
    }

    public static String randomeNumber()
    {
    	String generatedString=RandomStringUtils.randomNumeric(9);
    	return generatedString;
    }

    public static String randomAlphaNumeric()
    {
    	String str=RandomStringUtils.randomAlphabetic(4);
    	String num=RandomStringUtils.randomNumeric(4);
    	
    	return (str+num);
    }
    public static String randomemail() {
    	String randomEmail = "testuser" + randomNumber(4) + "@example.com";
		return randomEmail;
        
    }
	private static String randomNumber(int i) {
		// TODO Auto-generated method stub
		String generatedString=RandomStringUtils.randomNumeric(i);
    	return generatedString;
		
	}
	 public static String randometaxrate()
	    {
	    	String generatedString=RandomStringUtils.randomNumeric(1);
	    	return generatedString;
	    }
	 public static final String[] PREFIXES = {"Super", "Mega", "Ultra", "Fantastic", "Awesome"};
	    public static final String[] BASE_NAMES = {"Product", "Item", "Goods", "Thing", "Stuff"};

	    public static void main(String[] args) {
	        String randomProductName = generateRandomProductName();
	        System.out.println("Random Product Name: " + randomProductName);
	    }

	    public static String generateRandomProductName() {
	        Random random = new Random();
	        String prefix = PREFIXES[random.nextInt(PREFIXES.length)];
	        String baseName = BASE_NAMES[random.nextInt(BASE_NAMES.length)];
	        int randomNumber = random.nextInt(1000); // Generate a random number between 0 and 999
	        return prefix+baseName+randomNumber;
	    }
	    public static String randomeamount()
	    {
	    	String generatedString=RandomStringUtils.randomNumeric(3);
	    	return generatedString;
	    }
	    public static String randomeaccountnumber()
	    {
	    	String generatedString=RandomStringUtils.randomNumeric(9);
	    	return generatedString;
	    }
public static String randommobilenumber() {
	String mobilenumber="9"+ randomNumber(9);
	return mobilenumber;
}
        
}
