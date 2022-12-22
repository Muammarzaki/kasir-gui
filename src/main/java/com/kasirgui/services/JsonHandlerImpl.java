package com.kasirgui.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kasirgui.helpers.ObjectMapperSingleton;
import com.kasirgui.helpers.PropertiesConfig;

public class JsonHandlerImpl<T> implements JsonHandler<T> {

    Properties config = PropertiesConfig.getConfig("config");
    private ObjectMapper mapper = ObjectMapperSingleton.getInstace();
    private Path fileSave = Paths.get(config.getProperty("root")).resolve(config.getProperty("fileSave"));

    public final void init() throws Exception {
        if (!Files.exists(fileSave)) {
            System.out.println(fileSave.toAbsolutePath());
            Files.createDirectory(fileSave.getParent());
            Files.createFile(fileSave);
            write(Collections.emptyList());
        }
    }

    @Override
    public void write(List<T> data) throws Exception {
        init();
        mapper.writeValue(fileSave.toFile(), data);
    }

    @Override
    public List<T> read() throws Exception {
        init();
        return mapper.readValue(fileSave.toFile(), new TypeReference<List<T>>() {
        });

    }

}
