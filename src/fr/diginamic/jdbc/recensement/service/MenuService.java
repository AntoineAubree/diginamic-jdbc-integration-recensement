package fr.diginamic.jdbc.recensement.service;

import java.util.Scanner;

public interface MenuService {

	/**
	 * @param recensement Recensement
	 * @param sc Scanner
	 */
	public abstract void traiter(Scanner sc);

}
