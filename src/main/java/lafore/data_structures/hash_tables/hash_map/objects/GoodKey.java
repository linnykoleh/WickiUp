package lafore.data_structures.hash_tables.hash_map.objects;

import java.util.Objects;

/**
 * @author LinnykOleh
 */
public class GoodKey {

	private String a;
	private String b;

	public GoodKey(String a, String b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		GoodKey that = (GoodKey) o;
		return Objects.equals(that.a, this.a) && Objects.equals(that.b, this.b);
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}
}
