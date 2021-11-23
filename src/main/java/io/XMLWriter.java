package io;

import model.CommonStructure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLWriter {

    private static final Logger logger = Logger.getLogger(XMLWriter.class.getName());

    private XMLWriter(){}

    public static void writeToXML(Object object, String directory){
        logger.info("Starting write to xml file");
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy_HHmmssSSSS");
        String fileName = "info_"+format.format(new Date())+".xml";
        try {
            logger.info("Starting marshal to xml file");
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, new File(directory+"/"+fileName));
            logger.info("Successful of writing to xml file");
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Something went wrong with marshal to xml file", e);
        }
    }

}
