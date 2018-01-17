package json;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PaymentMethod {
	private double cardNumber;
	private String cardName;
	private Date dateFrom;
	private Date dateTo;
	private List<String> cardType;
}
