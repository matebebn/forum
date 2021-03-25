package aplikacja;

import aplikacja.db.operations.DatabaseOperation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

@ManagedBean @RequestScoped
public class Konta {

	private int id;  
	private String name;  
	private String password;
	private String type;
	private String active;
	private String komunikat;


	public ArrayList<Konta> accountList;

	public String getKomunikat() {
		return komunikat;
	}

	public void setKomunikat(String komunikat) {
		this.komunikat = komunikat;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}


	
	/* Method Will Avoid Multiple Calls To DB For Fetching The Students Records. If This Is Not Used & Data Is Fetched From Getter Method, JSF DataTable Will Make Multiple Calls To DB*/
	@PostConstruct
	public void init() {
		accountList = DatabaseOperation.getAccountListFromDB();
	}

	/* Method Used To Fetch All Records From The Database */
	public ArrayList<Konta> accList() {
		return accountList;
	}


	public String updateStudentDetails(Konta updateAccountObj) {
		return DatabaseOperation.updateAccountDetails(updateAccountObj);
	}

	public String updateActive(Konta updateAccountObj) {
		return DatabaseOperation.updateActive(updateAccountObj);
	}

	public void searchAccount() {
		accountList = DatabaseOperation.getSearchAccount();

	}

	public String wymus_zmiane(int konto) { return DatabaseOperation.zmianahasla(konto); }

	public String deleteAcc(int konto) { return DatabaseOperation.deleteAccount(konto); }

	public String Komunikat(String komunikat, int studentId){ return DatabaseOperation.Wysli_komunikat(komunikat,studentId);}

}