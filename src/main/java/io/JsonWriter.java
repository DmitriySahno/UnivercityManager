package io;

import model.CommonStructure;
import util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeToJson(Object object, String directory){
        logger.info("Starting write to json file");
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy_HHmmssSSSS");
        String fileName = "info_"+format.format(new Date())+".json";
        try (FileOutputStream fos = new FileOutputStream(directory+"/"+fileName)) {
            String json = JsonUtil.objectToJson(object);
            fos.write(json.getBytes());
            fos.flush();
            logger.info("Successful of writing to json file");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Something went wrong with writing to json file", e);
        }
    }

}
