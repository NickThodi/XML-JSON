package CustMarshallerUnmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import jaxb.Address;
import jaxb.CardInfo;
import jaxb.CardType;
import jaxb.Customer;


public class CustomerMarshaller {
	public static void main(String[] args) throws DatatypeConfigurationException {
		try {

			File file = new File("C:\\Users\\adity\\eclipse-workspace\\Customer\\src\\main\\resources\\xml\\Customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Customer customer = createCustomer();
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Customer createCustomer() throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		//Customer
		Customer customer = new Customer();
		customer.setCustomerId(204);
		customer.setName("Nicholos");
		
		c.set(1990, 00, 18);
		XMLGregorianCalendar value = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		customer.setDateOfBirth(value);
		customer.setAnnualSalary((float) 50000.00);
		
		//Card Type
		CardType ct = new CardType();
	    ct.setCreditCard("Credit Card");
	    ct.setDebitCard("Debit Card");
       	    
		
		//address
	    Address address = new Address();
		List<Address> address1 = new ArrayList<Address>();
		address.setStreet("884 MacArthur Road");
		address.setAptNo(180);
		address.setCity("Irving");
		address.setState("TX");
		address.setCountry("United States of Hyderabad");
		address.setZipCode(75063);
		customer.getAddress().add(address);
	
		//Card Information
		CardInfo ci = new CardInfo();
		List<CardInfo> ci2 = new ArrayList<CardInfo>();
 		ci.setCardNumber(460829125);
		ci.setCardName("Nicholos");
		

		c.set(2015, 11, 18);
	    XMLGregorianCalendar dateFrom = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		ci.setDateFrom(dateFrom);
		
	    c.set(2019, 11, 18);
	    XMLGregorianCalendar dateTo = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		ci.setDateTo(dateTo);
		customer.getPaymentMethod().add(ci);
		
		return customer;
	}
}
