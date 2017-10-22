package domain;

public class Game {
	private String name;
	
	
	Game(){};
	
	Game(String name){
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return this.getName();
	}
}
