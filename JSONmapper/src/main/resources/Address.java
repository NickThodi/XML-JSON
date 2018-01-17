package json;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Address {

	private String streetName;
	private int aptNo;
	private String city;
	private String State;
	private String Country;
	private int zipCode;
}
