package e04;

import java.util.ArrayList;

public class FlipTextModel implements IFlipTextModel {

	ArrayList<String> listTextes = new ArrayList<String>();
	int iterator = -1;

	@Override
	public void addText(String text) {
		listTextes.add(text);
	}

	@Override
	public String getNextText() {
		if (iterator == listTextes.size() - 1) {
			goToFirstText();
		} else {
			iterator++;
		}
		return listTextes.get(iterator);
	}

	@Override
	public void goToFirstText() {
		iterator = -1;
	}

	@Override
	public void clear() {
		for (String string : listTextes) {
			// listTextes.removeAll();
		}

	}

}
