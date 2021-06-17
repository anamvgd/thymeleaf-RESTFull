package com.exercise.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.exercise.taller1.validations.UserrSelectAddValidation;
import com.exercise.taller1.validations.UserrSelectEditValidation;


/**
 * The persistent class for the USERSELECT database table.
 * 
 */
@Entity
@NamedQuery(name="Userselect.findAll", query="SELECT u FROM Userselect u")
public class Userselect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERSELECT_USSELID_GENERATOR", sequenceName="USERSELECT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERSELECT_USSELID_GENERATOR")
	@Column(name="USSEL_ID")
	private long usselId;

	@Column(name="USSEL_TABLENAME")
	@NotNull(groups = {UserrSelectAddValidation.class})
	@NotNull(groups = {UserrSelectEditValidation.class})
	@Size(min = 5, max = 18, groups = { UserrSelectAddValidation.class})
	@Size(min = 5, max = 18, groups = { UserrSelectEditValidation.class})
	private String usselTablename;

	@Column(name="USSEL_VALUEKEYCOLUMN")
	@NotNull(groups = {UserrSelectAddValidation.class, UserrSelectEditValidation.class})
	@Size(min = 5, max = 18, groups = { UserrSelectAddValidation.class, UserrSelectEditValidation.class })
	private String usselValuekeycolumn;

	@Column(name="USSEL_VALUEUSERCOLUMN")
	@NotNull(groups = {UserrSelectAddValidation.class, UserrSelectEditValidation.class})
	@Size(min = 5, max = 18, groups = { UserrSelectAddValidation.class, UserrSelectEditValidation.class })
	private String usselValueusercolumn;

	@Column(name="USSEL_WHERESTATEMENT")
	@NotNull(groups = {UserrSelectAddValidation.class, UserrSelectEditValidation.class})
	@Size(min = 5, max = 18, groups = { UserrSelectAddValidation.class, UserrSelectEditValidation.class })
	private String usselWherestatement;

	//bi-directional many-to-one association to Triggerr
	@ManyToOne
	@JoinColumn(name="TRIG_TRIG_ID")
	private Triggerr triggerr;

	public Userselect() {
	}

	public long getUsselId() {
		return this.usselId;
	}

	public void setUsselId(long usselId) {
		this.usselId = usselId;
	}

	public String getUsselTablename() {
		return this.usselTablename;
	}

	public void setUsselTablename(String usselTablename) {
		this.usselTablename = usselTablename;
	}

	public String getUsselValuekeycolumn() {
		return this.usselValuekeycolumn;
	}

	public void setUsselValuekeycolumn(String usselValuekeycolumn) {
		this.usselValuekeycolumn = usselValuekeycolumn;
	}

	public String getUsselValueusercolumn() {
		return this.usselValueusercolumn;
	}

	public void setUsselValueusercolumn(String usselValueusercolumn) {
		this.usselValueusercolumn = usselValueusercolumn;
	}

	public String getUsselWherestatement() {
		return this.usselWherestatement;
	}

	public void setUsselWherestatement(String usselWherestatement) {
		this.usselWherestatement = usselWherestatement;
	}

	public Triggerr getTriggerr() {
		return this.triggerr;
	}

	public void setTriggerr(Triggerr triggerr) {
		this.triggerr = triggerr;
	}

}