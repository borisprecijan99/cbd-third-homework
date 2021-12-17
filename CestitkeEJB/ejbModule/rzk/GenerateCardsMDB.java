package rzk;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Card;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/cards"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "java:/jms/queue/cards")
public class GenerateCardsMDB implements MessageListener {

	@PersistenceContext
	private EntityManager em;

	@Resource(mappedName = "java:/jms/topic/generate")
	private Destination destinationTopic;

	@Inject
	private JMSContext context;

	public GenerateCardsMDB() {

	}

	public void onMessage(Message message) {
		try {
			Card card = message.getBody(Card.class);
			em.persist(card);
			context.createProducer().send(destinationTopic, card);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
