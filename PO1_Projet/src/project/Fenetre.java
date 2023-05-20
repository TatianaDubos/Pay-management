package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Fenetre extends JFrame implements ActionListener{
//Constructeur
public Fenetre(SystemePaye app) {
	setTitle("Système de paie - Fleur de Lys");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension dim = tk.getScreenSize();
	setSize(dim.width/2, dim.height - 50);
	
	contenu = getContentPane();
	contenu.setBackground(Color.white);
	
	//Titre
	titre = new JLabel("Bienvenue", SwingConstants.CENTER);
	Border border = BorderFactory.createLineBorder(Color.blue);
    titre.setBorder(border);
    titre.setPreferredSize(new Dimension(400, 55));
    titre.setFont( new Font(Font.SERIF, Font.BOLD, 20));
    titre.setForeground(Color.blue);
	contenu.add(titre, "North");
	
	// Barre de menu
	barreMenu = new JMenuBar();
	barreMenu.setBackground(Color.orange);
	setJMenuBar(barreMenu);
	
	ajouter = new JMenu("Ajouts");
	ajouter.setPreferredSize(new Dimension(dim.width/8, 30));
	barreMenu.add(ajouter);
	ajoutEmp = new JMenuItem("Ajouter un employé");
	ajoutPay = new JMenuItem("Ajouter une paye");
	ajoutEmp.setBackground(Color.orange);
	ajoutPay.setBackground(Color.orange);
	ajoutEmp.addActionListener(this);
	ajoutPay.addActionListener(this);
	ajouter.add(ajoutEmp);
	ajouter.add(ajoutPay);
	
	afficher = new JMenu("Voir les contributions");
	afficher.setPreferredSize(new Dimension(dim.width/8, 30));
	barreMenu.add(afficher);
	affRRC = new JMenuItem("Régime de Retraite du Canada");
	affAE = new JMenuItem("Assurance emploi");
	affRRC.setBackground(Color.orange);
	affAE.setBackground(Color.orange);
	affRRC.addActionListener(this);
	affAE.addActionListener(this);
	afficher.add(affRRC);
	afficher.add(affAE);
	
	liste = new JMenu("Liste des employés");
	liste.setPreferredSize(new Dimension(dim.width/8, 30));
	barreMenu.add(liste);
	listFixe = new JMenuItem("Employés à taux fixe");
	listCom = new JMenuItem("Employés à commission");
	listFixe.setBackground(Color.orange);
	listCom.setBackground(Color.orange);
	listFixe.addActionListener(this);
	listCom.addActionListener(this);
	liste.add(listFixe);
	liste.add(listCom);
	
	// Quitter
	quit = new JMenuItem("Quitter");
	quit.setPreferredSize(new Dimension(dim.width/8, 30));
	quit.setBackground(Color.yellow);
	quit.addActionListener(this);
	barreMenu.add(quit);
	
	pan = new JPanel();
	pan.setLayout(new GridLayout(0,1));
	pan.setBorder(BorderFactory.createEmptyBorder(0, 100, 50, 100));
	pan.setBackground(Color.white);
	scroll = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ) ;
	contenu.add(scroll);
	
	this.app = app;
}

