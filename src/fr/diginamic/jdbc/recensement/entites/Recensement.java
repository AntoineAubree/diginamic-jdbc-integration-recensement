package fr.diginamic.jdbc.recensement.entites;

import java.util.ArrayList;

public class Recensement {

	private ArrayList<Ville> villes;

	public Recensement() {
		this.villes = new ArrayList<>();
	}

	public ArrayList<Ville> getVilles() {
		return villes;
	}

	public void setVilles(ArrayList<Ville> villes) {
		this.villes = villes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recensement [villes=");
		builder.append(villes);
		builder.append("]");
		return builder.toString();
	}

}
