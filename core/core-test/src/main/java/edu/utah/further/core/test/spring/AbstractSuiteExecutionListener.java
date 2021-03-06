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
package edu.utah.further.core.test.spring;


/**
 * A stub implementation of {@link TSuiteExecutionListener}.
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2013 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Oren E. Livne {@code <oren.livne@utah.edu>}
 * @version Oct 21, 2009
 */
public abstract class AbstractSuiteExecutionListener implements TSuiteExecutionListener
{
	// ========================= IMPLEMENTATION: SuiteExecutionListener ====

	/**
	 * Runs before all tests in the fixture.
	 *
	 * @param suiteContext
	 *            the suite context in which the test method will be executed (never
	 *            <code>null</code>)
	 * @throws Exception
	 *             allows any exception to propagate
	 * @see edu.utah.further.core.test.spring.TSuiteExecutionListener#beforeClass(edu.utah.further.core.test.spring.TSuiteContext)
	 */
	@Override
	public void beforeClass(final TSuiteContext suiteContext) throws Exception
	{
		// Method stub
	}

	/**
	 * Runs before all tests in the fixture.
	 *
	 * @param suiteContext
	 *            the suite context in which the test method will be executed (never
	 *            <code>null</code>)
	 * @throws Exception
	 *             allows any exception to propagate
	 * @see edu.utah.further.core.test.spring.TSuiteExecutionListener#afterClass(edu.utah.further.core.test.spring.TSuiteContext)
	 */
	@Override
	public void afterClass(final TSuiteContext suiteContext) throws Exception
	{
		// Method stub
	}
}
