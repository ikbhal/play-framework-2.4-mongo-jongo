package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Friend {
	
	@JsonProperty("_id")
    public String id;
	public String name;
}
