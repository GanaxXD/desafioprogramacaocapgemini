import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Questao1Test {
    
    String valorDigitado = "";
    String regex = "[0-9]+";
    
    /*
    * Verifica se o valor inserido pelo usuário é válido.
    * São considerádos válidos valores inteiros maiores que 0.
    *
    * @params: none
    * @return: void
     */
    @Test
    void testaValorDigitadoInvalido(){
        assertFalse(valorDigitado.matches(regex));
        assertNotEquals(valorDigitado, 1);
        valorDigitado = "@oks";
        assertNotEquals(valorDigitado, 1);
        valorDigitado = "/";
        assertNotEquals(valorDigitado, 1);
        valorDigitado = ":190";
        assertNotEquals(valorDigitado, 1);
        valorDigitado = " ";
        assertNotEquals(valorDigitado, 1);
        valorDigitado = "0";
        assertNotEquals(Integer.parseInt(valorDigitado), 1);
        valorDigitado = "-2";
        assertNotEquals(Integer.parseInt(valorDigitado), 1);
        valorDigitado = "2.5";
        assertNotEquals(Double.parseDouble(valorDigitado), 1);
        
    }
    
    /*
    * Verifica se o valor digitado é válido.
    * São considerádos válidos valores inteiros maiores que 0.
     *
     * @params: none
     * @return: void
     */
    @Test
    void testaValorValorDigitadoValido(){
        valorDigitado = "1";
        assertEquals(1, Integer.parseInt(valorDigitado));
        valorDigitado= "99";
        assertEquals(99, Integer.parseInt(valorDigitado));
    }

}