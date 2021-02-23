package fr.diginamic.jdbc.recensement.service;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.jdbc.recensement.dao.DepartementDao;
import fr.diginamic.jdbc.recensement.entites.Departement;

/**
 * Permet d'afficher les 10 départements les plus peuplés de la base recensement
 * 
 * @author Antoine
 *
 */
public class RechercherDepartementsPlusPeuples implements MenuService {

	/**
	 * Prend en argument un objet de type Scanner.
	 * Affiche les 10 départements les plus peuplés de la base recensement.
	 */
	@Override
	public void traiter(Scanner sc) {
		List<Departement> departements = DepartementDao.rechercherDepartementPlusPeuples();
		System.out.println("Les 10 départements les plus peuplés sont :");
		for (Departement departement: departements) {
			System.out.println("Population : " + departement.getPopulation() + " Département : "
					+ departement.getCodeDepartement());
		}
	}

}
