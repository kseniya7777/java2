package com.epam.kseniya_samokhina.java.lesson8.task1.Utils;

import com.epam.kseniya_samokhina.java.lesson8.task1.Device.Device;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ObjectToXML {
    public static void writeObject(String fileName, Device device) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Device.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(device, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
