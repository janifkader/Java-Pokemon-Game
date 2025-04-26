import java.util.ArrayList;

public class Move {
	String name;
	Type type;
	int damage;
	ArrayList<Double> stat_changes;
	
	public Move(String name, Type type, int damage, ArrayList<Double> stat_changes) {
		this.name = name;
		this.type = type;
		this.damage = damage;
		this.stat_changes = stat_changes;
	}
}
