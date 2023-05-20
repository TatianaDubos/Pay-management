package project;

public class Departement {
	// Nom du departement
	public static String getNom(int id) {
		String nom;
		switch(id) {
		case 1 : nom = "Restaurant" ; break;
		case 2 : nom = "Maintenance"; break;
		case 3 : nom = "Commis/Paysagistes" ; break;
		case 4 : nom = "Ventes"; break;
		default: nom = "";}
		return nom;
	}
	// Taux horraire du departement
	public static double getTaux(int id) {
		double taux;
		switch(id) {
		case 1 : taux = 8.50; break;
		case 2 : taux = 12.50; break;
		case 3 : taux = 15.75; break;
		case 4 : taux = 15.00; break;
		default: taux = 0; }
		return taux;
		
}
}
