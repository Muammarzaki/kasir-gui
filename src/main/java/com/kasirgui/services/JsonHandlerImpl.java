package com.kasirgui.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kasirgui.helpers.PropertiesConfig;
import com.kasirgui.model.SimpleProductSaverFormat;

public class JsonHandlerImpl<T> implements JsonHandler<T> {

    Properties config = PropertiesConfig.getConfig("config");
    private ObjectMapper mapper = new ObjectMapper();
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
    public void write(List<SimpleProductSaverFormat> data) throws IOException {
        // init();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(fileSave.toFile(), data);

        // writer.writeValue(fileSave.toFile(), data);
    }

    @Override
    public List<SimpleProductSaverFormat> read() throws Exception {
        // init();
        List<SimpleProductSaverFormat> data = new ArrayList<>();
        data.addAll(mapper.readValue(fileSave.toFile(), new TypeReference<List<SimpleProductSaverFormat>>() {
        }));
        return data;
    }

}
