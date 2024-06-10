package fetch;

import jakarta.persistence.*;

@Entity
public class Pet {
	@Id  
    @GeneratedValue
    private int id;
    private String name;
    
	public Pet() {
	}

	public Pet(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
