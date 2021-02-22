package fr.diginamic.jdbc.recensement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.diginamic.jdbc.recensement.entites.Recensement;
import fr.diginamic.jdbc.recensement.entites.Ville;
import fr.diginamic.jdbc.recensement.utils.DaoUtils;

public class VilleDao {

	public static void insertVilles(Recensement recensement) {
		Connection connection = DaoUtils.getConnection();
		String requete1 = ("SELECT id FROM departement WHERE code_departement = (?)");
		String requete2 = ("SELECT id FROM region WHERE code_region = (?)");
		String requete3 = ("INSERT INTO ville (code, nom, population, id_departement, id_region) VALUES (?,?,?,?,?)");
		try {
			for (Ville ville : recensement.getVilles()) {
				
				PreparedStatement pstmt1 = connection.prepareStatement(requete1);
				pstmt1.setString(1, ville.getCodeDepartement());
				ResultSet curseur1 = pstmt1.executeQuery();
				int idDepartement = 0;
				if (curseur1.next()) {
					idDepartement=curseur1.getInt("id");
				}
				curseur1.close();
				pstmt1.close();
				
				PreparedStatement pstmt2 = connection.prepareStatement(requete2);
				pstmt2.setInt(1, ville.getCodeRegion());
				ResultSet curseur2 = pstmt2.executeQuery();
				int idRegion = 0;
				if (curseur2.next()) {
					idRegion=curseur2.getInt("id");
				}
				curseur2.close();
				pstmt2.close();
				
				PreparedStatement pstmt3 = connection.prepareStatement(requete3);
				pstmt3.setInt(1, ville.getCodeCommune());
				pstmt3.setString(2, ville.getNomCommune());
				pstmt3.setInt(3, ville.getPopTotale());
				pstmt3.setInt(4, idDepartement);
				pstmt3.setInt(5, idRegion);
				pstmt3.executeUpdate();
				pstmt3.close();
			}
			connection.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Ville rechercherVilleParNom(String nomVille) {
		Connection connection = DaoUtils.getConnection();
		Ville ville = new Ville();
		String requete = ("SELECT * FROM ville WHERE nom = (?)");
		try {
			PreparedStatement pstmt = connection.prepareStatement(requete);
			pstmt.setString(1, nomVille);
			ResultSet curseur = pstmt.executeQuery();
			if (curseur.next()) {
				ville.setCodeCommune(curseur.getInt("code"));
				ville.setNomCommune(curseur.getString("nom"));
				ville.setPopTotale(curseur.getInt("population"));
			}
			curseur.close();
			pstmt.close();
			connection.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return ville;
	}

}
