package lafore.data_structures.red_black_trees.for_tests;


public class Key implements Comparable<Key>{

	private static int MORE = 1;
	private static int LESS = -1;
	private static int SAME = 0;

	private int index;

	public Key(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(Key o) {
		if(index > o.index){
			return MORE;
		}else if(index < o.index){
			return LESS;
		} else {
			return SAME;
		}
	}
}
