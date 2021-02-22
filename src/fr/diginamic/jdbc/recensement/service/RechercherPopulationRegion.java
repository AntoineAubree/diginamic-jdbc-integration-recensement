package fr.diginamic.jdbc.recensement.service;

import java.util.Scanner;

import fr.diginamic.jdbc.recensement.dao.RegionDao;
import fr.diginamic.jdbc.recensement.entites.Region;

/**
 * Permet d'afficher la population d'une region
 * 
 * @author Antoine
 *
 */
public class RechercherPopulationRegion implements MenuService {

	/**
	 * Prend en argument un objet de type Scanner. 
	 * Affiche la population d'une des régions de la base recensement en fonction du no de la région.
	 */
	@Override
	public void traiter(Scanner sc) {
		System.out.println("Saisir le la région dont vous souhaitez connaître la population :");
		String nomRegionRecherchee = sc.nextLine().toLowerCase();
		Region region = RegionDao.rechercherRegionParNom(nomRegionRecherchee);
		if (region.getPopulation() != 0) {
			System.out.println("Région : " + nomRegionRecherchee + ", populaion : "
					+ region.getPopulation() + " habitants");
		} else {
			System.out.println("Cette région n'est pas dans la liste.");
		}
	}

}
