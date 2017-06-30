package patterns._2_structural._3_composite;

/**
 * @author LinnykOleh
 */
public class MenuItem extends MenuComponent {

	public MenuItem(String name, String url) {
		this.name = name;
		this.url = url;
	}

	@Override
	public String toString() {
		return print(this);
	}
}
