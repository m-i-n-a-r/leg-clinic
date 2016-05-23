package it.leg.controller.helper;
import java.util.IllegalFormatException;

import javax.servlet.http.HttpServletRequest;
public class HelperTypeExamination {

	 public boolean isValid (HttpServletRequest request){
		 
		 String name = request.getParameter("name");
	     String description = request.getParameter("description");
	     String  cost= request.getParameter("cost");
	     boolean notValid= false;
	     
	     if ( name == null || name.equals("")) {
				request.setAttribute("nameError","inserisci un nome");
				notValid = true;
			}

			if ( description == null || description.equals("")) {
				request.setAttribute("descriptionError","inserisci una descrizione");
				notValid = true;
			}

			if ( cost == null || cost.equals("")) {
				request.setAttribute("costError","inserisci un costo");
				notValid = true;
			}
			
				else {
					try{
						Float.parseFloat(cost);
					}
					catch (NumberFormatException e) {
						request.setAttribute("costError","Inserire valore numerico");
						notValid = true;
					}
					
						try{
							String.valueOf(request.getParameter("name"));
						}
						catch(IllegalFormatException e){
							request.setAttribute("nameError","formato nome errato");
							notValid = true;
						}
							
						}
					
					
					

	
	                   return !notValid;
		 
	 }
}
