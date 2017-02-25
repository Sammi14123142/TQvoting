package service_bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import bean.Applicant;
import service.ApplicantService;

@ManagedBean(name="applicantServiceBean")
@RequestScoped
public class ApplicantServiceBean {
	
	private ApplicantService applicantService ;
	
	@ManagedProperty(value="#{emFactoryBean}")
	private EntityManagerFactoryBean factoryBean;
	
	@ManagedProperty(value="#{applicant}")
	private Applicant applicant;

	private String errMsg= null;

	@PostConstruct
	public void init() {
		applicantService = new ApplicantService(factoryBean);
	}
	
	public void setFactoryBean(EntityManagerFactoryBean factoryBean) {
		this.factoryBean = factoryBean;
	}	
	
	public int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
		
	public List<Applicant> getApplicants() {
		return applicantService.getApplicants();
	}
	
	public List<Applicant> getApplicantsOrdered() {
		return applicantService.getApplicantsOrdered();
	}
	
	public String editScore1() {
        applicantService.update(applicant);
        System.out.println(applicant);
        return "listApplicant1.xhtml";
    }
		
	public void findApplicantById() {
		Applicant item = applicantService.findById(id).get(0);
		applicant = item;
		System.out.println(applicant);
    }


}
