package project;

public class Main {

	public static void main(String[] args) {
		// Ajouter les employés et leurs payes
		app.AjouterEmploye("Tatiana", "Dubos", 1); 
			app.AjouterPaye(1, 1, 45, 0);
			app.AjouterPaye(1, 2, 33, 0);
			app.AjouterPaye(1, 3, 50, 0);
		app.AjouterEmploye("Katy", "Dubois", 3);
			app.AjouterPaye(2, 1, 35, 0);
			app.AjouterPaye(2, 2, 35, 0);
			app.AjouterPaye(2, 3, 45, 0);
		app.AjouterEmploye("Emmanuel", "Dufour", 4);
			app.AjouterPaye(3, 1, 30, 700);
			app.AjouterPaye(3, 2, 32, 500.50);
			app.AjouterPaye(3, 3, 34, 600);
		app.AjouterEmploye("Iona", "Contreras", 4 );
			app.AjouterPaye(4, 1, 40, 1000);
			app.AjouterPaye(4, 2, 35, 550.95);
			app.AjouterPaye(4, 3, 34, 500);
		app.AjouterEmploye("Maxime", "Concorde", 2);
			app.AjouterPaye(5, 1, 44, 0);
			app.AjouterPaye(5, 2, 38, 0);
			app.AjouterPaye(5, 3, 48, 0);
		app.AjouterEmploye("Stephan", "Madoux", 4);
			app.AjouterPaye(6, 1, 35, 500.05);
			app.AjouterPaye(6, 2, 35, 550);
			app.AjouterPaye(6, 3, 35, 700.75);
		app.AjouterEmploye("Katrina", "Contreras", 4 );
			app.AjouterPaye(7, 1, 40, 1000);
			app.AjouterPaye(7, 2, 35, 550.95);
			app.AjouterPaye(7, 3, 34, 500);
		app.AjouterEmploye("Maxime", "Velou", 2);
			app.AjouterPaye(8, 1, 44, 0);
			app.AjouterPaye(8, 2, 38, 0);
			app.AjouterPaye(8, 3, 48, 0);
		app.AjouterEmploye("Gabriel", "Madoux", 4);
			app.AjouterPaye(9, 1, 35, 100.05);
			app.AjouterPaye(9, 2, 35, 550);
			app.AjouterPaye(9, 3, 35, 700.75);
		
		
		app.AfficherMenu();
		

	}
	private static SystemePaye app = new SystemePaye();
}
