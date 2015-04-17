package s02.model;

public class Case {
	private boolean containMine;
	private boolean flag;
	private boolean opened;

	public Case(boolean containMine, boolean flag, boolean opened) {
		this.containMine = containMine;
		this.flag = flag;
		this.opened = opened;
	}

	public boolean getContainMine() {
		return containMine;
	}

	public void setMine(boolean containMine) {
		this.containMine = containMine;
	}

	public boolean isFlagged() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

}
