package aplikacja.db.operations;

import aplikacja.Konta;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
public class DatabaseOperation {

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;
	public static String txtProperty=null;
	public static String tekst=null;
	/* Method To Establish Database Connection */
	public static Connection getConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");     
			String db_url ="jdbc:mysql://localhost/konta",
					db_userName = "root",
					db_password = "";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}

	/* Method To Fetch The Student Records From Database */
	public static ArrayList<Konta> getAccountListFromDB() {
		ArrayList<Konta> accountList = new ArrayList<Konta>();
		if(txtProperty==null) {
			try {
				stmtObj = getConnection().createStatement();
				resultSetObj = stmtObj.executeQuery("select * from dane");
				while (resultSetObj.next()) {
					Konta stuObj = new Konta();
					stuObj.setId(resultSetObj.getInt("id_uzyt"));
					stuObj.setName(resultSetObj.getString("Nazwa"));
					stuObj.setPassword(resultSetObj.getString("Haslo"));
					stuObj.setType(resultSetObj.getString("typ"));
					stuObj.setActive(resultSetObj.getString("aktywne"));
					accountList.add(stuObj);
				}
				System.out.println("Total Records Fetched: " + accountList.size());
				connObj.close();
			} catch (Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		return accountList;

	}


	public static ArrayList<Konta> getSearchAccount() {
		ArrayList<Konta> accountList = new ArrayList<Konta>();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		 txtProperty = request.getParameter("myForm:szukaj");
		System.out.println(txtProperty);

		try {
			stmtObj = getConnection().createStatement();
			resultSetObj = stmtObj.executeQuery("select * from dane where  Nazwa like '"+txtProperty+"%' ");
			while(resultSetObj.next()) {
				Konta stuObj = new Konta();
				stuObj.setId(resultSetObj.getInt("id_uzyt"));
				stuObj.setName(resultSetObj.getString("Nazwa"));
				stuObj.setPassword(resultSetObj.getString("Haslo"));
				stuObj.setType(resultSetObj.getString("typ"));
				stuObj.setActive(resultSetObj.getString("aktywne"));
				accountList.add(stuObj);
			}
			System.out.println("Total Records Fetched: " + accountList.size());
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return accountList;
	}


    public static String updateAccountDetails(Konta updateAccountObj) {

		try {
			pstmt = getConnection().prepareStatement("update dane set Nazwa=?, Haslo=?, typ=?, aktywne=?  where id_uzyt=? ");
			pstmt.setString(1,updateAccountObj.getName());
			pstmt.setString(2,updateAccountObj.getPassword());
			pstmt.setString(3,updateAccountObj.getType());
			pstmt.setString(4,updateAccountObj.getActive());
			pstmt.setInt(5,updateAccountObj.getId());
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

		return "/admin.xhtml?faces-redirect=true";
	}


	public static String updateActive(Konta updateAccountObj) {
		String blokada=updateAccountObj.getActive();
		if(blokada.equals("Zablokuj")) { blokada="Odblokuj"; } else {blokada="Zablokuj";}
		try {
			pstmt = getConnection().prepareStatement("update dane set aktywne=?  where id_uzyt=? ");
			pstmt.setString(1,blokada);
			pstmt.setInt(2,updateAccountObj.getId());
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}

		return "/admin.xhtml?faces-redirect=true";
	}

	public static String Wysli_komunikat(String komunikat, int id) {
		try {
			pstmt = getConnection().prepareStatement("update dane set komunikat=? where id_uzyt=?");
			pstmt.setString(1,komunikat);
			pstmt.setInt(2,id);
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/admin.xhtml?faces-redirect=true";
	}


	public static String zmianahasla(int konto) {
		try {
			pstmt = getConnection().prepareStatement("update dane set zmien=? where id_uzyt=?");
			pstmt.setBoolean(1, true);
			pstmt.setInt(2, konto);
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/admin.xhtml?faces-redirect=true";
	}


	public static String deleteAccount(int konto) {
		System.out.println("deleteStudentRecordInDB() : Konto Id: " + konto);
		try {
			pstmt = getConnection().prepareStatement("delete from dane where id_uzyt = " + konto);
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/admin.xhtml?faces-redirect=true";
	}
}