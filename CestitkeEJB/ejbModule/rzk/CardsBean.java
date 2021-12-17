package rzk;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;

import model.Card;

@Stateless
public class CardsBean implements CardsBeanRemote {

	@Resource(mappedName = "java:/jms/queue/cards")
	private Destination destinationQueue;

	@Inject
	private JMSContext context;

	public CardsBean() {

	}

	@Override
	public boolean sendMessage(String type, String from, String to, String email) {
		boolean ok = type != null && !type.trim().isEmpty() && from != null && !from.trim().isEmpty() && to != null
				&& !to.trim().isEmpty() && email != null && !email.trim().isEmpty();
		if (ok) {
			Card card = new Card();
			card.setCardFrom(from);
			card.setCardTo(to);
			card.setEmail(email);
			card.setType(type);
			context.createProducer().send(destinationQueue, card);
			return true;
		}
		return false;
	}

}
