package br.com.pedro.questoes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class Questao3Test {
    
    int quantidadeAnagrama = 0;
    
    /*
    * Verifica se a palavra digitada pelo usuário é válida
     */
    @Test
    void palavraValida(){
        String palavra = "ovo";
        
        String regex = "[a-zA-Z]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(palavra);
        
        assertTrue(m.find());
        
        palavra = "roma";
        m = p.matcher(palavra);
        
        assertTrue(m.find());
        
    }
    
    /*
    * Verifica se a palavra digitada retorna pelo menos um par de anagrama, considerando
    * par de anagrama conforme definido do desafio.
    * Nestes testes, o que se espera é que a quantidade de anagramas de substrings (de uma letra), formadas
    * pela palavra passada, seja igual à quantidade de anagramas esperado.
     */
    @Test
    void quantidadeDeAnagramasComPalavrasComUmaLetra(){
        quantidadeAnagrama = 0;
        String palavra = "ovo";
        
        criarPalavrasComNLetras(palavra);
        
        assertEquals(1, quantidadeAnagrama);
        quantidadeAnagrama = 0;
        
        
        palavra = "ifailuhkqq";
        
        criarPalavrasComUmaLetra(palavra);
        
        assertEquals(2, quantidadeAnagrama);
        quantidadeAnagrama =0;
        
    }
    
    /*
    * Verifica se a quantidade de anagramas de N letras criadas a partir da
    * palavra passada corresponde com a quantidade de anagramas esperados.
    * Reiterando que a quantidade de anagramas esperado é a de substrings
    * criadas com + de uma letra.
     */
    @Test
    void quantidadeDeAnagramasComPalavrasComNLetras(){
        quantidadeAnagrama = 0;
        String palavra = "ovo";
        
        criarPalavrasComNLetras(palavra);
        
        assertEquals(1, quantidadeAnagrama);
        quantidadeAnagrama =0;
        
        palavra = "ifailuhkqq";
        
        criarPalavrasComNLetras(palavra);
        
        assertEquals(1,quantidadeAnagrama);
        quantidadeAnagrama=0;
    }
    
    /*
    * Verifica se a quantidade de anagramas totais da palavra corresponde
    * com o esperado.
    *
     */
    @Test
    void quantidadeTotalDeAnagramasDeUmaPalavra(){
        quantidadeAnagrama = 0;
        
        String palavra = "ovo";
        
        criarPalavrasComNLetras(palavra);
        criarPalavrasComUmaLetra(palavra);
        
        assertEquals(2, quantidadeAnagrama);
        quantidadeAnagrama = 0;
        
        palavra = "ifailuhkqq";
        
        criarPalavrasComUmaLetra(palavra);
        criarPalavrasComNLetras(palavra);
        
        assertEquals(3, quantidadeAnagrama);
        quantidadeAnagrama = 0;
    }
    
    
    /*
     * Verifica se duas strings passadas são anagramas. A estratégia usada foi:
     * 1: verificar se as palavras possuem a mesma quantidade de letras;
     * 2: transformar as strings em minuscula;
     * 3: ordenar as strings;
     * 4: verificar se são iguais, depois de ordenadas.
     *
     * Seguindo esses passos eu posso garantir que duas palavras são
     * anagramas uma da outra.
     * @return: boolean
     * @Param: String a, String b
     */
    private boolean ehAnagrama(String s1, String s2){
        if(s1 == null || s2 == null)
            return false;
        if(s1.length() != s2.length())
            return false;
        
        char[] temporaria1 = s1
                .toLowerCase(Locale.ROOT)
                .toCharArray();
        char[] temporaria2 = s2
                .toLowerCase(Locale.ROOT)
                .toCharArray();
        Arrays.sort(temporaria1);
        Arrays.sort(temporaria2);
        return (Arrays.equals(temporaria1, temporaria2));
    }
    
    /*
    * Cria novas palavras (substings) de apenas uma letra cada,
    * a partir da palavra passada pelo usuário, incrementando
    * a variável quantidadeAnagramas caso encontre letras iguais,
    * consideradas pelo desafio como anagramas.
    *
    * @param: String palavra
    * @return: none
     */
    private void criarPalavrasComUmaLetra(String palavra){
        List subStrings = new ArrayList();
        for(int i=0; i< palavra.length(); i++){
            if(!subStrings.contains(palavra.toLowerCase(Locale.ROOT).charAt(i))){
                subStrings.add(palavra.toLowerCase(Locale.ROOT).charAt(i));
            } else {
                quantidadeAnagrama++;
            }
        
        }
        //ifailuhkqq
        subStrings.clear();
    }
    
    /*
     * Cria novas palavras (substings) com N letras cada,
     * a partir da palavra passada pelo usuário, incrementando
     * a variável quantidadeAnagramas caso encontre palavras iguais.
     *
     * @param: String palavra
     * @return: none
     */
    private void criarPalavrasComNLetras(String palavra){
        int maxLetras = palavra.length()-1;
        int contadorDeLetras = 2;
        List subStrings = new ArrayList();
        
        //Iniciando laço para criação de novas strings com n letras:
        while(contadorDeLetras <=  maxLetras){
            //Cria palavras com o numero de letras igual ao do contador
            for(int letra =0; letra < palavra.length()-(contadorDeLetras-1); letra++){
                subStrings.add(palavra.substring(letra, letra+contadorDeLetras));
            
            }
            //Depois de criadas as palavras, percorro a lista de palavras criadas e verifico se
            //a palavra é anagrama com alguma outra da lista de palavras. Se sim, é incrementado a
            //variável quantidadeAnagramas
            for(int k=0; k < subStrings.size()-1; k++){
                if(ehAnagrama(subStrings.get(k).toString(), subStrings.get(k+1).toString())){
                    quantidadeAnagrama++;
                }
            }
            //Aumento a quantidade de letras e limpo a lista para uma nova criação de palavras
            contadorDeLetras++;
            subStrings.clear();
        }
    }
}