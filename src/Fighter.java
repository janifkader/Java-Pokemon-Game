import java.util.ArrayList;
import java.util.Random;

public class Fighter{
	String name;
	ArrayList<Type> types;
	ArrayList<Move> moveset;
	ArrayList<Stat> stats;
	ArrayList<Type> weak;
	ArrayList<Type> immune;
	ArrayList<Type> resist;
	String message;
	String sprite;
	String back_sprite;
	
	public Fighter(String name, ArrayList<Type> types, ArrayList<Stat> stats, ArrayList<Type> weak, ArrayList<Type> resist, ArrayList<Type> immune, String sprite, String back_sprite) {
		this.name = name;
		this.types = types;
		this.stats = stats;
		this.moveset = new ArrayList<Move>();
		this.weak = weak;
		this.resist = resist;
		this.immune = immune;
		message = "";
		this.sprite = sprite;
		this.back_sprite = back_sprite;
	}
	
	public void addMove(Move move) {
		this.moveset.add(move);
	}
	
	public void useMove(Fighter target, int id) {
		Move move = this.moveset.get(id);
		if (move.damage > 0) {
			target.stats.get(0).value = Math.max(0, target.stats.get(0).value - damageCalc(move, this, target));
			if (target.weak.contains(move.type) && !target.resist.contains(move.type)) {
				this.message = "It was super effective!";
			}
			else if (target.resist.contains(move.type)) {
				this.message = "It was not very effective.";
			}
			else if (target.immune.contains(move.type)) {
				this.message = "It did not affect " + target.name + ".";
			}
		}
		for (int i = 0; i < target.stats.size(); i++) {
			if (move.stat_changes.get(i) < 0) {
				this.message = target.name + "\'s " + target.stats.get(i).name + " was lowered!";
				target.stats.get(i).value += target.stats.get(i).value * move.stat_changes.get(i);
			}
			else if (move.stat_changes.get(i) > 0) {
				this.message = this.name + "\'s " + this.stats.get(i).name + " was raised!";
				this.stats.get(i).value += this.stats.get(i).value * move.stat_changes.get(i);
			}
		}
	}
	private double damageCalc(Move move, Fighter user, Fighter opp) {
		double damage = (22*move.damage*(user.stats.get(1).value/opp.stats.get(2).value))/50+2;
		if (user.types.contains(move.type)) {
			damage *= 1.5;
		}
		if (opp.weak.contains(move.type)) {
			damage *= 2;
		}
		if (opp.resist.contains(move.type)) {
			damage *= 0.5;
		}
		if (opp.immune.contains(move.type)) {
			damage = 0;
		}
		return damage;
	}
	
	public int chooseMove(Fighter target) {
		ArrayList<Double> scores = new ArrayList<Double>();
		scores.add(100.0);
		scores.add(100.0);
		scores.add(100.0);
		scores.add(100.0);
		for (int i = 0; i < 4; i++) {
			if (this.moveset.get(i).damage == 0) {
				for (int j = 0; j < target.stats.size(); j++) {
					if (this.moveset.get(i).stat_changes.get(j) < 0) {
						if (target.stats.get(j).value >= this.stats.get(j).value && this.stats.get(j).name.equals("Speed")) {
							scores.set(i, scores.get(i) + 20);
						}
						else if (target.stats.get(j).name.equals("Defense") && target.stats.get(j).value >= this.stats.get(1).value) {
							scores.set(i, scores.get(i) + 20);
						}
						else if (target.stats.get(j).name.equals("Attack") && target.stats.get(j).value >= this.stats.get(2).value) {
							scores.set(i, scores.get(i) + 20);
						}
					}
					else if (this.moveset.get(i).stat_changes.get(j) > 0) {
						if (target.stats.get(j).value >= this.stats.get(j).value && this.stats.get(j).name.equals("Speed")) {
							scores.set(i, scores.get(i) + 20);
						}
						else if (this.stats.get(j).name.equals("Attack") && this.stats.get(j).value <= target.stats.get(2).value) {
							scores.set(i, scores.get(i) + 20);
						}
						else if (target.stats.get(j).name.equals("Defense") && this.stats.get(j).value <= target.stats.get(1).value) {
							scores.set(i, scores.get(i) + 20);
						}
						else if (this.stats.get(j).name.equals("Health") && this.stats.get(j).value <= 50) {
							scores.set(i, scores.get(i) + 75);
						}
					}
				}
				if (this.stats.get(0).value <= 25) {
					scores.set(i, scores.get(i) - 50);
				}
			}
			else {
				if (damageCalc(this.moveset.get(i), this, target) >= target.stats.get(0).value) {
					scores.set(i, scores.get(i) + 100);
				}
				if (target.weak.contains(this.moveset.get(i).type)) {
					scores.set(i, scores.get(i) + 75);
				}
				if (target.resist.contains(this.moveset.get(i).type)) {
					scores.set(i, scores.get(i) - 75);
				}
				if (target.immune.contains(this.moveset.get(i).type)) {
					scores.set(i, scores.get(i) - 100);
				}
			}
		}
		printScores(scores);
		double tot = getTotal(scores);
		for (int k = 0; k < scores.size(); k++) {
			scores.set(k, scores.get(k)/tot);
		}
		printScores(scores);
		Random rand = new Random();
		double move = rand.nextDouble();
		System.out.println("RANDOM: " + move);
		if (move <= scores.get(0)) {
			return 0;
		}
		else if (move <= scores.get(0) + scores.get(1)) {
			return 1;
		}
		else if (move <= scores.get(0) + scores.get(1) + scores.get(2)) {
			return 2;
		}
		else {
			return 3;
		}
	}
	private double getTotal(ArrayList<Double> arr) {
		double total = 0;
		for (int i = 0; i < arr.size(); i++) {
			total += arr.get(i);
		}
		return total;
	}
	/*private void printStats(Fighter fighter) {
		for (int i = 0; i < fighter.stats.size(); i++) {
			System.out.println(fighter.name + "'s " + fighter.stats.get(i).name + ": " + fighter.stats.get(i).value);
		}
	}*/
	private void printScores(ArrayList<Double> scores) {
		for (int i = 0; i < 4; i++) {
			System.out.println("Score# " + i + ": " + scores.get(i));
		}
	}
}
