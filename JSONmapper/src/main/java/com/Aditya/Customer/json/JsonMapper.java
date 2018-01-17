package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonMapper {

	private static String FILE_PATH = "C:\\Users\\adity\\eclipse-workspace\\Customer\\src\\main\\resources\\customer.json";

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//serialize();
		deserialize();
	}

	private static void serialize() throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = createCustomer();
        
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
         
        objectMapper.writeValue(System.out, customer);
        objectMapper.writeValue(new PrintWriter("C:\\Users\\adity\\eclipse-workspace\\Customer\\src\\main\\resources\\customer.json"), customer);
	}

	public static void deserialize() throws IOException {
         
        byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
         
        ObjectMapper objectMapper = new ObjectMapper();
         
        Customer cust = objectMapper.readValue(jsonData, Customer.class);
         
        System.out.println("Employee Object\n"+cust);
    }
	
	

	private static Customer createCustomer() {
		
		Calendar c = Calendar.getInstance();
		c.set(1990, 03, 17);
		
        Customer cust = new Customer();
        cust.setCustomerId(123);;
        cust.setName("Donald");
        cust.setDateOFBirth(c.getTime());
        cust.setAnnualSalary(70000.0f);
 
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setStreetName("MacArthur Road");
        address.setCity("Irving");
        address.setState("TX");
        address.setCountry("United States of America");
        address.setZipCode(75063);
        addresses.add(address);
        cust.setAddress(addresses);
 
        PaymentMethod payment = new PaymentMethod();
        List<String> cardType = new ArrayList<String>();
        cardType.add("Credit Card");
        cardType.add("Debit Card");
        payment.setCardType(cardType);
        
        payment.setCardNumber(34296745);
        payment.setCardName("Jimmy Patel");
        
        Calendar c2 = Calendar.getInstance();
        c2.set(2016, 05, 30);
        payment.setDateFrom(c2.getTime());
        Calendar c3 = Calendar.getInstance();
        c3.set(2019, 05, 30);
        payment.setDateTo(new Date());
           
        cust.setPayment(payment);
        
        return cust;
    }

}
