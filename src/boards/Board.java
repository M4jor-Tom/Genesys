package boards;

import generic.Ratio;

public class Board {
	private Ratio wheelHardness;
	private Ratio turning;

	public Board(Ratio wheelHardness, Ratio turning) {
		super();
		
		setWheelHardness(wheelHardness);
		setTurning(turning);
	}

	@Override
	public String toString() {
		return "Board [wheelHardness=" + getWheelHardness() + ", turning=" + getTurning() + "]";
	}

	public Ratio getWheelHardness() {
		return wheelHardness;
	}

	public void setWheelHardness(Ratio wheelHardness) {
		this.wheelHardness = wheelHardness;
	}

	public Ratio getTurning() {
		return turning;
	}

	public void setTurning(Ratio turning) {
		this.turning = turning;
	}
}