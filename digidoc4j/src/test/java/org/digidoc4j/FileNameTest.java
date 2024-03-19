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

import java.io.File;
import java.io.FileInputStream;

import eu.europa.esig.dss.enumerations.MimeTypeEnum;
import org.digidoc4j.exceptions.InvalidDataFileException;
import org.digidoc4j.utils.Helper;
import org.junit.Assert;
import org.junit.Test;

public class FileNameTest extends AbstractTest {

  @Test(expected = InvalidDataFileException.class)
  public void createContainerWithSpecialCharactersInFileName() throws Exception {
    File folder = this.testFolder.newFolder("tmp");
    try (FileInputStream stream = new FileInputStream("src/test/resources/testFiles/special-char-files/dds_acrobat.pdf")) {
      Container container = ContainerBuilder.aContainer().withDataFile(stream,
          "xxx,%2003:1737,%2031.08.2015.a.pdf", MimeTypeEnum.PDF.getMimeTypeString())
          .usingTempDirectory(folder.getPath()).build();
      String file = this.getFileBy("bdoc");
      container.saveAsFile(file);
      Assert.assertFalse(new File(file).exists());
    }
  }

  @Test
  public void createContainer() throws Exception {
    File folder = this.testFolder.newFolder("tmp");
    try (FileInputStream stream = new FileInputStream("src/test/resources/testFiles/special-char-files/dds_acrobat.pdf")) {
      Container container = ContainerBuilder.aContainer().withDataFile(stream, "cgi.pdf", MimeTypeEnum.PDF.getMimeTypeString())
          .usingTempDirectory(folder.getPath()).build();
      String file = this.getFileBy("bdoc");
      container.saveAsFile(file);
      Assert.assertTrue(new File(file).exists());
    }
  }

  @Test
  public void validateSpecialialCharacters() throws Exception {
    String fileName = "test.txt";
    Assert.assertFalse(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersLessThanEnd() throws Exception {
    String fileName = "test<.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersLessThanStart() throws Exception {
    String fileName = "<test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersLessThanMidle() throws Exception {
    String fileName = "te<st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersGreaterThanEnd() throws Exception {
    String fileName = "test>.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersGreaterThanStart() throws Exception {
    String fileName = ">test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersGreaterThanMidle() throws Exception {
    String fileName = "te>st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharacterColonEnd() throws Exception {
    String fileName = "test:.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersColonStart() throws Exception {
    String fileName = ":test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersColonMidle() throws Exception {
    String fileName = "te:st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersDoubleQuoteEnd() throws Exception {
    String fileName = "test\".txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersDoubleQuoteStart() throws Exception {
    String fileName = "\"test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersDoubleQuoteMidle() throws Exception {
    String fileName = "te\"st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersfForwardSlashEnd() throws Exception {
    String fileName = "test/.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersForwardSlashStart() throws Exception {
    String fileName = "/test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersForwardSlashMidle() throws Exception {
    String fileName = "te/st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersBackslashEnd() throws Exception {
    String fileName = "test\\.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersBackslashStart() throws Exception {
    String fileName = "\\test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersBackslashMidle() throws Exception {
    String fileName = "te\\st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersPipeEnd() throws Exception {
    String fileName = "test|.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersPipeStart() throws Exception {
    String fileName = "|test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersPipeMidle() throws Exception {
    String fileName = "te|st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersQuestionMarkEnd() throws Exception {
    String fileName = "test?.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersQuestionMarkStart() throws Exception {
    String fileName = "?test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersQuestionMarkMidle() throws Exception {
    String fileName = "te?st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersAsteriskEnd() throws Exception {
    String fileName = "test*.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersAsteriskStart() throws Exception {
    String fileName = "*test.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

  @Test
  public void validateSpecialCharactersAsteriskMidle() throws Exception {
    String fileName = "te*st.txt";
    Assert.assertTrue(Helper.hasSpecialCharacters(fileName));
  }

}
