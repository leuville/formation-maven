package org.formation.mabiblio.console;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.formation.mabiblio.business.AuteurMetier;
import org.formation.mabiblio.business.LivreMetier;
import org.formation.mabiblio.business.dto.Auteur;
import org.formation.mabiblio.business.dto.Livre;
import org.formation.mabiblio.business.impl.AuteurMetierImpl;
import org.formation.mabiblio.business.impl.LivreMetierImpl;


/**
 * 
 * @author Cyril Dumont
 *
 */
public class MaBiblioConsole {

	private static Scanner clavier = new Scanner(System.in);
	
	private static LivreMetier livreMetier = new LivreMetierImpl();
	private static AuteurMetier auteurMetier = new AuteurMetierImpl();
	
	public static void main(String[] args) {

		boolean demarrer = true;
		while (demarrer) {
			System.out.println("1) Lister tous les livres");
			System.out.println("2) Rechercher un livre");
			System.out.println("3) Ajouter un livre");
			System.out.println("4) Supprimer un livre");
			System.out.println("0) Quitter");
			int reponse = clavier.nextInt();
			switch (reponse) {
			case 1:
				lister();
				break;
			case 2:
				rechercher();
				break;
			case 3:
				ajouter();
				break;	
			case 4:
				supprimer();
				break;
			case 0:
				demarrer = false;
				break;
			default:
				System.out.println("******* ERREUR *******");
				break;
			}
		}

	}

	
	private static void lister() {
		System.out.println("******* LISTER *******");
		List<Livre> livres = livreMetier.getLivres();
		for (Livre livre : livres) {
			System.out.println(livre);
		}
	}


	private static void supprimer() {
		System.out.println("******* SUPPRIMER *******");
		boolean demarrer = true;
		while(demarrer){
			int id = demanderIdentifiant();
			if(id == 0){
				demarrer = false;
			}
			else{
				
			}
		}
	}


	private static void ajouter() {
		System.out.println("******* AJOUTER *******");
		boolean demarrer = true;
		while(demarrer){
			System.out.println("Titre : ");
			String titre = clavier.next();
			System.out.println("Cote : ");
			String cote = clavier.next();
			System.out.println("Auteur : ");
			List<Auteur> auteurs = auteurMetier.getAuteurs();
			for (Auteur auteur : auteurs) {
				System.out.println(auteur.getId() + " : " + auteur.getPrenom() + " " + auteur.getNom());
			}
			int id = clavier.nextInt();
			Auteur auteur = auteurMetier.getAuteurByID(id);
			Set<Auteur> auteursSet = Collections.singleton(auteur);
			Livre livre = new Livre();
			livre.setTitre(titre);
			livre.setCote(cote);
			livre.setAuteurs(auteursSet);
			livreMetier.ajouter(livre);
			System.out.println("Livre ajouté : " + livre);
			System.out.println("Ajouter un autre livre (O/N)?");
			String reponse = clavier.next();
			if("N".equals(reponse)) demarrer = false;
		}
	}


	private static void rechercher() {
		System.out.println("******* RECHERCHER *******");
		boolean demarrer = true;
		while(demarrer){
			int id = demanderIdentifiant();
			if(id == 0){
				demarrer = false;
			}
			else{
				Livre livre = livreMetier.getLivreByID(id);
				System.out.println(livre);
			}
		}
	}


	private static int demanderIdentifiant() {
		System.out.println("Identifiant du livre (0 pour revenir au menu précedent) : ");
		int id = clavier.nextInt();
		return id;
	}
}
