package sys5867.ist_project.p2p_stations;

public class Velo {
	private int velo_id;
	private String velo_name;
	private int velo_score;
	
	public Velo(int id) {
		this.velo_id = id;
		this.velo_name = String.valueOf(id);
		this.velo_score = 0;
	}
	public Velo(int id, String name) {
		this.velo_id = id;
		this.velo_name = new String(name);
		this.velo_score = 0;
	}
}
