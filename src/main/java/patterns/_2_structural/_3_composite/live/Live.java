package patterns._2_structural._3_composite.live;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LinnykOleh
 */
public class Live {

	public static void main(String[] args) {
		final Map<String, String> personalAttributes = new HashMap<>();
		personalAttributes.put("site_role", "person");
		personalAttributes.put("access_role", "limited");

		final Map<String, String> groupsAttributes = new HashMap<>();
		groupsAttributes.put("group_rule", "claims");

		final Map<String, String> secAttributes = new HashMap<>();
		secAttributes.putAll(personalAttributes);
		secAttributes.putAll(groupsAttributes);

		System.out.println(secAttributes);

	}
}
