package com.pluralsight.persistence.module07.model;

import com.pluralsight.persistence.module07.Util;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class AuthorTest {

  private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><author id=\"1\"><first-name>Douglas</first-name><last-name>Adams</last-name><bio>Adams is best known as the author of The Hitchhiker's Guide to the Galaxy, which originated in 1978 as a BBC radio comedy</bio><date-of-birth>1952-03-11T00:00:00+01:00</date-of-birth><preferredLanguage>ENGLISH</preferredLanguage></author>";

  @Test
  public void shouldMarshal() throws Exception {

    Author author = new Author("Douglas", "Adams", "Adams is best known as the author of The Hitchhiker's Guide to the Galaxy, which originated in 1978 as a BBC radio comedy", Util.date("11/03/1952"), Language.ENGLISH);
    author.setId(1L);

    // Marshals the object into a String
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Author.class);
    Marshaller m = context.createMarshaller();
    m.marshal(author, writer);

    assertEquals(writer.toString().trim(), expectedXML);
    System.out.println(writer);
  }
}
