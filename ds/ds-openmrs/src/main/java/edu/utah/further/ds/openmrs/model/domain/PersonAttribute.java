/**
 * Copyright (C) [2013] [The FURTHeR Project]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.utah.further.ds.openmrs.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the person_attribute database table.
 * 
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2012 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 * 
 * @author N. Dustin Schultz {@code <dustin.schultz@utah.edu>}
 * @version Sep 3, 2013
 */
@Entity
@Table(name = "person_attribute")
@XmlRootElement(name = "PersonAttribute")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonAttribute implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "person_attribute_id")
	private int personAttributeId;

	@Column(name = "changed_by")
	private int changedBy;

	private int creator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_changed")
	private Date dateChanged;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_voided")
	private Date dateVoided;

	private String uuid;

	private String value;

	@Column(name = "void_reason")
	private String voidReason;

	private byte voided;

	@Column(name = "voided_by")
	private int voidedBy;

	// bi-directional many-to-one association to PersonAttributeType
	@ManyToOne
	@JoinColumn(name = "person_attribute_type_id")
	private PersonAttributeType personAttributeType;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "person_id")
	@XmlTransient
	private Person person;

	public PersonAttribute()
	{
	}

	public int getPersonAttributeId()
	{
		return this.personAttributeId;
	}

	public void setPersonAttributeId(final int personAttributeId)
	{
		this.personAttributeId = personAttributeId;
	}

	public int getChangedBy()
	{
		return this.changedBy;
	}

	public void setChangedBy(final int changedBy)
	{
		this.changedBy = changedBy;
	}

	public int getCreator()
	{
		return this.creator;
	}

	public void setCreator(final int creator)
	{
		this.creator = creator;
	}

	public Date getDateChanged()
	{
		return this.dateChanged;
	}

	public void setDateChanged(final Date dateChanged)
	{
		this.dateChanged = dateChanged;
	}

	public Date getDateCreated()
	{
		return this.dateCreated;
	}

	public void setDateCreated(final Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	public Date getDateVoided()
	{
		return this.dateVoided;
	}

	public void setDateVoided(final Date dateVoided)
	{
		this.dateVoided = dateVoided;
	}

	public PersonAttributeType getPersonAttributeType()
	{
		return this.personAttributeType;
	}

	public void setPersonAttributeType(final PersonAttributeType personAttributeType)
	{
		this.personAttributeType = personAttributeType;
	}

	public String getUuid()
	{
		return this.uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getValue()
	{
		return this.value;
	}

	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getVoidReason()
	{
		return this.voidReason;
	}

	public void setVoidReason(final String voidReason)
	{
		this.voidReason = voidReason;
	}

	public byte getVoided()
	{
		return this.voided;
	}

	public void setVoided(final byte voided)
	{
		this.voided = voided;
	}

	public int getVoidedBy()
	{
		return this.voidedBy;
	}

	public void setVoidedBy(final int voidedBy)
	{
		this.voidedBy = voidedBy;
	}

	public Person getPerson()
	{
		return this.person;
	}

	public void setPerson(final Person person)
	{
		this.person = person;
	}

}