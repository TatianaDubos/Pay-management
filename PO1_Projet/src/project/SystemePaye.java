package project;
import java.text.DecimalFormat;
import java.util.*;



public class SystemePaye {
	public SystemePaye(){
		listeEmployes = new ArrayList<Employe>() ;
		fen = new Fenetre(this);
	}
	
	public void AfficherMenu() { fen.setVisible(true);}
	
	public boolean AjouterEmploye(String prenom, String nom, int id) { 
		Employe emp = new Employe(prenom, nom, id); 
		listeEmployes.add(emp);
		return true;
		}
	
	public boolean AjouterPaye(int id, int sem, int hrs, double ventes) {
		boolean trouve = false;
		Iterator<Employe> iter = listeEmployes.iterator(); 
		while(iter.hasNext()){ 
			Employe emp = iter.next();
			if(emp.getId() == id){
				int idDep = emp.getIdDep();
				if(idDep != 4) ventes = 0.00;
				emp.setPaye(sem, hrs, ventes);
				trouve = true;
				break;
			}
		}
		if(trouve) return true;
		else return false;
	}
	
	public void AfficherEmp_Fixe() {
		Iterator<Employe> iter = listeEmployes.iterator(); 
		while(iter.hasNext()){ 
			Employe emp = iter.next(); 
			if(emp.getIdDep() < 4) {
				ArrayList<Paye> paye = emp.getPaye();
				Iterator<Paye> it = paye.iterator();
				int sup = 0;
				while(it.hasNext()){
					Paye p = it.next();
					sup += p.getHeuresSup(); }
				String profil = "ID : " + emp.getId() + "\n"  + emp.toString() + "\nHeures supplémentaires : " + sup + ":00" ;
				fen.AfficherFiche(profil);
			}
	}
}
	
	public void AfficherEmp_Com() {
		Iterator<Employe> iter = listeEmployes.iterator(); 
		while(iter.hasNext()){ 
			Employe emp = iter.next(); 
			if(emp.getIdDep() == 4) {
				ArrayList<Paye> paye = emp.getPaye();
				Iterator<Paye> it = paye.iterator();
				double ventes = 0;
				while(it.hasNext()){
					Paye p = it.next();
					ventes += p.getVentes(); }
				String profil = "ID : " + emp.getId() + "\n"  + emp.toString() + "\nVentes brutes : " + df.format(ventes) + "$" ;
				fen.AfficherFiche(profil);
			}	
	}
	} 
	public void CalculerRRC() {
		Iterator<Employe> iter = listeEmployes.iterator(); 
		while(iter.hasNext()){ 
			Employe emp = iter.next(); 
				ArrayList<Paye> paye = emp.getPaye();
				Iterator<Paye> it = paye.iterator();
				double RRC = 0;
				while(it.hasNext()){
					Paye p = it.next();
					RRC += p.getRRC(); }
				String profil = "ID : " + emp.getId() + "\n"  + emp.toString() + "\nTotal des contributions : " + df.format(RRC) + "$" ;
				fen.AfficherFiche(profil);
	}
}	
	public void CalculerAE() {
		Iterator<Employe> iter = listeEmployes.iterator(); 
		while(iter.hasNext()){ 
			Employe emp = iter.next(); 
				ArrayList<Paye> paye = emp.getPaye();
				Iterator<Paye> it = paye.iterator();
				double AE = 0;
				while(it.hasNext()){
					Paye p = it.next();
					AE += p.getAE(); }
				String profil = "ID : " + emp.getId() + "\n"  + emp.toString() + "\nTotal des contributions : " + df.format(AE) + "$" ;
				fen.AfficherFiche(profil);
	}
}
	private Fenetre fen;
	private ArrayList<Employe> listeEmployes;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
}
