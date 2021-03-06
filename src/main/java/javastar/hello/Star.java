package javastar.hello;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "stars", schema = "hello")
public class Star {

	@Id
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 255, message = "Minimum is 3 characters and maximum is 255")
	private String name;
	
	@NotBlank(message = "Email is required")
	@Size(min = 3, max = 255, message = "Minimum is 3 characters and maximum is 255")
	@Email(message = "Not a valid email address")
	private String email;
	
	@NotBlank(message = "Phone is required")
	@Pattern(regexp = "[0-9\\+]+", message = "Not a valid phone number. Use only numbers and +")
	@Size(min = 5, max = 10, message = "Minimum is 3 characters and maximum is 10")
	private String phone;
	
	@Version
	@DateTimeFormat(pattern = "yyyy.MMM.dd.HH.mm.ss.SSS")
	private Date updateDate;

	
	@ManyToMany
	@JoinTable(
			name = "star_skills", catalog = "hello",
			joinColumns = @JoinColumn(name = "star_name"),
			inverseJoinColumns = @JoinColumn(name = "skill_id")
	)
	private Set<Skill> skills;
	
	@Override
	public String toString() {
		return "Star [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Star other = (Star) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Set<Skill> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
}
