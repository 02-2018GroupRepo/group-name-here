package hello;

import java.util.Map;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Machine {
	
	protected String companyName;
	protected String machineType;
	protected String location;
	protected String id;
	protected double total;
	protected CoinManager coinManager;
	
	
	public double getMachineTotal() {
		return this.total;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public String getMachineType() {
		return this.machineType;
	}

	public String getId() {
		return id;
	}

	
	

}
