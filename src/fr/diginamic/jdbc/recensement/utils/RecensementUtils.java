package fr.diginamic.jdbc.recensement.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.diginamic.jdbc.recensement.entites.Departement;
import fr.diginamic.jdbc.recensement.entites.Recensement;
import fr.diginamic.jdbc.recensement.entites.Region;
import fr.diginamic.jdbc.recensement.entites.Ville;

public class RecensementUtils {

	public static List<Departement> recupererDepartements(String chemin) throws IOException {
		Path pathRecensement = Paths.get(chemin);
		List<String> villes = Files.readAllLines(pathRecensement);

		HashMap<String, Departement> mapDepartement = new HashMap<>();
		List<Departement> departements = new ArrayList<>();

		for (int i = 1; i < villes.size(); i++) {
			String[] morceaux = villes.get(i).split(";");
			String codeDepartement = morceaux[2].toLowerCase();
			if (codeDepartement.charAt(0) == '0') {
				codeDepartement = codeDepartement.trim().replaceAll("0", "");
			}

			if (!mapDepartement.containsKey(codeDepartement)) {
				Departement nouveauDepartement = new Departement(codeDepartement);
				mapDepartement.put(codeDepartement, nouveauDepartement);
				departements.add(nouveauDepartement);
			}
		}
		return departements;
	}

	public static List<Region> recupererRegions(String chemin) throws IOException {
		Path pathRecensement = Paths.get(chemin);
		List<String> villes = Files.readAllLines(pathRecensement);

		HashMap<Integer, Region> mapRegion = new HashMap<>();
		List<Region> regions = new ArrayList<>();

		for (int i = 1; i < villes.size(); i++) {
			String[] morceaux = villes.get(i).split(";");
			int codeRegion = Integer.parseInt(morceaux[0]);
			String nomRegion = morceaux[1].toLowerCase();

			if (!mapRegion.containsKey(codeRegion)) {
				Region nouvelleRegion = new Region(codeRegion, nomRegion);
				mapRegion.put(codeRegion, nouvelleRegion);
				regions.add(nouvelleRegion);
			}
		}
		return regions;
	}

	public static Recensement recupererRecensement(String chemin) throws IOException {
		Recensement recensement = new Recensement();
		Path pathRecensement = Paths.get(chemin);
		List<String> villes = Files.readAllLines(pathRecensement);
		
		for (int i = 1; i < villes.size(); i++) {
			String[] morceaux = villes.get(i).split(";");
			int codeRegion = Integer.parseInt(morceaux[0]);
			String nomRegion = morceaux[1].toLowerCase();
			String codeDepartement = morceaux[2].toLowerCase();
			if (codeDepartement.charAt(0) == '0') {
				codeDepartement = codeDepartement.trim().replaceAll("0", "");
			}
			int codeCommune = Integer.parseInt(morceaux[5]);
			String nomCommune = morceaux[6].toLowerCase();
			int population = Integer.parseInt(morceaux[9].trim().replaceAll(" ", ""));
			recensement.getVilles()
					.add(new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, population));
		}
		return recensement;
	}

}
