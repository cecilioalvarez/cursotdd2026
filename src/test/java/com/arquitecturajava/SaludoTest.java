package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SaludoTest {

    @Test
    void saludarDevuelveHolaMundo() {
        Saludo saludo = new Saludo();

        assertEquals("Hola Mundo", saludo.saludar());
    }
}
