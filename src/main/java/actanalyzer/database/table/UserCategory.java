package actanalyzer.database.table;

import javax.persistence.*;

@Entity
@Table(name = "usuario_categoria")
public class UserCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_categoria")
	private Long idCategory;
	
	@Column(name = "id_usuario")
	private Long idUser;
	
	@Column(name = "times_searched")
	private int timesSearched;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public int getTimesSearched() {
		return timesSearched;
	}

	public void setTimesSearched(int timesSearched) {
		this.timesSearched = timesSearched;
	}
	
}
