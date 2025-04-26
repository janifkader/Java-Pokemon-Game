import java.util.ArrayList;

public class Create {
	static Type normal = new Type("Normal", 0xa89e9e); 
	static Type electric = new Type("Electric", 0xF7C600);
	static Type dark = new Type("Dark", 0x3c3a3a);
	static Type fire = new Type("Fire", 0xf36d0b);
	static Type dragon = new Type("Dragon", 0x4a0bf3);
	static Type water = new Type("Water", 0x329dfc);
	static Type steel = new Type("Steel", 0xa6b7c6);
	static Type grass = new Type("Grass", 0x55cb0b);
	static Type fighting = new Type("Fighting", 0xba1010);
	static Type psychic = new Type("Psychic", 0xc612ce);
	static Type fairy = new Type("Fairy", 0xfaaff3);
	static Type rock = new Type("Rock", 0x9b7b60);
	static Type ground = new Type("Ground", 0xb85807);
	static Type bug = new Type("Bug", 0x68a300);
	static Type ghost = new Type("Ghost", 0x480ec1);
	static Type poison = new Type("Poison", 0x8a1be2);
	static Type ice = new Type("Ice", 0x20eaf7);
	static Type flying = new Type("Flying", 0xa6d7f7);
	
	private static ArrayList<Stat> createStats(int h, int a, int d, int s){
		Stat health = new Stat("Health", h);
		Stat attack = new Stat("Attack", a);
		Stat defense = new Stat("Defense", d);
		Stat speed = new Stat("Speed", s);
		ArrayList<Stat> stats = new ArrayList<Stat>();
		stats.add(health);
		stats.add(attack);
		stats.add(defense);
		stats.add(speed);
		return stats;
	}
	
