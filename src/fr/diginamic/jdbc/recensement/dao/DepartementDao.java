package fr.diginamic.jdbc.recensement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.recensement.entites.Departement;
import fr.diginamic.jdbc.recensement.utils.DaoUtils;

public class DepartementDao {

	public static void insertDepartements(List<Departement> departements) {
		Connection connection = DaoUtils.getConnection();
		String requete = ("INSERT INTO departement (code_departement) VALUES (?)");
		try {
			for (Departement departement : departements) {
				PreparedStatement pstmt = connection.prepareStatement(requete);
				pstmt.setString(1, departement.getCodeDepartement());
				pstmt.executeUpdate();
				pstmt.close();
			}
			connection.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Departement rechercherDepartementParCode(String codeDepartement) {
		Connection connection = DaoUtils.getConnection();
		Departement departement = new Departement();
		String requete = (
				"SELECT code_departement, SUM(ville.population) AS population_totale FROM ville JOIN departement ON ville.id_departement = departement.id WHERE departement.code_departement = (?)");
		try {
			PreparedStatement pstmt = connection.prepareStatement(requete);
			pstmt.setString(1, codeDepartement);
			ResultSet curseur = pstmt.executeQuery();
			if (curseur.next()) {
				departement.setCodeDepartement(curseur.getString("code_departement"));
				departement.setPopulation(curseur.getInt("population_totale"));
			}
			curseur.close();
			pstmt.close();
			connection.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return departement;
	}

}
