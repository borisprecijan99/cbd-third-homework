package rzk;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import model.Card;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topic/generate"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") }, mappedName = "java:/jms/topic/generate")
public class BirthdayCardsMDB implements MessageListener {

	public BirthdayCardsMDB() {

	}

	public void onMessage(Message message) {
		try {
			Card card = message.getBody(Card.class);
			if (card.getType().equals("rodjendan")) {
				System.out.println("Rodjendanska cestitka za " + card.getCardTo() + " (" + card.getEmail() + "), od "
						+ card.getCardFrom());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
