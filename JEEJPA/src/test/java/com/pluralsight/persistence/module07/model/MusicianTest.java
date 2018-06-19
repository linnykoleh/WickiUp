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
public class MusicianTest {

  private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><musician id=\"1\"><first-name>John</first-name><last-name>Lennon</last-name><bio>John Winston Ono Lennon, (born John Winston Lennon; 9 October 1940 – 8 December 1980) was an English musician, singer and songwriter who rose to worldwide fame as a founder member of the Beatles, the most commercially successful band in the history of popular music. With Paul McCartney, he formed a songwriting partnership that is one of the most celebrated of the 20th century</bio><date-of-birth>1940-10-09T00:00:00+02:00</date-of-birth><preferredInstrument>Guitar</preferredInstrument></musician>";

  @Test
  public void shouldMarshal() throws Exception {

    Musician author = new Musician("John", "Lennon", "John Winston Ono Lennon, (born John Winston Lennon; 9 October 1940 – 8 December 1980) was an English musician, singer and songwriter who rose to worldwide fame as a founder member of the Beatles, the most commercially successful band in the history of popular music. With Paul McCartney, he formed a songwriting partnership that is one of the most celebrated of the 20th century", Util.date("09/10/1940"), "Guitar");
    author.setId(1L);

    // Marshals the object into a String
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Musician.class);
    Marshaller m = context.createMarshaller();
    m.marshal(author, writer);

    assertEquals(writer.toString().trim(), expectedXML);
    System.out.println(writer);
  }
}
