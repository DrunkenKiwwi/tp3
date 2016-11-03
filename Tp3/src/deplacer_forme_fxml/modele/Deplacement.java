package deplacer_forme_fxml.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Deplacement extends Thread {

	private DoubleProperty depy;
	private DoubleProperty depx;
	private Direction direction = Direction.ESCAPE;

	public Deplacement(Double x, Double y) {
		setDepx(new SimpleDoubleProperty(x));
		setDepy(new SimpleDoubleProperty(y));
		setDirection(direction);
	}

	public void run() {
		while (isAlive() && getDepxd() < 200 && getDepyd() < 225) {
			switch (direction) {
			case HAUT:
				depy.set(depy.get() - 5);
				break;
			case BAS:
				depy.set(depy.get() + 5);
				break;
			case DROITE:
				depx.set(depx.get() + 5);
				break;
			case GAUCHE:
				depx.set(depx.get() - 5);
				break;
			case ESCAPE:
				break;
			default:
				break;
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public DoubleProperty getDepy() {
		return depy;
	}

	public double getDepyd() {
		return depy.get();
	}

	public double getDepxd() {
		return depx.get();
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
