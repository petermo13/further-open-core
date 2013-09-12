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
package edu.utah.further.fqe.ds.model.common.service.results;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Service;

import edu.utah.further.core.api.exception.ApplicationException;
import edu.utah.further.core.query.domain.SearchQuery;
import edu.utah.further.fqe.ds.api.service.results.ResultService;
import edu.utah.further.fqe.ds.api.service.results.ResultType;

/**
 * ...
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
 * @version Sep 9, 2013
 */
@Service("resultService")
public class ResultServiceImpl implements ResultService
{

	/**
	 * 
	 */
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.utah.further.fqe.ds.api.results.ResultService#join(java.util.List,
	 * edu.utah.further.fqe.ds.api.results.ResultType, java.lang.Integer)
	 */
	@Override
	public Long join(final List<String> queryIds, final ResultType resultType,
			final Integer intersectionIndex)
	{
		if (queryIds == null || queryIds.size() == 0)
		{
			throw new ApplicationException("Missing query identifiers");
		}

		long result = 0;

		switch (resultType)
		{
			case SUM:
			{
				result = jdbcTemplate.queryForLong(
						"SELECT COUNT(*) FROM virtual_obj_id_map WHERE query_id IN :ids",
						Collections.singletonMap("ids", queryIds));
				break;
			}

			case INTERSECTION:
			{
				if (intersectionIndex == null)
				{
					throw new ApplicationException(
							"Missing parameter to intersect queries");
				}

				if (intersectionIndex.intValue() == 1)
				{
					result = jdbcTemplate.queryForLong(
							"SELECT COUNT(distinct fed_obj_id) "
									+ "FROM virtual_obj_id_map WHERE query_id IN :ids",
							Collections.singletonMap("ids", queryIds));
					break;
				}

				final Map<String, Object> args = new HashMap<>();
				args.put("ids", queryIds);
				args.put("intersectionIndex", intersectionIndex);
				result = jdbcTemplate.queryForLong(
						"SELECT COUNT(fed_obj_id) FROM virtual_obj_id_map "
								+ "WHERE query_id IN :ids GROUP BY fed_obj_id "
								+ "HAVING COUNT(fed_obj_id) >= :intersectionIndex", args);

			}

			default:
				throw new ApplicationException("Unknown result type: " + resultType);
		}

		return new Long(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.utah.further.fqe.ds.api.results.ResultService#join(java.util.List,
	 * java.lang.String, edu.utah.further.fqe.ds.api.results.ResultType, int)
	 */
	@Override
	public Map<String, Long> join(final List<String> queryIds,
			final String attributeName, final ResultType resultType,
			final int intersectionIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.utah.further.fqe.ds.api.results.ResultService#getQueryResultIdentifiers(java
	 * .util.List)
	 */
	@Override
	public List<Long> getQueryResultIdentifiers(final List<String> queryIds)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.utah.further.fqe.ds.api.results.ResultService#getQueryResults(java.util.List)
	 */
	@Override
	public <T> List<T> getQueryResults(final List<String> queryIds)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.utah.further.fqe.ds.api.results.ResultService#getQueryResults(edu.utah.further
	 * .core.query.domain.SearchQuery)
	 */
	@Override
	public <T> List<T> getQueryResults(final SearchQuery query)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return the jdbcTemplate property.
	 * 
	 * @return the jdbcTemplate
	 */
	public SimpleJdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	/**
	 * Set a new value for the jdbcTemplate property.
	 * 
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(final SimpleJdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

}
