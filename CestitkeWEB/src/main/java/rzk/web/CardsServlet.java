package rzk.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rzk.CardsBeanRemote;

@WebServlet("/CardsServlet")
public class CardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CardsBeanRemote cardsBean;

	public CardsServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String email = request.getParameter("email");
		boolean cardSent = cardsBean.sendMessage(type, from, to, email);
		if (cardSent) {
			request.setAttribute("message", "Cestitka je uspesno poslata.");
		} else {
			request.setAttribute("message", "Greska prilikom slanja cestitke.");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
