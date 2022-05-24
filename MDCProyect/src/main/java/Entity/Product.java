package Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	
	@Column(name = "Product Name", length = 100, nullable = false )
	private String p_Name;
	
	@Column(name = "Product Brand", length = 100, nullable = false )
	private String p_Brand;
	
	@Column(name = "Product Size", length = 2, nullable = false )
	private String p_Size;
	
	@Column(name = "Product Category",length = 100, nullable = false )
	private String p_cate;
	
	@Column(name = "Product Type", length = 100, nullable = false )
	private String p_Type;
	
	@Column(name = "Product Color", length = 10,nullable = false )
	private String p_color;

	@Column(name = "Product Gender", length = 10,nullable = false )
	private String p_gender;

	public Product() {
		super();
	}	
	
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	public String getP_Brand() {
		return p_Brand;
	}

	public void setP_Brand(String p_Brand) {
		this.p_Brand = p_Brand;
	}

	public String getP_Size() {
		return p_Size;
	}

	public void setP_Size(String p_Size) {
		this.p_Size = p_Size;
	}

	public String getP_cate() {
		return p_cate;
	}

	public void setP_cate(String p_cate) {
		this.p_cate = p_cate;
	}

	public String getP_Type() {
		return p_Type;
	}

	public void setP_Type(String p_Type) {
		this.p_Type = p_Type;
	}

	public String getP_color() {
		return p_color;
	}

	public void setP_color(String p_color) {
		this.p_color = p_color;
	}

	public String getP_gender() {
		return p_gender;
	}

	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}

	
}
