package fr.diginamic.jdbc.recensement.entites;

public class Departement {

	private String codeDepartement;
	private int population;

	public Departement() {
	}

	public Departement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Departement [codeDepartement=");
		builder.append(codeDepartement);
		builder.append(", population=");
		builder.append(population);
		builder.append("]");
		return builder.toString();
	}

}