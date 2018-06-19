package com.pluralsight.persistence.module07.model;

import com.pluralsight.persistence.module07.Util;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CDTest {

  private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cd id=\"1\"><title>Sgt. Pepper's Lonely Hearts Club Band</title><description>Sgt. Pepper's Lonely Hearts Club Band (often shortened to Sgt. Pepper) is the eighth studio album by English rock band the Beatles</description><unit-cost>12.5</unit-cost><totalDuration>75.6</totalDuration><genre>Pop Rock</genre><musicians id=\"1\"><first-name>John</first-name><last-name>Lennon</last-name><bio>John Winston Ono Lennon, (born John Winston Lennon; 9 October 1940 – 8 December 1980) was an English musician, singer and songwriter who rose to worldwide fame as a founder member of the Beatles, the most commercially successful band in the history of popular music. With Paul McCartney, he formed a songwriting partnership that is one of the most celebrated of the 20th century</bio><date-of-birth>1940-10-09T00:00:00+02:00</date-of-birth><preferredInstrument>Guitar</preferredInstrument></musicians></cd>";

  @Test
  public void shouldMarshal() throws Exception {

    CD cd = new CD("Sgt. Pepper's Lonely Hearts Club Band", "Sgt. Pepper's Lonely Hearts Club Band (often shortened to Sgt. Pepper) is the eighth studio album by English rock band the Beatles", 12.5f, 75.6f, "Pop Rock");
    cd.setId(1L);
    Musician john = new Musician("John", "Lennon", "John Winston Ono Lennon, (born John Winston Lennon; 9 October 1940 – 8 December 1980) was an English musician, singer and songwriter who rose to worldwide fame as a founder member of the Beatles, the most commercially successful band in the history of popular music. With Paul McCartney, he formed a songwriting partnership that is one of the most celebrated of the 20th century", Util.date("09/10/1940"), "Guitar");
    john.setId(1L);
    Set<Musician> musicians = new HashSet<>(Arrays.asList(john));
    cd.setMusicians(musicians);

    // Marshals the object into a String
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(CD.class);
    Marshaller m = context.createMarshaller();
    m.marshal(cd, writer);

    assertEquals(writer.toString().trim(), expectedXML);
    System.out.println(writer);
  }
}
