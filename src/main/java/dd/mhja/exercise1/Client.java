package dd.mhja.exercise1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clients")
public class Client {
	
	@Id
	@Column(name = "client_id")
	private int id;

	@Column(name = "name")
	private String name;

	public Client() {}

	public Client(int id, String name) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return String.format("Client: id= %s - name= %s \n", id, name);
	}
	
}
