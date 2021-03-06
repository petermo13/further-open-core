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
package edu.utah.further.ds.omop.model.v2.domain;

import java.math.BigDecimal;
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

import edu.utah.further.core.api.data.PersistentEntity;

/**
 * The persistent class for the DRUG_EXPOSURE database table.
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2013 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 * 
 * @author N. Dustin Schultz {@code <dustin.schultz@utah.edu>}
 * @version Apr 24, 2013
 */
@Entity
@Table(name = "DRUG_EXPOSURE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DrugExposure implements PersistentEntity<Long>
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DRUG_EXPOSURE_ID")
	private Long drugExposureId;

	@Column(name = "DAYS_SUPPLY")
	private BigDecimal daysSupply;

	@Column(name = "DRUG_CONCEPT_ID")
	private BigDecimal drugConceptId;

	@Temporal(TemporalType.DATE)
	@Column(name = "DRUG_EXPOSURE_END_DATE")
	private Date drugExposureEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "DRUG_EXPOSURE_START_DATE")
	private Date drugExposureStartDate;

	@Column(name = "DRUG_QUANTITY")
	private BigDecimal drugQuantity;

	private BigDecimal refills;

	@Column(name = "SOURCE_DRUG_CODE")
	private String sourceDrugCode;

	@Column(name = "STOP_REASON")
	private String stopReason;

	// bi-directional many-to-one association to DrugExposureRef
	@ManyToOne
	@JoinColumn(name = "DRUG_EXPOSURE_TYPE")
	private DrugExposureRef drugExposureRef;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	public DrugExposure()
	{
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.utah.further.core.api.discrete.HasIdentifier#getId()
	 */
	@Override
	public Long getId()
	{
		return this.drugExposureId;
	}

	protected void setId(final Long drugExposureId)
	{
		this.drugExposureId = drugExposureId;
	}

	public BigDecimal getDaysSupply()
	{
		return this.daysSupply;
	}

	public void setDaysSupply(final BigDecimal daysSupply)
	{
		this.daysSupply = daysSupply;
	}

	public BigDecimal getDrugConceptId()
	{
		return this.drugConceptId;
	}

	public void setDrugConceptId(final BigDecimal drugConceptId)
	{
		this.drugConceptId = drugConceptId;
	}

	public Date getDrugExposureEndDate()
	{
		return this.drugExposureEndDate;
	}

	public void setDrugExposureEndDate(final Date drugExposureEndDate)
	{
		this.drugExposureEndDate = drugExposureEndDate;
	}

	public Date getDrugExposureStartDate()
	{
		return this.drugExposureStartDate;
	}

	public void setDrugExposureStartDate(final Date drugExposureStartDate)
	{
		this.drugExposureStartDate = drugExposureStartDate;
	}

	public BigDecimal getDrugQuantity()
	{
		return this.drugQuantity;
	}

	public void setDrugQuantity(final BigDecimal drugQuantity)
	{
		this.drugQuantity = drugQuantity;
	}

	public BigDecimal getRefills()
	{
		return this.refills;
	}

	public void setRefills(final BigDecimal refills)
	{
		this.refills = refills;
	}

	public String getSourceDrugCode()
	{
		return this.sourceDrugCode;
	}

	public void setSourceDrugCode(final String sourceDrugCode)
	{
		this.sourceDrugCode = sourceDrugCode;
	}

	public String getStopReason()
	{
		return this.stopReason;
	}

	public void setStopReason(final String stopReason)
	{
		this.stopReason = stopReason;
	}

	public DrugExposureRef getDrugExposureRef()
	{
		return this.drugExposureRef;
	}

	public void setDrugExposureRef(final DrugExposureRef drugExposureRef)
	{
		this.drugExposureRef = drugExposureRef;
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