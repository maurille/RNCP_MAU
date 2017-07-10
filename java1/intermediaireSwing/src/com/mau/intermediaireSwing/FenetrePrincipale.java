package com.mau.intermediaireSwing;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mau.intermediaireSwing.metier.Produit;

public class FenetrePrincipale extends JFrame implements ListSelectionListener {
	
	private JPanel panelTri;
	private JList<String> listeCategories;
	private JButton triNomBt;
	private JButton triPrixbt;
	private JButton triPoidsbt;
	// le model/données affiché par le composant graphique
	private DefaultListModel<Produit> ProduitsVisiblesData; 
	// composant graphique affiché
	private JList<Produit> produitsVisibles;
	


	private ArrayList<Produit> produitFullData;
	

	public FenetrePrincipale() throws HeadlessException{
		super("ma super application");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout( new BorderLayout());
		
		panelTri = new JPanel();
		
		BoxLayout bl = new BoxLayout(panelTri, BoxLayout.X_AXIS);
		panelTri.setLayout(bl);
		
		triNomBt = new JButton("trier par nom");
		panelTri.add(triNomBt);
		
		triPrixbt = new JButton("trier par prix");
		panelTri.add(triPrixbt);
		
		triPoidsbt = new JButton("trier par poids");
		panelTri.add(triPoidsbt);
		
		
		// ajout du panel en g=haut de la fenetre
		add(panelTri, BorderLayout.NORTH);
		
		
		listeCategories = new JList<>(new String[] {
				"viandes", "cereales", "fromages"
, "legumes", "divers", "toutes"	});
		
		
		add(new JScrollPane(listeCategories), BorderLayout.WEST);
		
		
		// partie centrale de mla fenetre , le liste des produits
		
		ProduitsVisiblesData = new DefaultListModel<>();
		produitsVisibles = new JList<>(ProduitsVisiblesData);
		
		add(new JScrollPane(produitsVisibles));
		
		produitFullData = new ArrayList<>();
		
//		ProduitsVisiblesData.addElement(new Produit( 1, "steack de lama", 49.99, 1.2, "viandes"));
//		ProduitsVisiblesData.addElement(new Produit( 2, "tofu tout fou", 49.99, 1.2, "fromage"));
//		ProduitsVisiblesData.addElement(new Produit( 3, "quinoa des andes", 49.99, 1.2, "cereale"));
		
		produitFullData.add(new Produit( 1, "steack de lama", 49.99, 1.2, "viandes" ));
		produitFullData.add(new Produit( 2, "tofu tout fou", 49.99, 1.2, "fromage" ));
		produitFullData.add(new Produit( 3, "quinoa des andes", 49.99, 1.2, "cereales" ));
		produitFullData.add(new Produit( 4, "miel", 49.99, 1.2, "divers" ));
		produitFullData.add(new Produit( 5, "oignon", 49.99, 1.2, "legumes" ));
		produitFullData.add(new Produit( 6, "boeuf", 47.99, 0.9, "viandes" ));
		produitFullData.add(new Produit( 7, "porc", 49.99, 1.5, "viandes" ));
		produitFullData.add(new Produit( 8, " entre cote", 40.99, 2.2, "viandes" ));
		produitFullData.add(new Produit( 9, "ble sans gluten", 49.99, 1.2, "cereales" ));
		
		
//		// copie la liste integrale de sproduits dans les produits à afficher en filtrant et en triant celle ci
//		produitFullData.stream()
//						.filter(p -> p.getCategorie().equals("viande"))
//						.sorted((p1,p2) -> Double.compare(p1.getPrix(), p2.getPrix()))
//						.forEach(p -> ProduitsVisiblesData.addElement(p));
		
		currentFilter = p -> p.getCategorie().equals("viande");
		refreshList();
		
		listeCategories.addListSelectionListener(this);
}	
	
		private Predicate <Produit> currentFilter;
		
		private void refreshList() {
			
			ProduitsVisiblesData.clear();
			
			produitFullData.stream()
			.filter( currentFilter)
			.sorted((p1,p2) -> Double.compare(p1.getPrix(), p2.getPrix()))
			.forEach(p -> ProduitsVisiblesData.addElement(p));
		}
		
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			 switch (listeCategories.getSelectedValue()){
				 
			 case "viandes" : currentFilter = Produit.VIANDE_CATEGORIE_FILTER; break;
			 case "legumes" : currentFilter = Produit.LEGUMES_CATEGORIE_FILTER; break;
			 case "cereales" : currentFilter = Produit.CEREALE_CATEGORIE_FILTER; break;
			 case "fromages" : currentFilter = Produit.FROMAGE_CATEGORIE_FILTER; break;
			 case "divers" : currentFilter = Produit.DIVERS_CATEGORIE_FILTER; break;
			 default       : currentFilter = Produit.ALL_CATEGORIE_FILTER; break;
			 
			 }
			 
			 refreshList();
			
		}
		
		
		
		
		

}


