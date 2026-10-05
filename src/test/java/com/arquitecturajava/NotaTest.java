package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class NotaTest {

    @Test
    void aprobadoTest() {

        // Arrange
        Nota nota = new Nota(7, "matematicas");
        // Act
        boolean aprobado = nota.estaAprobada();

        // Assert
        assertTrue(aprobado);
    }

    @Test
    void aprobadoJustoTest() {

        // Arrange
        Nota nota = new Nota(5, "matematicas");
        // Act
        boolean aprobado = nota.estaAprobada();

        // Assert
        assertTrue(aprobado);
    }

    @Test
    void suspensoTest() {

        // Arrange
        Nota nota = new Nota(4.9, "matematicas");
        // Act
        boolean aprobado = nota.estaAprobada();

        // Assert
        assertFalse(aprobado);
    }
    @Test
    void asignarValoresLimiteNota() {

        //Arrange
        Nota nota1= new Nota(10,"matematicas");
        Nota nota2= new Nota(0,"matematicas");
        //Act
        double valor1=nota1.getValor();
        double valor2=nota2.getValor();
    
        //Assert
        assertEquals(10,valor1);
        assertEquals(0, valor2);


    }

    @Test
    void notaNegativaLanzaExcepcion() {

        // Arrange
        double valorNegativo = -0.1;
        String asignatura = "matematicas";

        // Act
        Executable crearNota = () -> new Nota(valorNegativo, asignatura);

        // Assert
        assertThrows(IllegalArgumentException.class, crearNota);
    }

    @Test
    void notaMayorQueDiezLanzaExcepcion() {

        // Arrange
        double valorMayorQueDiez = 10.1;
        String asignatura = "matematicas";

        // Act
        Executable crearNota = () -> new Nota(valorMayorQueDiez, asignatura);

        // Assert
        assertThrows(IllegalArgumentException.class, crearNota);
    }

    @Test
    void subirPuntosIncrementaLaNota() {

        // Arrange
        Nota nota = new Nota(6, "matematicas");

        // Act
        nota.subir(1.5);

        // Assert
        assertEquals(7.5, nota.getValor());
    }

    @Test
    void subirPuntosHastaDiezEsValido() {

        // Arrange
        Nota nota = new Nota(8, "matematicas");

        // Act
        nota.subir(2);

        // Assert
        assertEquals(10, nota.getValor());
    }

    @Test
    void subirPuntosPorEncimaDeDiezLanzaExcepcion() {

        // Arrange
        Nota nota = new Nota(9, "matematicas");

        // Act
        Executable subirNota = () -> nota.subir(2);

        // Assert
        assertThrows(IllegalArgumentException.class, subirNota);
        assertEquals(9, nota.getValor());
    }

    @Test
    void subirPuntosNegativosLanzaExcepcion() {

        // Arrange
        Nota nota = new Nota(6, "matematicas");

        // Act
        Executable subirNota = () -> nota.subir(-1);

        // Assert
        assertThrows(IllegalArgumentException.class, subirNota);
        assertEquals(6, nota.getValor());
    }

    @Test
    void bajarPuntosDecrementaLaNota() {

        // Arrange
        Nota nota = new Nota(6, "matematicas");

        // Act
        nota.bajar(1.5);

        // Assert
        assertEquals(4.5, nota.getValor());
    }

    @Test
    void bajarPuntosHastaCeroEsValido() {

        // Arrange
        Nota nota = new Nota(2, "matematicas");

        // Act
        nota.bajar(2);

        // Assert
        assertEquals(0, nota.getValor());
    }

    @Test
    void bajarPuntosPorDebajoDeCeroLanzaExcepcion() {

        // Arrange
        Nota nota = new Nota(1, "matematicas");

        // Act
        Executable bajarNota = () -> nota.bajar(2);

        // Assert
        assertThrows(IllegalArgumentException.class, bajarNota);
        assertEquals(1, nota.getValor());
    }

    @Test
    void bajarPuntosNegativosLanzaExcepcion() {

        // Arrange
        Nota nota = new Nota(6, "matematicas");

        // Act
        Executable bajarNota = () -> nota.bajar(-1);

        // Assert
        assertThrows(IllegalArgumentException.class, bajarNota);
        assertEquals(6, nota.getValor());
    }

    
    @Test
    void relacionInversaSubirBajarNotaTest() {

        // Arrange
        Nota nota = new Nota(6, "matematicas");

        //Act 
        nota.subir(2);
        nota.bajar(2);

        //Assert
        assertEquals(6, nota.getValor());
    }

    @Test
    void notasConMismoValorYAsignaturaSonIguales() {

        // Arrange
        Nota nota1 = new Nota(7, "matematicas");
        Nota nota2 = new Nota(7, "matematicas");

        // Act
        boolean iguales = nota1.equals(nota2);

        // Assert
        assertTrue(iguales);
    }

    @Test
    void notasConDistintoValorNoSonIguales() {

        // Arrange
        Nota nota1 = new Nota(7, "matematicas");
        Nota nota2 = new Nota(8, "matematicas");

        // Act
        boolean iguales = nota1.equals(nota2);

        // Assert
        assertFalse(iguales);
    }

    @Test
    void notasConDistintaAsignaturaNoSonIguales() {

        // Arrange
        Nota nota1 = new Nota(7, "matematicas");
        Nota nota2 = new Nota(7, "lengua");

        // Act
        boolean iguales = nota1.equals(nota2);

        // Assert
        assertFalse(iguales);
    }

    @Test
    void notaNoEsIgualANull() {

        // Arrange
        Nota nota = new Nota(7, "matematicas");

        // Act
        boolean iguales = nota.equals(null);

        // Assert
        assertFalse(iguales);
    }

    @Test
    void notasIgualesTienenElMismoHashCode() {

        // Arrange
        Nota nota1 = new Nota(7, "matematicas");
        Nota nota2 = new Nota(7, "matematicas");

        // Act
        int hash1 = nota1.hashCode();
        int hash2 = nota2.hashCode();

        // Assert
        assertEquals(hash1, hash2);
    }
}
