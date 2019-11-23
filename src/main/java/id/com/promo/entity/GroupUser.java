package id.com.promo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "group_user")
public class GroupUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "group_name")
	private String name;
	
	@Column(name = "group_id")
	private Integer groupID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_promo_id", nullable = false)
	private ModulePromo modulePromo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupID() {
		return groupID;
	}

	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	public ModulePromo getModulePromo() {
		return modulePromo;
	}

	public void setModulePromo(ModulePromo modulePromo) {
		this.modulePromo = modulePromo;
	}

	@Override
	public String toString() {
		return "GroupUser [id=" + id + ", name=" + name + "]";
	}

}
