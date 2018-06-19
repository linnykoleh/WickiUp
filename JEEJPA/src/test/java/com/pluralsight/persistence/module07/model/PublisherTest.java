package com.pluralsight.persistence.module07.model;

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
public class PublisherTest {

  private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><publisher id=\"1\" name=\"Pingouin\"/>";

  @Test
  public void shouldMarshal() throws Exception {

    Publisher author = new Publisher("Pingouin");
    author.setId(1L);

    // Marshals the object into a String
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Publisher.class);
    Marshaller m = context.createMarshaller();
    m.marshal(author, writer);

    assertEquals(writer.toString().trim(), expectedXML);
    System.out.println(writer);
  }
}
