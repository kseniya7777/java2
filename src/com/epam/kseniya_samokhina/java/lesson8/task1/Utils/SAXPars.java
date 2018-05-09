package com.epam.kseniya_samokhina.java.lesson8.task1.Utils;

import com.epam.kseniya_samokhina.java.lesson8.task1.Device.Device;
import com.epam.kseniya_samokhina.java.lesson8.task1.Device.TypeOfDevice;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SAXPars extends DefaultHandler {

    Device device = new Device();
    String thisElement = "";

    public Device getResult() {
        return device;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("brandDevice")) {
            device.setBrandDevice(new String(ch, start, length));
        }
        if (thisElement.equals("colorDevice")) {
            device.setColorDevice(new String(ch, start, length));
        }
        if (thisElement.equals("deviceLocation")) {
            device.setDeviceLocation(new String(ch, start, length));
        }
        if (thisElement.equals("originDevice")) {
            device.setOriginDevice(new String(ch, start, length));
        }
        if (thisElement.equals("powerOfDevice")) {
            device.setPowerOfDevice(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("stateOfDevice")) {
            device.setStateOfDevice(new Boolean(new String(ch, start, length)));
        }
        if (thisElement.equals("typeOfDevice")) {
            device.setTypeOfDevice(TypeOfDevice.valueOf(new String(ch, start, length)));
        }
    }
}

