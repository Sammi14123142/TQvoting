package bean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@ManagedBean
@RequestScoped
@Entity
@NamedQueries({
	@NamedQuery(name="Applicant.findAllOrderByScore",
			query = "select c from Applicant c group by c.name order by c.technique+c.personality+c.stage desc"),
	@NamedQuery(name="Applicant.findPopular",
	query = "select c from Applicant c group by c.name order by c.vote desc"),
	@NamedQuery(name="Applicant.findAll",
	query = "select c from Applicant c"),
	@NamedQuery(name="Applicant.findById",
    query = "select c from Applicant c where c.id = :id"),
})
public class Applicant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@Column(name="song")
	private String song;
	
	@Column(name="technique")
	private int technique;

	@Column(name="personality")
	private int personality;
	
	@Column(name="stage")
	private int stage;
	
	@Column(name="vote")
	private int vote;
	
	public boolean isValidScore() {
		return technique <= 45 && personality <= 35 && stage <= 20;
	}
	
	public int getTechnique() {
		return technique;
	}

	public void setTechnique(int technique) {
		this.technique = technique;
	}

	public int getPersonality() {
		return personality;
	}

	public void setPersonality(int personality) {
		this.personality = personality;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
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

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

}
