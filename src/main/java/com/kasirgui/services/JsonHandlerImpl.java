package com.kasirgui.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    private Path fileSave = Paths.get(config.getProperty("root")).resolve(config.getProperty("fileSave"));

    public final void init() throws IOException {
        if (Files.notExists(fileSave)) {
            System.out.println(fileSave.toAbsolutePath());
            Files.createDirectory(fileSave.getParent());
            Files.createFile(fileSave);

            write.writeValue(fileSave.toFile(), new ArrayList<>());
        }
    }

    @Override
    public FormatSaver[] read() throws IOException {
        init();
        return reader.readValue(fileSave.toFile());
    }

    @Override
    public void write(FormatSaver[] data) throws StreamWriteException, DatabindException, IOException {
        init();
        write.writeValue(fileSave.toFile(), data);
    }

}
