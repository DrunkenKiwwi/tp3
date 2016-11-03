package deplacer_forme_fxml.modele;

import javafx.beans.property.DoubleProperty;

public class Deplacement extends Thread {

	
	private DoubleProperty depy;
	private DoubleProperty depx;
	private Direction direction = null;

	public Deplacement(DoubleProperty x, DoubleProperty y) {
		setDepx(x);
		setDepy(y);
		setDirection(direction);
	}

	public void run() {
		switch (direction) {
		case HAUT:
			for (int i = 0; i < 225; i++) {
				depy.set(depy.get() + 1);
			}
			break;
		case BAS:
			for (int i = 0; i < 225; i++) {
				depy.set(depy.get() - 1);
			}
			break;
		case DROITE:
			for (int i = 0; i < 200; i++) {
				depx.set(depx.get() + 1);
			}
			break;
		case GAUCHE:
			for (int i = 0; i < 200; i++) {
				depx.set(depx.get() + 1);
			}
			break;
		case ESCAPE:

			break;
		default:
			break;
		}
	}

	public DoubleProperty getDepy() {
		return depy;
	}

	public void setDepy(DoubleProperty depy) {
		this.depy = depy;
	}

	public DoubleProperty getDepx() {
		return depx;
	}

	public void setDepx(DoubleProperty depx) {
		this.depx = depx;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
