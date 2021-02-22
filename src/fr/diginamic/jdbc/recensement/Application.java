/**
 * 
 */
package fr.diginamic.jdbc.recensement;

import java.io.IOException;
import java.util.Scanner;

import fr.diginamic.jdbc.recensement.service.RecherchePopulationVilleService;
import fr.diginamic.jdbc.recensement.service.RechercherPopulationDepartement;
import fr.diginamic.jdbc.recensement.service.RechercherPopulationRegion;

/**
 * @author Antoine
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner scInt = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		int choixUtilisateur = 0;
		while (choixUtilisateur != 9) {
			choixUtilisateur = choisirAffichage(scInt, choixUtilisateur);
			switch (choixUtilisateur) {
			case 1:
				RecherchePopulationVilleService recherchePopulationVilleService = new RecherchePopulationVilleService();
				recherchePopulationVilleService.traiter(scString);
				break;
			case 2:
				RechercherPopulationDepartement rechercherPopulationDepartement = new RechercherPopulationDepartement();
				rechercherPopulationDepartement.traiter(scString);
				break;
			case 3:
				RechercherPopulationRegion rechercherPopulationRegion = new RechercherPopulationRegion();
				rechercherPopulationRegion.traiter(scString);
				break;
			}
		}
	}

	private static int choisirAffichage(Scanner sc, int choixUtilisateur) {
		choixUtilisateur = 0;
		while (choixUtilisateur < 1 || choixUtilisateur > 9) {
			afficherMenu();
			choixUtilisateur = sc.nextInt();
			if (choixUtilisateur < 1 || choixUtilisateur > 9) {
				System.out.println("Ce choix n'est pas valide");
			}
		}
		return choixUtilisateur;
	}

	private static void afficherMenu() {
		System.out.println("1 - Population d'une ville donnée");
		System.out.println("2 - Population d'un département donné");
		System.out.println("3 - Population d'une région donnnée");
		// TODO
//		System.out.println("4 - Afficher les 10 régions les plus peuplées");
//		System.out.println("5 - Afficher les 10 départements les plus peuplés");
//		System.out.println("6 - Afficher les 10 villes les plus peuplées d'un département");
//		System.out.println("7 - Afficher les 10 villes les plus peuplées d'une réégion");
//		System.out.println("8 - Afficher les 10 villes les plus peuplées de France");
		System.out.println("9 - Sortir");
	}

}
