package com.joe.entity.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Range;

import com.joe.entity.IdEntity;

/** 
 * 	
 */
@Entity
@Table(name="security_organization_role")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.joe.entity.main")
public class OrganizationRole extends IdEntity {

	/** 描述  */
	private static final long serialVersionUID = -2216187629501296831L;

	/**
	 * 值越小，优先级越高
	 */
	@NotNull
	@Range(min=1, max=99)
	@Column(length=2, nullable=false)
	private Integer priority = 99;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	private Role role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organizationId")
	private Organization organization;

	/**  
	 * 返回 role 的值   
	 * @return role  
	 */
	public Role getRole() {
		return role;
	}

	/**  
	 * 设置 role 的值  
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**  
	 * 返回 priority 的值   
	 * @return priority  
	 */
	public Integer getPriority() {
		return priority;
	}

	/**  
	 * 设置 priority 的值  
	 * @param priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}
