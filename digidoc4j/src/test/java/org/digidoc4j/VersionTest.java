/* DigiDoc4J library
 *
 * This software is released under either the GNU Library General Public
 * License (see LICENSE.LGPL).
 *
 * Note that the only valid version of the LGPL license as far as this
 * project is concerned is the original GNU Library General Public License
 * Version 2.1, February 1999
 */

package org.digidoc4j;

import org.digidoc4j.test.util.PropertiesUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class VersionTest {

  @Test
  public void testVersion() {
    Properties properties = PropertiesUtil.getTestProperties();
    String expectedVersionString = properties.getProperty(PropertiesUtil.VERSION);

    Assert.assertEquals(expectedVersionString, Version.VERSION);
  }

}
