package fr.diginamic.jdbc.recensement.service;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.jdbc.recensement.dao.RegionDao;
import fr.diginamic.jdbc.recensement.entites.Region;

/**
 * Permet d'afficher les 10 départements les plus peuplés de la base recensement
 * 
 * @author Antoine
 *
 */
public class RechercherRegionsPlusPeuplees implements MenuService {

	/**
	 * Prend en argument un objet de type Scanner.
	 * Affiche les 10 départements les plus peuplés de la base recensement.
	 */
	@Override
	public void traiter(Scanner sc) {
		List<Region> regions = RegionDao.rechercherRegionsPlusPeuples();
		System.out.println("Les 10 régions les plus peuplés sont :");
		for (Region region: regions) {
			System.out.println("Population : " + region.getPopulation() + " Région : "
					+ region.getNomRegion());
		}
	}

}
