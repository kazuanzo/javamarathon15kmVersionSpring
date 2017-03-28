package javamarathon15km.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="shops")
@NamedQueries({
@NamedQuery(name = "findByShops", query = "from Shops where color = :color and gender= :gender"),
@NamedQuery(name = "findSelectColor",query="select color from Shops where gender= :gender")})
public class Shops {
	
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "size")
	private String size;

	


}
