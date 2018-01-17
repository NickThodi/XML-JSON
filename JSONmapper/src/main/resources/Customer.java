package json;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Customer {

	private int customerId;
	private String name;
	private Date dateOFBirth;
	private float annualSalary;
	private List<Address> address;
	private PaymentMethod payment;

	
}
