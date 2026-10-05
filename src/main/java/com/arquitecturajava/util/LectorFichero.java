package com.arquitecturajava.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LectorFichero {

    public List<String> leerLineas(String ruta) throws IOException {
        return Files.readAllLines(Path.of(ruta));
    }
}
