import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Date;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private Station station;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("voter")) {
            voter = new Voter(attributes.getValue("name"), new Date(attributes.getValue("birthday")));
        }
        else if (qName.equals("visit") && voter != null) {
            station = new Station(attributes.getValue("station"),new Date(attributes.getValue("time")), voter);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
        }
    }
}
