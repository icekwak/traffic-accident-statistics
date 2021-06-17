package region;

public class regionBean {
	private String id;
	private int accident;
	private int death;
	private int injured;
	
	public regionBean() {
		id = "";
		accident = 0;
		death = 0;
		injured = 0;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAccident() {
		return accident;
	}
	public void setAccident(int accident) {
		this.accident = accident;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public int getInjured() {
		return injured;
	}
	public void setInjured(int injured) {
		this.injured = injured;
	}
}