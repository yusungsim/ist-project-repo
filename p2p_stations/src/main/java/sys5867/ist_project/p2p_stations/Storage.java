package sys5867.ist_project.p2p_stations;

import java.util.Optional;

public class Storage {
	private String storage_id;
	private Velo store;
	private boolean stored;
	
	public Storage(String id) {
		this.storage_id = new String(id);
		this.store = null;
		this.stored = false;
	}
	
	public void pushVelo(Velo v) {
		this.store = v;
	}
	
	public Velo popVelo() {
		if(this.stored) {
			return this.store;
		}
		else {
			System.out.println("No velo stored in storage no. " + this.storage_id);
			return null;
		}
	}
}
