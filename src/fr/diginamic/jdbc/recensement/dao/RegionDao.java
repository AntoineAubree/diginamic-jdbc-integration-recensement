package fr.diginamic.jdbc.recensement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.recensement.entites.Region;
import fr.diginamic.jdbc.recensement.utils.DaoUtils;

public class RegionDao {

	public static void insertRegions(List<Region> regions) {
		Connection connection = DaoUtils.getConnection();
		String requete = ("INSERT INTO region (code_region, nom_region) VALUES (?,?)");
		try {
			for (Region region : regions) {
				PreparedStatement pstmt = connection.prepareStatement(requete);
				pstmt.setInt(1, region.getCodeRegion());
				pstmt.setString(2, region.getNomRegion());
				pstmt.executeUpdate();
				pstmt.close();
			}
			connection.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Region rechercherRegionParNom(String nomRegion) {
		Connection connection = DaoUtils.getConnection();
		Region region = new Region();
		String requete = (
				"SELECT nom_region, SUM(ville.population) AS population_totale FROM ville JOIN region ON ville.id_region = region.id WHERE region.nom_region = (?)");
		try {
			PreparedStatement pstmt = connection.prepareStatement(requete);
			pstmt.setString(1, nomRegion);
			ResultSet curseur = pstmt.executeQuery();
			if (curseur.next()) {
				region.setNomRegion(curseur.getString("nom_region"));
				region.setPopulation(curseur.getInt("population_totale"));
			}
			curseur.close();
			pstmt.close();
			connection.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return region;
	}

}
