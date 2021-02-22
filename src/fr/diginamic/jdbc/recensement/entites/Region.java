package fr.diginamic.jdbc.recensement.entites;

public class Region {

	private int codeRegion;
	private String nomRegion;
	private int population;

	public Region() {
	}

	public Region(int codeRegion, String nomRegion) {
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
	}

	public int getCodeRegion() {
		return codeRegion;
	}

	public void setCodeRegion(int codeRegion) {
		this.codeRegion = codeRegion;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomREgion) {
		this.nomRegion = nomREgion;
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
		builder.append("Region [codeRegion=");
		builder.append(codeRegion);
		builder.append(", nomRegion=");
		builder.append(nomRegion);
		builder.append(", population=");
		builder.append(population);
		builder.append("]");
		return builder.toString();
	}

}
