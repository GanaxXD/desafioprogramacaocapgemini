import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class Questao2Test {
    
    String senhaDigitada = "";
    
    /*
    * Teste para verificar se a senha é válida.
    * Para a senha ser considerada válida, ela precisa ter:
    *  pelo menos 6 dígitos +
    *  pelo menos 1 número +
    *  pelo menos 1 caracter especial (sendo eles considerados pelo desafio:  !@#$%^&*()-+
    *  pelo menos 1 letra maiúscula +
    *  pelo menos 1 letra minúscula.
     */
    @Test
    void senhaValida(){
        senhaDigitada = "1@klM0";
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(senhaDigitada);
        assertFalse(senhaDigitada.isEmpty());
        assertTrue(senhaDigitada.length()>=6);
        assertTrue(senhaDigitada.contains("@"));
        assertNotNull(senhaDigitada);
        assertTrue(m.find());
        senhaDigitada="kodycnKmoshfMM09:";
        assertTrue(senhaDigitada.length()>=6);
        assertNotNull(senhaDigitada);
        assertTrue(senhaDigitada.contains(":"));
        assertTrue(m.find());
        regex="[a-zA-Z]";
        p = Pattern.compile(regex);
        m = p.matcher(senhaDigitada);
        assertTrue(m.find());
    }
    
    /*
    * Verifica se a senha digitada é inválida
     */
    @Test
    void senhaInvalida(){
        senhaDigitada = "";
        String regex = "[a-zA-Z]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(senhaDigitada);
        
        assertFalse(senhaDigitada.length()>=6);
        assertFalse(m.find());
        
        regex = "[0-9]";
        p = Pattern.compile(regex);
        m = p.matcher(senhaDigitada);
        
        assertFalse(m.find());
        
        regex="[!@#$%^&*()-+]";
        p = Pattern.compile(regex);
        m = p.matcher(senhaDigitada);
        
        assertFalse(m.find());
        
        senhaDigitada = "1:lM";
        p = Pattern.compile(regex);
        m = p.matcher(senhaDigitada);
        
        assertFalse(senhaDigitada.length()>=6);
        
        senhaDigitada = "jsuhdMnsidid";
        assertTrue(senhaDigitada.length()>=6);
        assertFalse(m.find());
        
        regex="[!@#$%^&*()-+]";
        p = Pattern.compile(regex);
        m = p.matcher(senhaDigitada);
        
        assertFalse(m.find());
    }
}