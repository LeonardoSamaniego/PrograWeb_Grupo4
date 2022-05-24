package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Purchase")
public class Purchase implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pu_id;
	
	@Column(name = "Purchase Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pu_date;
	
	@ManyToOne
	@JoinColumn(name = "Purchase User Id", nullable = false)
	private User user_u_id;
	
	@Column(name = "Purchase Amount", length = 2, nullable = false )
	private float pu_Amount;
	
	@Column(name = "Purchase Adress", length = 100, nullable = false )
	private String pu_Adress;
	
	@Column(name = "Purchase Method", length = 100, nullable = false )
	private String pu_Method;

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(pu_Adress, pu_Amount, pu_Method, pu_date, pu_id, user_u_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(pu_Adress, other.pu_Adress)
				&& Float.floatToIntBits(pu_Amount) == Float.floatToIntBits(other.pu_Amount)
				&& Objects.equals(pu_Method, other.pu_Method) && Objects.equals(pu_date, other.pu_date)
				&& pu_id == other.pu_id && Objects.equals(user_u_id, other.user_u_id);
	}

	public int getPu_id() {
		return pu_id;
	}

	public void setPu_id(int pu_id) {
		this.pu_id = pu_id;
	}

	public Date getPu_date() {
		return pu_date;
	}

	public void setPu_date(Date pu_date) {
		this.pu_date = pu_date;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getUser_u_id() {
		return user_u_id;
	}

	public void setUser_u_id(User user_u_id) {
		this.user_u_id = user_u_id;
	}

	public float getPu_Amount() {
		return pu_Amount;
	}

	public void setPu_Amount(float pu_Amount) {
		this.pu_Amount = pu_Amount;
	}

	public String getPu_Adress() {
		return pu_Adress;
	}

	public void setPu_Adress(String pu_Adress) {
		this.pu_Adress = pu_Adress;
	}

	public String getPu_Method() {
		return pu_Method;
	}

	public void setPu_Method(String pu_Method) {
		this.pu_Method = pu_Method;
	}
	
	

	
}