public void AfficherFiche(String profil) {
	JTextArea text = new JTextArea(profil);
	text.setEditable(false);
	text.setBackground(Color.pink);
	Border border = BorderFactory.createRaisedSoftBevelBorder();
	text.setBorder(border);
	text.setFont( new Font(Font.MONOSPACED, Font.BOLD, 14));
	pan.add(text);
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == quit) System.exit(0);
	//Page Ajouter un employé
	if(e.getSource() == ajoutEmp) { 
		pan.removeAll();
		titre.setText("Ajouter un employé");
		//Formulaire
		JLabel p = new JLabel("Prenom de l'employé : "); 
		JTextField p1 = new JTextField(20); 
		pan.add(p); pan.add(p1);
		JLabel n = new JLabel("Nom de l'employé : ");	
		JTextField n1 = new JTextField(20); 
		pan.add(n); pan.add(n1);
		String [] dep = {"Restaurant", "Maintenance", "Commis/Paysagistes", "Ventes"};
		JLabel d = new JLabel("Departement : ");  
		JList<String> liste = new JList<String>(dep);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		JScrollPane scrollPane = new JScrollPane(liste);
		Border border = BorderFactory.createLineBorder(Color.black);
		liste.setBorder(border);
		liste.setVisibleRowCount(2);
		pan.add(d); pan.add(scrollPane);  
		JButton ok = new JButton("Créer");
		ok.setBackground(Color.blue);
		ok.setForeground(Color.white);
		pan.add(ok); 
		ok.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				String prenom = p1.getText();
				String nom = n1.getText();
				int id = liste.getSelectedIndex();
				
				if(prenom.equals("") ||  nom.equals("") || id < 0) {
					JOptionPane.showMessageDialog(contenu, "Veuillez renseigner tous les champs");
				}
				else { 
					id++;
					boolean bol = app.AjouterEmploye(prenom, nom, id);
					if(bol) JOptionPane.showMessageDialog(contenu, "L'employé " + prenom + " " + nom + " a été ajouté avec succès");
					p1.setText("");
					n1.setText("");
					liste.setSelectedIndex(0);
				}
			}
			
		}); 
		validate();
		}
	//Page Ajouter une paye
	if(e.getSource() == ajoutPay) { // paye(int sem, int heures, double ventes)
		pan.removeAll();
		titre.setText("Ajouter une paye");
		// Formulaire
		JLabel i = new JLabel("ID de l'employé : "); 
		JTextField i1 = new JTextField(20); 
		pan.add(i); pan.add(i1);
		JLabel s  = new JLabel("Numéro de la semaine : "); 
		JTextField s1 = new JTextField(20); 
		pan.add(s); pan.add(s1);
		JLabel h = new JLabel("Nombre d'heures : "); 
		JTextField h1 = new JTextField(20); 
		pan.add(h); pan.add(h1);
		JLabel v = new JLabel("Ventes : *Seulement pour les employés à commission*"); 
		JTextField v1 = new JTextField(20); 
		pan.add(v); pan.add(v1);
		JButton ok = new JButton("Ajouter");
		ok.setBackground(Color.blue);
		ok.setForeground(Color.white);
		pan.add(ok);
		ok.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				String id = i1.getText();
				String sem = s1.getText();
				String hrs = h1.getText();
				String ventes = v1.getText();
				
				if(id.equals("") || sem.equals("") || hrs.equals("")) { 
					JOptionPane.showMessageDialog(contenu, "Veuillez renseigner tous les champs");
					} else { int id2, sem2, hrs2; double ventes2;
						try {
							id2 = Integer.parseInt(id);
							sem2 = Integer.parseInt(sem);
							hrs2 = Integer.parseInt(hrs);
							if(ventes.equals("")) ventes2 = 0.0;
							else ventes2 = Double.parseDouble(ventes);
							
						boolean bol = app.AjouterPaye(id2, sem2, hrs2, ventes2);
						if(bol) { 
							JOptionPane.showMessageDialog(contenu, "La paye a été ajouté avec succès pour l'employé d'identifiant " + id2); 
							i1.setText("");
							s1.setText("");
							h1.setText("");
							v1.setText("");
						}
						else JOptionPane.showMessageDialog(contenu, "La paye n'a pas pu été ajouté. Vérifiez le ID de l'employé");
								
						}catch(NumberFormatException ex) { 
							JOptionPane.showMessageDialog(contenu, "Veuillez saisir des valeurs numérique uniquement");
						}
				}
				
			}
		}); 
		validate();
	}
	//Page afficher RRC
	if(e.getSource() == affRRC) {
		pan.removeAll();
		titre.setText("Total des contributions au Régime de Retraitre du Canada");
	    app.CalculerRRC();
	    validate();
	}
	//Page afficher AE
	if(e.getSource() == affAE) {
		pan.removeAll();
		titre.setText("Total des contributions à l'assurance emploi");
		app.CalculerAE();
		validate();
	}
	//Page liste fixe
	if(e.getSource() == listFixe) {
		pan.removeAll();
		titre.setText("Liste des employés à taux fixe");
		app.AfficherEmp_Fixe();
		validate();
	}
	//Page liste commission
	if(e.getSource() == listCom) {
		pan.removeAll();
		titre.setText("Liste des employés à commission");
		app.AfficherEmp_Com();
		validate();
	}
}
//Champs
private JLabel titre;
private JPanel pan;
private JScrollPane scroll;
private Container contenu;
private JMenuBar barreMenu;
private JMenu ajouter, afficher, liste; 
private JMenuItem ajoutEmp, ajoutPay, affRRC, affAE, listFixe, listCom, quit;
private SystemePaye app;
private static final long serialVersionUID = 1L;
}
