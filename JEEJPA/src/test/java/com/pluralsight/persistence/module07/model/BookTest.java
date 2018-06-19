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
public class BookTest {

  private String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book isbn=\"0-671-62964-6\" id=\"1\"><title>H2G2</title><description>The Hitchhiker's Guide to the Galaxy is a comedy science fiction series created by Douglas Adams.</description><unit-cost>12.5</unit-cost><nb-of-pages>257</nb-of-pages><authors id=\"45\"><first-name>Douglas</first-name><last-name>Adams</last-name><bio>Adams is best known as the author of The Hitchhiker's Guide to the Galaxy, which originated in 1978 as a BBC radio comedy</bio><date-of-birth>1952-03-11T00:00:00+01:00</date-of-birth><preferredLanguage>ENGLISH</preferredLanguage></authors><authors id=\"1\"><first-name>Douglas</first-name><last-name>Adams</last-name><bio>Adams is best known as the author of The Hitchhiker's Guide to the Galaxy, which originated in 1978 as a BBC radio comedy</bio><date-of-birth>1952-03-11T00:00:00+01:00</date-of-birth><preferredLanguage>ENGLISH</preferredLanguage></authors><publisher id=\"23\" name=\"Pingouin\"/></book>";

  @Test
  public void shouldMarshal() throws Exception {

    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy is a comedy science fiction series created by Douglas Adams.", 12.5f, "0-671-62964-6", 257);
    book.setId(1L);
    Publisher publisher = new Publisher("Pingouin");
    publisher.setId(23l);
    Author douglas = new Author("Douglas", "Adams", "Adams is best known as the author of The Hitchhiker's Guide to the Galaxy, which originated in 1978 as a BBC radio comedy", Util.date("11/03/1952"), Language.ENGLISH);
    douglas.setId(1L);
    douglas.setAge(39);
    Author adams = new Author("Douglas", "Adams", "Adams is best known as the author of The Hitchhiker's Guide to the Galaxy, which originated in 1978 as a BBC radio comedy", Util.date("11/03/1952"), Language.ENGLISH);
    adams.setId(45L);
    Set<Author> authors = new HashSet<>(Arrays.asList(douglas, adams));
    book.setPublisher(publisher);
    book.setAuthors(authors);

    // Marshals the object into a String
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Book.class);
    Marshaller m = context.createMarshaller();
    m.marshal(book, writer);

    assertEquals(writer.toString().trim(), expectedXML);
    System.out.println(writer);
  }
}
