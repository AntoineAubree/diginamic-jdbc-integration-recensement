package fr.diginamic.jdbc.recensement.service;

import java.util.Scanner;

import fr.diginamic.jdbc.recensement.dao.VilleDao;
import fr.diginamic.jdbc.recensement.entites.Ville;

/**
 * Permet d'afficher la population d'une ville
 * 
 * @author Antoine
 *
 */
public class RecherchePopulationVilleService implements MenuService {

	/**
	 * Prend en argument un objet de type Scanner.
	 * Affiche la population d'une des villes de la table ville de la base recensement en fonction du nom de la ville.
	 */
	@Override
	public void traiter(Scanner sc) {
		System.out.println("Saisir le nom de la ville dont vous souhaitez connaître la population :");
		String nomVilleRecherchee = sc.nextLine().toLowerCase();
		Ville ville = VilleDao.rechercherVilleParNom(nomVilleRecherchee);
		if (ville.getPopTotale() != 0) {
			System.out.println(nomVilleRecherchee + ", populaion : " + ville.getPopTotale() + " habitants");
		} else {
			System.out.println("Cette ville n'est pas dans la liste.");
		}
	}

}
