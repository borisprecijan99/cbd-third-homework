package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Cards database table.
 * 
 */
@Entity
@Table(name="Cards")
@NamedQuery(name="Card.findAll", query="SELECT c FROM Card c")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String cardFrom;

	private String cardTo;

	private String email;

	private String type;

	public Card() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardFrom() {
		return this.cardFrom;
	}

	public void setCardFrom(String cardFrom) {
		this.cardFrom = cardFrom;
	}

	public String getCardTo() {
		return this.cardTo;
	}

	public void setCardTo(String cardTo) {
		this.cardTo = cardTo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}