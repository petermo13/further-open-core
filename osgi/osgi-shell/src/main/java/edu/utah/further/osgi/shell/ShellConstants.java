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
package edu.utah.further.osgi.shell;

/**
 * Centralizes useful utilities, e.g. collection factory methods.
 * <p>
 * Repeats some code from <code>core-api</code>, but we would like to keep this module
 * decoupled from the FURTHeR code for broader reusability.
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2010 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Oren E. Livne {@code <oren.livne@utah.edu>}</code>
 * @version Mar 8, 2010
 */
abstract class ShellConstants
{
	// ========================= CONSTANTS =================================

	/**
	 * Assumed size of visible shell console screen [characters].
	 */
	public static final int SCREEN_WIDTH = 100;

	/**
	 * Column delimiter in multi-column views.
	 */
	public static final String COLUMN_DELIMITER = "     ";
}