	public static Fighter createJolteon() {
		
		ArrayList<Stat> stats = createStats(172, 178, 123, 200);

		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(flying);
		resist.add(electric);
		resist.add(steel);
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(ground);
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(electric);
		ArrayList<Type> immune = new ArrayList<Type>();
		Fighter jolteon = new Fighter("Jolteon", types, stats, weak, resist, immune, "/images/jolteon.png", "/images/jolteon_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Tackle", normal, 40, arr);
		Move move2 = new Move("Thunder Shock", electric, 40, arr);
		Move move3 = new Move("Discharge", electric, 80, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(2, -0.33);
		Move move4 = new Move("Tail Whip", normal, 0, arr2);
		jolteon.addMove(move1);
		jolteon.addMove(move2);
		jolteon.addMove(move3);
		jolteon.addMove(move4);
		return jolteon;
	}
	
	public static Fighter createMeganium() {

		ArrayList<Stat> stats = createStats(187, 147, 167, 167);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(ground);
		resist.add(water);
		resist.add(grass);
		resist.add(electric);
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(fire);
		weak.add(ice);
		weak.add(flying);
		weak.add(poison);
		weak.add(bug);
		ArrayList<Type> immune = new ArrayList<Type>();
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(grass);
		Fighter meganium = new Fighter("Meganium", types, stats, weak, resist, immune, "/images/meganium.png", "/images/meganium_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Razor Leaf", grass, 55, arr);
		Move move2 = new Move("Magical Leaf", grass, 60, arr);
		Move move3 = new Move("Body Slam", normal, 85, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(1, -0.33);
		Move move4 = new Move("Growl", normal, 0, arr2);
		meganium.addMove(move1);
		meganium.addMove(move2);
		meganium.addMove(move3);
		meganium.addMove(move4);
		return meganium;
	}
	
	public static Fighter createCharizard() {
		
		ArrayList<Stat> stats = createStats(185, 149, 143, 167);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(fighting);
		resist.add(bug);
		resist.add(steel);
		resist.add(fire);
		resist.add(grass);
		resist.add(fairy);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(rock);
		weak.add(electric);
		weak.add(water);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(ground);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(fire);
		types.add(flying);
		
		Fighter charizard = new Fighter("Charizard", types, stats, weak, resist, immune, "/images/charizard.png", "/images/charizard_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Flamethrower", fire, 90, arr);
		Move move2 = new Move("Air Slash", flying, 75, arr);
		Move move3 = new Move("Dragon Breath", dragon, 60, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(3, -0.33);
		Move move4 = new Move("Scary Face", normal, 0, arr2);
		charizard.addMove(move1);
		charizard.addMove(move2);
		charizard.addMove(move3);
		charizard.addMove(move4);
		return charizard;
	}
	
	public static Fighter createGyarados() {
		
		ArrayList<Stat> stats = createStats(202, 194, 144, 146);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(fighting);
		resist.add(bug);
		resist.add(steel);
		resist.add(fire);
		resist.add(water);
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(rock);
		weak.add(electric);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(ground);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(water);
		types.add(flying);
		
		Fighter gyarados = new Fighter("Gyarados", types, stats, weak, resist, immune, "/images/gyarados.png", "/images/gyarados_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Aqua Tail", water, 90, arr);
		Move move2 = new Move("Ice Fang", ice, 65, arr);
		Move move3 = new Move("Crunch", dark, 80, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(1, 0.33);
		Move move4 = new Move("Dragon Dance", dragon, 0, arr2);
		gyarados.addMove(move1);
		gyarados.addMove(move2);
		gyarados.addMove(move3);
		gyarados.addMove(move4);
		return gyarados;
	}
	
	public static Fighter createMachamp() {
		
		ArrayList<Stat> stats = createStats(197, 200, 145, 117);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(rock);
		resist.add(bug);
		resist.add(dark);
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(psychic);
		weak.add(flying);
		weak.add(fairy);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(fighting);
		
		Fighter machamp = new Fighter("Machamp", types, stats, weak, resist, immune, "/images/machamp.png", "/images/machamp_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Cross Chop", fighting, 100, arr);
		Move move2 = new Move("Knock Off", dark, 65, arr);
		Move move3 = new Move("Strength", normal, 80, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(2, 0.33);
		Move move4 = new Move("Bulk Up", fighting, 0, arr2);
		machamp.addMove(move1);
		machamp.addMove(move2);
		machamp.addMove(move3);
		machamp.addMove(move4);
		return machamp;
	}
	
	public static Fighter createExeggutor() {
		
		ArrayList<Stat> stats = createStats(202, 194, 150, 117);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(fighting);
		resist.add(electric);
		resist.add(water);
		resist.add(ground);
		resist.add(grass);
		resist.add(psychic);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(ghost);
		weak.add(dark);
		weak.add(bug);
		weak.add(poison);
		weak.add(fire);
		weak.add(flying);
		weak.add(ice);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(grass);
		types.add(psychic);
		
		Fighter exeggutor = new Fighter("Exeggutor", types, stats, weak, resist, immune, "/images/exeggutor.png", "/images/exeggutor_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Seed Bomb", grass, 80, arr);
		Move move2 = new Move("Confusion", psychic, 50, arr);
		Move move3 = new Move("Psyshock", psychic, 80, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(0, 0.25);
		Move move4 = new Move("Synthesis", grass, 0, arr2);
		exeggutor.addMove(move1);
		exeggutor.addMove(move2);
		exeggutor.addMove(move3);
		exeggutor.addMove(move4);
		return exeggutor;
	}
	
	public static Fighter createDragonite() {
		
		ArrayList<Stat> stats = createStats(198, 204, 167, 145);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(fighting);
		resist.add(bug);
		resist.add(water);
		resist.add(fire);
		resist.add(grass);

		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(rock);
		weak.add(ice);
		weak.add(dragon);
		weak.add(fairy);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(ground);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(dragon);
		types.add(flying);
		
		Fighter dragonite = new Fighter("Dragonite", types, stats, weak, resist, immune, "/images/dragonite.png", "/images/dragonite_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Wing Attack", flying, 60, arr);
		Move move2 = new Move("Fire Punch", fire, 75, arr);
		Move move3 = new Move("Slam", normal, 80, arr);
		Move move4 = new Move("Dragon Rush", dragon, 100, arr);
		dragonite.addMove(move1);
		dragonite.addMove(move2);
		dragonite.addMove(move3);
		dragonite.addMove(move4);
		return dragonite;
	}
	
	public static Fighter createSteelix() {
		
		ArrayList<Stat> stats = createStats(182, 150, 277, 90);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(normal);
		resist.add(flying);
		resist.add(rock);
		resist.add(bug);
		resist.add(steel);
		resist.add(dragon);
		resist.add(fairy);
		resist.add(psychic);

		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(fighting);
		weak.add(ground);
		weak.add(fire);
		weak.add(water);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(electric);
		immune.add(poison);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(ground);
		types.add(steel);
		
		Fighter steelix = new Fighter("Steelix", types, stats, weak, resist, immune, "/images/steelix.png", "/images/steelix_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Thunder Fang", electric, 80, arr);
		Move move2 = new Move("Rock Slide", rock, 75, arr);
		Move move3 = new Move("Iron Tail", steel, 100, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(3, 0.66);
		Move move4 = new Move("Rock Polish", rock, 0, arr2);
		steelix.addMove(move1);
		steelix.addMove(move2);
		steelix.addMove(move3);
		steelix.addMove(move4);
		return steelix;
	}
	
	public static Fighter createDonphan() {
		
		ArrayList<Stat> stats = createStats(197, 189, 189, 112);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(poison);
		resist.add(rock);

		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(grass);
		weak.add(ice);
		weak.add(water);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(electric);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(ground);
		
		Fighter donphan = new Fighter("Donphan", types, stats, weak, resist, immune, "/images/donphan.png", "/images/donphan_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Bulldoze", ground, 60, arr);
		Move move2 = new Move("Rollout", rock, 30, arr);
		Move move3 = new Move("Earthquake", ground, 100, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(2, 0.33);
		Move move4 = new Move("Defense Curl", normal, 0, arr2);
		donphan.addMove(move1);
		donphan.addMove(move2);
		donphan.addMove(move3);
		donphan.addMove(move4);
		return donphan;
	}
	
	public static Fighter createSnorlax() {
		
		ArrayList<Stat> stats = createStats(267, 178, 178, 90);
		
		ArrayList<Type> resist = new ArrayList<Type>();

		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(fighting);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(normal);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		types.add(ghost);
		
		Fighter snorlax = new Fighter("Snorlax", types, stats, weak, resist, immune, "/images/snorlax.png", "/images/snorlax_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Giga Impact", normal, 150, arr);
		Move move2 = new Move("Lick", ghost, 30, arr);
		Move move3 = new Move("Hammer Arm", fighting, 100, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(1, 0.33);
		Move move4 = new Move("Amnesia", psychic, 0, arr2);
		snorlax.addMove(move1);
		snorlax.addMove(move2);
		snorlax.addMove(move3);
		snorlax.addMove(move4);
		return snorlax;
	}
	
	public static Fighter createGengar() {
		
		ArrayList<Stat> stats = createStats(167, 244, 161, 200);
		
		ArrayList<Type> resist = new ArrayList<Type>();

		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(ground);
		weak.add(ghost);
		weak.add(psychic);
		weak.add(dark);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(ghost);
		types.add(poison);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(normal);
		immune.add(fighting);
		
		Fighter gengar = new Fighter("Gengar", types, stats, weak, resist, immune, "/images/gengar.png", "/images/gengar_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Shadow Punch", ghost, 60, arr);
		Move move2 = new Move("Shadow Ball", ghost, 80, arr);
		Move move3 = new Move("Payback", dark, 50, arr);
		Move move4 = new Move("Poison Jab", poison, 80, arr);
		gengar.addMove(move1);
		gengar.addMove(move2);
		gengar.addMove(move3);
		gengar.addMove(move4);
		return gengar;
	}
	
	public static Fighter createTyranitar() {
		
		ArrayList<Stat> stats = createStats(207, 237, 222, 135);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(normal);
		resist.add(flying);
		resist.add(poison);
		resist.add(ghost);
		resist.add(fire);
		resist.add(dark);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(fighting);
		weak.add(ground);
		weak.add(bug);
		weak.add(steel);
		weak.add(fairy);
		weak.add(water);
		weak.add(grass);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(psychic);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(rock);
		types.add(dark);
		
		Fighter tyranitar = new Fighter("Tyranitar", types, stats, weak, resist, immune, "/images/tyranitar.png", "/images/tyranitar_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Dark Pulse", dark, 80, arr);
		Move move2 = new Move("Smack Down", rock, 50, arr);
		Move move3 = new Move("Stone Edge", rock, 100, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(2, -0.33);
		Move move4 = new Move("Screech", normal, 0, arr2);
		tyranitar.addMove(move1);
		tyranitar.addMove(move2);
		tyranitar.addMove(move3);
		tyranitar.addMove(move4);
		return tyranitar;
	}
	
	public static Fighter createScizor() {
		
		ArrayList<Stat> stats = createStats(177, 200, 167, 128);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(normal);
		resist.add(bug);
		resist.add(steel);
		resist.add(grass);
		resist.add(psychic);
		resist.add(ice);
		resist.add(dragon);
		resist.add(fairy);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(fire);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(poison);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(bug);
		types.add(steel);
		
		Fighter scizor = new Fighter("Scizor", types, stats, weak, resist, immune, "/images/scizor.png", "/images/scizor_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Metal Claw", steel, 50, arr);
		Move move2 = new Move("X-Scissor", bug, 80, arr);
		ArrayList<Double> arr3 = new ArrayList<Double>();
		while(arr3.size() < 4) arr3.add(0.0);
		arr3.set(1, 0.33);
		Move move3 = new Move("Swords Dance", normal, 0, arr3);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(3, 0.33);
		Move move4 = new Move("Agility", psychic, 0, arr2);
		scizor.addMove(move1);
		scizor.addMove(move2);
		scizor.addMove(move3);
		scizor.addMove(move4);
		return scizor;
	}
	
	public static Fighter createClefable() {
		
		ArrayList<Stat> stats = createStats(202, 161, 156, 123);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(fighting);
		resist.add(bug);
		resist.add(dark);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(poison);
		weak.add(steel);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(dragon);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(fairy);
		
		Fighter clefable = new Fighter("Clefable", types, stats, weak, resist, immune, "/images/clefable.png", "/images/clefable_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Pound", normal, 40, arr);
		Move move2 = new Move("Disarming Voice", fairy, 40, arr);
		Move move3 = new Move("Moonblast", fairy, 95, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(0, 0.25);
		Move move4 = new Move("Life Dew", water, 0, arr2);
		clefable.addMove(move1);
		clefable.addMove(move2);
		clefable.addMove(move3);
		clefable.addMove(move4);
		return clefable;
	}

	public static Fighter createHoundoom() {
		
		ArrayList<Stat> stats = createStats(182, 178, 145, 161);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(ghost);
		resist.add(steel);
		resist.add(dark);
		resist.add(fire);
		resist.add(grass);
		resist.add(ice);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(fighting);
		weak.add(ground);
		weak.add(rock);
		weak.add(water);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(psychic);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(fire);
		types.add(dark);
		
		Fighter houndoom = new Fighter("Houndoom", types, stats, weak, resist, immune, "/images/houndoom.png", "/images/houndoom_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Bite", dark, 60, arr);
		Move move2 = new Move("Smog", poison, 30, arr);
		Move move3 = new Move("Inferno", fire, 100, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(1, 0.66);
		Move move4 = new Move("Nasty Plot", dark, 0, arr2);
		houndoom.addMove(move1);
		houndoom.addMove(move2);
		houndoom.addMove(move3);
		houndoom.addMove(move4);
		return houndoom;
	}
	
	public static Fighter createLapras() {
		
		ArrayList<Stat> stats = createStats(237, 150, 161, 123);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(water);
		resist.add(ice);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(fighting);
		weak.add(grass);
		weak.add(rock);
		weak.add(electric);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(water);
		types.add(ice);
		
		Fighter lapras = new Fighter("Lapeas", types, stats, weak, resist, immune, "/images/lapras.png", "/images/lapras_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Water Pulse", water, 60, arr);
		Move move2 = new Move("Ice Beam", ice, 90, arr);
		Move move3 = new Move("Hydro Pump", water, 110, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(2, 0.66);
		Move move4 = new Move("Reflect", psychic, 0, arr2);
		lapras.addMove(move1);
		lapras.addMove(move2);
		lapras.addMove(move3);
		lapras.addMove(move4);
		return lapras;
	}
	
	public static Fighter createNidoking() {
		
		ArrayList<Stat> stats = createStats(188, 158, 141, 150);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(fighting);
		resist.add(poison);
		resist.add(rock);
		resist.add(bug);
		resist.add(fairy);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(ground);
		weak.add(water);
		weak.add(psychic);
		weak.add(ice);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		immune.add(electric);
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(poison);
		types.add(ground);
		
		Fighter nidoking = new Fighter("Nidoking", types, stats, weak, resist, immune, "/images/nidoking.png", "/images/nidoking_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Megahorn", bug, 120, arr);
		Move move2 = new Move("Earth Power", ground, 90, arr);
		Move move3 = new Move("Sludge Wave", poison, 95, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(2, -0.66);
		Move move4 = new Move("Leer", normal, 0, arr2);
		nidoking.addMove(move1);
		nidoking.addMove(move2);
		nidoking.addMove(move3);
		nidoking.addMove(move4);
		return nidoking;
	}
	
public static Fighter createArcanine() {
		
		ArrayList<Stat> stats = createStats(197, 178, 145, 161);
		
		ArrayList<Type> resist = new ArrayList<Type>();
		resist.add(steel);
		resist.add(grass);
		resist.add(fire);
		resist.add(bug);
		resist.add(fairy);
		resist.add(ice);
		
		ArrayList<Type> weak = new ArrayList<Type>();
		weak.add(ground);
		weak.add(water);
		weak.add(rock);
		
		ArrayList<Type> immune = new ArrayList<Type>();
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(fire);
		
		Fighter arcanine = new Fighter("Arcanine", types, stats, weak, resist, immune, "/images/arcanine.png", "/images/arcanine_back.png");
		ArrayList<Double> arr = new ArrayList<Double>();
		while(arr.size() < 4) arr.add(0.0);
		Move move1 = new Move("Extreme Speed", normal, 80, arr);
		Move move2 = new Move("Play Rough", fairy, 90, arr);
		Move move3 = new Move("Flare Blitz", fire, 120, arr);
		ArrayList<Double> arr2 = new ArrayList<Double>();
		while(arr2.size() < 4) arr2.add(0.0);
		arr2.set(1, 0.33);
		Move move4 = new Move("Howl", normal, 0, arr2);
		arcanine.addMove(move1);
		arcanine.addMove(move2);
		arcanine.addMove(move3);
		arcanine.addMove(move4);
		return arcanine;
	}
}
