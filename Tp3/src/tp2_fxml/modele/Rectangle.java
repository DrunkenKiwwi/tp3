package tp2_fxml.modele;

import tp2_fxml.exception.FormeException;

public class Rectangle extends Forme {

	private int hauteur = 1;
	private int largeur = 1;

	
	/**
	 * Constructeur des rectangles, qui prend la hauteur et la largeur passées
	 * en paramètres, et met le nom "Rectangle"
	 * 
	 * @param hauteur
	 *            hauteur du rectangle
	 * @param largeur
	 *            largeur du rectangle
	 * @throws FormeException
	 *             si le rectangle n'est pas valide
	 */
	public Rectangle(int largeur, int hauteur) throws FormeException {
		super("Rectangle");
		if (validerHauteur(hauteur) && validerLargeur(largeur)) {
			setHauteur(hauteur);
			setLargeur(largeur);
		} else {
			throw new FormeException();
		}
	}

	/**
	 * Permet de calculer l'aire du rectangle
	 * 
	 * @return l'aire du rectangle
	 */
	public int calculerSurface() {
		return (getHauteur() * getLargeur());
	}

	/**
	 * Permet de calculer le périmètre du rectangle
	 * 
	 * @return le périmètre du rectangle
	 */
	public int calculerPerimetre() {
		return ((getHauteur() * 2) + (getLargeur() * 2));
	}

	/**
	 * Donne le nom du rectangle, sa largeur et sa hauteur
	 * 
	 * @return Nom, largeur et hauteur
	 */
	public String toString() {
		return ("Rectangle de " + getLargeur() + " de largeur et de " + getHauteur() + " de hauteur");
	}

	/**
	 * Donne la hauteur du rectangle
	 * 
	 * @return la hauteur du rectangle
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * Modifie la hauteur du rectangle, si elle est entre MIN_VAL et MAX_VAL
	 * 
	 * @param hauteur
	 *            hauteur désirée
	 */
	public void setHauteur(int hauteur) {
		if (validerHauteur(hauteur)) {
			this.hauteur = hauteur;
		}
	}

	/**
	 * Valide si la hauteur passée en paramètre est entre MIN_VAL et MAX_VAL
	 * 
	 * @param hauteur
	 *            hauteur à tester
	 * @return vrai si la valeur passée est entre MIN_VAL et MAX_VAL
	 */
	private static boolean validerHauteur(int hauteur) {
		return ((hauteur <= MAX_VAL) && (hauteur >= MIN_VAL));
	}

	/**
	 * Donne la largeur du rectangle
	 * 
	 * @return la largeur du rectangle
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Modifie la largeur du rectangle, si elle est entre MIN_VAL et MAX_VAL
	 * 
	 * @param largeur
	 *            la largeur désirée
	 */
	public void setLargeur(int largeur) {
		if (validerLargeur(largeur)) {
			this.largeur = largeur;
		}
	}

	/**
	 * Valide si la largeur passée en paramètre est entre MIN_VAL et MAX_VAL
	 * 
	 * @param largeur
	 *            largeur à tester
	 * @return vrai si la valeur passée est entre MIN_VAL et MAX_VAL
	 */
	private static boolean validerLargeur(int largeur) {
		return ((largeur <= MAX_VAL) && (largeur >= MIN_VAL));
	}
	

}
