package sys5867.ist_project.p2p_stations;

import java.util.ArrayList;
import java.util.List;

public class Station {
	private String station_name;
	private List<Storage> station = new ArrayList<Storage>();
	
	public Station(String name, int size) {
		this.station_name = new String(name);
		for(int i = 0; i < size; i++) {
			this.station.add(new Storage(this.station_name + String.valueOf(i)));
		}
	}
	
	public Velo getVeloId(int id) {
		Velo try_get = this.station.get(id).popVelo();
		if(try_get == null) {
			return null;
		}
		else{
			return try_get;
		}
	}
}
