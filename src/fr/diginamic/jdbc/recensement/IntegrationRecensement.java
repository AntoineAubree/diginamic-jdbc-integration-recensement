/**
 * 
 */
package fr.diginamic.jdbc.recensement;

import java.io.IOException;
import java.util.List;

import fr.diginamic.jdbc.recensement.dao.DepartementDao;
import fr.diginamic.jdbc.recensement.dao.RegionDao;
import fr.diginamic.jdbc.recensement.dao.VilleDao;
import fr.diginamic.jdbc.recensement.entites.Departement;
import fr.diginamic.jdbc.recensement.entites.Recensement;
import fr.diginamic.jdbc.recensement.entites.Region;
import fr.diginamic.jdbc.recensement.utils.RecensementUtils;

/**
 * @author Antoine
 *
 */
public class IntegrationRecensement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String chemin = "D:\\diginamic\\formation\\langage-Java\\workspace\\integration-donnees-recensement\\resources/recensement.csv";
		List<Departement> departements = null;
		List<Region> regions = null;
		Recensement recensement = null;
		try {
			departements = RecensementUtils.recupererDepartements(chemin);
			regions = RecensementUtils.recupererRegions(chemin);
			recensement = RecensementUtils.recupererRecensement(chemin);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		DepartementDao.insertDepartements(departements);
		RegionDao.insertRegions(regions);
		VilleDao.insertVilles(recensement);

	}

}
