package patterns._2_structural._3_composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinnykOleh
 */
public abstract class MenuComponent {

	String name;
	String url;
	List<MenuComponent> menuComponents = new ArrayList<>();

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public MenuComponent add(MenuComponent menuComponent){
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}

	public MenuComponent remove(MenuComponent menuComponent){
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}

	String print(MenuComponent menuComponent){
		final StringBuilder stringBuilder = new StringBuilder(menuComponent.name);

		stringBuilder.append(": ");
		stringBuilder.append(menuComponent.url);
		stringBuilder.append("\n");

		return stringBuilder.toString();
	}

	public abstract String toString();
}
