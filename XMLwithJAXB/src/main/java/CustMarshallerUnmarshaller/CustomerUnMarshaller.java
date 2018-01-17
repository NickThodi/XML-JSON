package CustMarshallerUnmarshaller;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jaxb.Customer;


public class CustomerUnMarshaller {
	public static void main(String[] args) throws DatatypeConfigurationException {
		try {

			File file = new File("C:\\Users\\adity\\eclipse-workspace\\Customer\\src\\main\\resources\\xml\\Customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(ReflectionToStringBuilder.toString(customer));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
