package project;

public class Paye {
	
    //Constructeur
	public Paye(int sem, double taux, int heures, double ventes) {
		numeroSem = sem;
		tauxHorraire = taux;
		
		if(heures > 44 && taux != 15.00) { nombreHeures = 44; heuresSup = heures-44;}
		else {nombreHeures = heures; heuresSup = 0; }
		
		totalVentes = ventes;
		
		// Calcul du salaire brut
		double salaireBase = tauxHorraire * nombreHeures;
		if(taux != 15.00) {
			//Heures supplémentaire
			if(heuresSup != 0) {
				double tauxDemi = tauxHorraire * 1.5;
				double montant = tauxDemi * heuresSup;
				salaireBrut = montant + salaireBase;
			}else {salaireBrut = salaireBase;}
		}else {
			//Commission sur les ventes
			if(ventes != 0) {
				double commission = totalVentes * (1.5/100);
				salaireBrut = commission + salaireBase;
			}else {salaireBrut = salaireBase;}	
		}
		
		double deduction = (4.95/100) * salaireBrut;
		RRC = deduction * 2;
		AE = (1.98/100) * salaireBrut;
	}
	
	//Methodes d'accès
	public int getSem() {return numeroSem;}
	public double getRRC() {return RRC;}
	public double getAE() {return AE;}
	public double getSalaire() {return salaireBrut;}
	public double getVentes() {return totalVentes;}
	public int getHeuresSup() {return heuresSup;}
	
	
	//Champs
	private int nombreHeures, heuresSup, numeroSem;
	private double totalVentes, tauxHorraire, RRC, AE, salaireBrut;
	
}
