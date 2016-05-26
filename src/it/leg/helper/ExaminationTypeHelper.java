package it.leg.helper;
import java.util.IllegalFormatException;

import javax.servlet.http.HttpServletRequest;
public class ExaminationTypeHelper {

	public boolean validate (HttpServletRequest request){

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String  cost = request.getParameter("cost");
		boolean correct = true;

		if (name.equals("")) {
			request.setAttribute("nameError","inserisci un nome");
			correct = false;
		}

		if (description.equals("")) {
			request.setAttribute("descriptionError","inserisci una descrizione");
			correct = false;
		}

		if (cost.equals("")) {
			request.setAttribute("costError","inserisci un costo");
			correct = false;
		}

		else {
			try{
				Float.parseFloat(cost);
			}
			catch (NumberFormatException e) {
				request.setAttribute("costError","Inserire valore numerico");
				correct = false;
			}

			try{
				String.valueOf(request.getParameter("name"));
			}
			catch(IllegalFormatException e){
				request.setAttribute("nameError","formato nome errato");
				correct = false;
			}

		}

		return correct;

	}
}
