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
			query = "select c from Applicant c group by c.name order by c.technique1+c.technique2+c.personality1+c.personality2+c.stage1+c.stage2 desc"),
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
	
	@Column(name="technique1")
	private int technique1;
	
	@Column(name="technique2")
	private int technique2;
	
	@Column(name="personality1")
	private int personality1;
	
	@Column(name="personality2")
	private int personality2;
	
	@Column(name="stage1")
	private int stage1;
	
	public int getTechnique1() {
		return technique1;
	}

	public void setTechnique1(int technique1) {
		this.technique1 = technique1;
	}

	public int getTechnique2() {
		return technique2;
	}

	public void setTechnique2(int technique2) {
		this.technique2 = technique2;
	}

	public int getPersonality1() {
		return personality1;
	}

	public void setPersonality1(int personality1) {
		this.personality1 = personality1;
	}

	public int getPersonality2() {
		return personality2;
	}

	public void setPersonality2(int personality2) {
		this.personality2 = personality2;
	}

	public int getStage1() {
		return stage1;
	}

	public void setStage1(int stage1) {
		this.stage1 = stage1;
	}

	public int getStage2() {
		return stage2;
	}

	public void setStage2(int stage2) {
		this.stage2 = stage2;
	}

	@Column(name="stage2")
	private int stage2;
	
	@Column(name="finalScore")
	private int finalScore;	

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

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

}
