/* DigiDoc4J library
*
* This software is released under either the GNU Library General Public
* License (see LICENSE.LGPL).
*
* Note that the only valid version of the LGPL license as far as this
* project is concerned is the original GNU Library General Public License
* Version 2.1, February 1999
*/

package org.digidoc4j.utils;

import org.apache.commons.io.FileUtils;
import org.digidoc4j.DigestAlgorithm;
import org.digidoc4j.signers.PKCS12SignatureToken;
import org.digidoc4j.test.util.TestSigningUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class TokenAlgorithmSupportTest {

  @Test
  public void getDefaultDigestAlgorithm_shouldReturnSha256() throws Exception {
    PKCS12SignatureToken testSignatureToken = new PKCS12SignatureToken(TestSigningUtil.TEST_PKI_CONTAINER, TestSigningUtil.TEST_PKI_CONTAINER_PASSWORD.toCharArray());
    DigestAlgorithm digestAlgorithm = TokenAlgorithmSupport.determineSignatureDigestAlgorithm(testSignatureToken.getCertificate());
    Assert.assertEquals(DigestAlgorithm.SHA256, digestAlgorithm);
  }

  @Test
  public void oldEstonianIdCardCert_shouldReturnSha224() throws Exception {
    String certString = FileUtils.readFileToString(new File("src/test/resources/testFiles/certs/esteid-pre2011-test-signing-certificate-37101010021.cer"), StandardCharsets.UTF_8);
    DigestAlgorithm digestAlgorithm = TokenAlgorithmSupport.determineSignatureDigestAlgorithm(TestSigningUtil.toX509Certificate(certString));
    Assert.assertEquals(DigestAlgorithm.SHA224, digestAlgorithm);
  }

}
