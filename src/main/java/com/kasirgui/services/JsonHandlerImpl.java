package com.kasirgui.services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kasirgui.helpers.ObjectMapperSingleton;
import com.kasirgui.helpers.PropertiesConfig;
import com.kasirgui.model.FormatSaver;

public class JsonHandlerImpl implements JsonHandler<FormatSaver> {

    Properties config = PropertiesConfig.getConfig("config");
    private ObjectMapper mapper = ObjectMapperSingleton.getInstace();
    private ObjectWriter write = mapper.writer();
    private ObjectReader reader = mapper.reader();
    private Path fileSave = Paths.get(config.getProperty("root"), config.getProperty("fileSave"));

    @Override
    public FormatSaver read() throws IOException {
        return reader.readValue(fileSave.toFile());
    }

    @Override
    public void write(FormatSaver[] data) throws StreamWriteException, DatabindException, IOException {
        write.writeValue(fileSave.toFile(), data);
    }

}
