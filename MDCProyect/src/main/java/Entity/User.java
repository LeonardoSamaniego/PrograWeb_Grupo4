package Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int u_id;
	
	@Column(name = "User Name", length = 100, nullable = false )
	private String u_Name;
	
	@Column(name = "User Email", length = 100, nullable = false )
	private String u_Email;
	
	@Column(name = "User Password", length = 100, nullable = false )
	private String u_Password;
	
	@Column(name = "User Type Document", nullable = false )
	private int u_TypeDoc;
	
	@Column(name = "User Document", length = 12, nullable = false )
	private String u_Document;
	
	@Column(name = "User Document", nullable = false )
	private String u_Type;

	public User() {
		super();
	}

	public User(int u_id, String u_Name, String u_Email, String u_Password,int u_TypeDoc, String u_Document, String u_Type) {
		super();
		this.u_id = u_id;
		this.u_Name = u_Name;
		this.u_Email = u_Email;
		this.u_Password = u_Password;
		this.u_TypeDoc = u_TypeDoc;
		this.u_Document = u_Document;
		this.u_Type = u_Type;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(u_Document, u_Email, u_Name, u_Password, u_Type, u_TypeDoc, u_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(u_Document, other.u_Document) && Objects.equals(u_Email, other.u_Email)
				&& Objects.equals(u_Name, other.u_Name) && Objects.equals(u_Password, other.u_Password)
				&& Objects.equals(u_Type, other.u_Type) && u_TypeDoc == other.u_TypeDoc && u_id == other.u_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_Name() {
		return u_Name;
	}

	public void setU_Name(String u_Name) {
		this.u_Name = u_Name;
	}

	public String getU_Email() {
		return u_Email;
	}

	public void setU_Email(String u_Email) {
		this.u_Email = u_Email;
	}

	public String getU_Password() {
		return u_Password;
	}

	public void setU_Password(String u_Password) {
		this.u_Password = u_Password;
	}

	public int getU_TypeDoc() {
		return u_TypeDoc;
	}

	public void setU_TypeDoc(int u_TypeDoc) {
		this.u_TypeDoc = u_TypeDoc;
	}

	public String getU_Document() {
		return u_Document;
	}

	public void setU_Document(String u_Document) {
		this.u_Document = u_Document;
	}

	public String getU_Type() {
		return u_Type;
	}

	public void setU_Type(String u_Type) {
		this.u_Type = u_Type;
	}





}
