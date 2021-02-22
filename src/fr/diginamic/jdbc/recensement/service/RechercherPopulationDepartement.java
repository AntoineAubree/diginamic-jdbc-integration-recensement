package fr.diginamic.jdbc.recensement.service;

import java.util.Scanner;

import fr.diginamic.jdbc.recensement.dao.DepartementDao;
import fr.diginamic.jdbc.recensement.entites.Departement;

/**
 * Permet d'afficher la population d'un département
 * 
 * @author Antoine
 *
 */
public class RechercherPopulationDepartement implements MenuService {

	/**
	 * Prend en argument un objet de type Scanner. Affiche la population d'un des
	 * département de la base recensement en fonction du code département.
	 */
	@Override
	public void traiter(Scanner sc) {
		System.out.println("Saisir le code du département dont vous souhaitez connaître la population :");
		String codeDepartementRecherche = sc.nextLine().toLowerCase();
		Departement departement = DepartementDao.rechercherDepartementParCode(codeDepartementRecherche);
		if (departement.getPopulation() != 0) {
			System.out.println("Département : " + codeDepartementRecherche + ", populaion : "
					+ departement.getPopulation() + " habitants");
		} else {
			System.out.println("Ce département n'est pas dans la liste.");
		}
	}

}
