package project;
import java.util.*;

public class Employe {
	// Constructeur
	public Employe(String prenom, String nom, int idDepartement) { 
		this.idDepartement = idDepartement;
		this.prenom = prenom;
		this.nom = nom;
		compteur++;
		this.idEmploye = compteur;
		this.listePayes = new ArrayList<Paye>();
		}
	
	// Méthodes d'accès
	
	public void setPaye(int sem, int heures, double ventes) {
		Paye p = new Paye(sem, Departement.getTaux(idDepartement), heures, ventes);
		listePayes.add(p);
	}
	
	public ArrayList<Paye> getPaye() {return listePayes;}
	public int getId() {return idEmploye;}
	public int getIdDep() {return idDepartement;}
	
	@Override
	public String toString() {
		String texte = "Nom: " + prenom + " " + nom + "\n" + "Departement: " + Departement.getNom(idDepartement);
		return texte;
	}

	// Champs
	private int idEmploye, idDepartement;
	private String prenom, nom;
	private ArrayList<Paye> listePayes;
	private static int compteur = 0 ;

}
