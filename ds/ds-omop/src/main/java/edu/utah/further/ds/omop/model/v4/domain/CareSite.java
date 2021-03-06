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
package edu.utah.further.ds.omop.model.v4.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import edu.utah.further.core.api.data.PersistentEntity;

/**
 * The persistent class for the CARE_SITE database table.
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
 * @version Apr 17, 2013
 */
@Entity
@Table(name = "CARE_SITE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CareSite implements PersistentEntity<Long>
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CARE_SITE_ID", unique = true, nullable = false)
	private Long careSiteId;

	@Column(name = "CARE_SITE_SOURCE_VALUE", nullable = false, length = 50)
	private String careSiteSourceValue;

	@Column(name = "LOCATION_ID")
	private BigDecimal locationId;

	@Column(name = "ORGANIZATION_ID")
	private BigDecimal organizationId;

	@Column(name = "PLACE_OF_SERVICE_CONCEPT_ID")
	private BigDecimal placeOfServiceConceptId;

	@Column(name = "PLACE_OF_SERVICE_SOURCE_VALUE", length = 50)
	private String placeOfServiceSourceValue;

	/**
	 * Default constructor
	 */
	public CareSite()
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
		return this.careSiteId;
	}

	public String getCareSiteSourceValue()
	{
		return this.careSiteSourceValue;
	}

	public void setCareSiteSourceValue(final String careSiteSourceValue)
	{
		this.careSiteSourceValue = careSiteSourceValue;
	}

	public BigDecimal getLocationId()
	{
		return this.locationId;
	}

	public void setLocationId(final BigDecimal locationId)
	{
		this.locationId = locationId;
	}

	public BigDecimal getOrganizationId()
	{
		return this.organizationId;
	}

	public void setOrganizationId(final BigDecimal organizationId)
	{
		this.organizationId = organizationId;
	}

	public BigDecimal getPlaceOfServiceConceptId()
	{
		return this.placeOfServiceConceptId;
	}

	public void setPlaceOfServiceConceptId(final BigDecimal placeOfServiceConceptId)
	{
		this.placeOfServiceConceptId = placeOfServiceConceptId;
	}

	public String getPlaceOfServiceSourceValue()
	{
		return this.placeOfServiceSourceValue;
	}

	public void setPlaceOfServiceSourceValue(final String placeOfServiceSourceValue)
	{
		this.placeOfServiceSourceValue = placeOfServiceSourceValue;
	}

}