package br.com.pedro.funcoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FuncoesQuestao3 {
    
    public FuncoesQuestao3(){}
    
    /*
     * Verificação de anagramas para palavras que possuam apenas 1 letra:
     *
     * Adiciona na lista de subStrings apenas as letras que compõem a palavraDigitada
     *  que ainda não foram inseridas na lista. Caso já tenham sido inseridos, é incrementado a
     * variável quantidade de anagramas e a letra não é adicionada na lista novamente.
     *
     * @param: String palavra_digitada_pelo_usuario
     * @return: int numero_de_anagramas
     *
     */
    public static int verificaAnagramaEmPalavraDeUmaLetra(String palavraDigitada){
        int quantidadeAnagrama = 0;
        List subStrings = new ArrayList<>();//Lista de substrings formadas com as letras da palavraDigitada.
        
        for(int i=0; i< palavraDigitada.length(); i++){
            if(!subStrings.contains(palavraDigitada.toLowerCase(Locale.ROOT).charAt(i))){
                subStrings.add(palavraDigitada.toLowerCase(Locale.ROOT).charAt(i));
            } else {
                quantidadeAnagrama++;
            }
        }
        //ifailuhkqq
        subStrings.clear();
        return quantidadeAnagrama;
    }
    
    /*
     * Verificação de anagramas para palavras que possuam N letras:
     *
     * Esta função cria substrings contendo 1, 2, 3 ... n-1 letras para verificar
     * se essas substrings formadas de uma palavra, contém um par de anagramas.
     *
     * @param: String palavra_digitada_pelo_usuario
     * @return: int numero_de_anagramas
     *
     */
    public static int verificaAnagramaEmPalavraDeNLetra(String palavraDigitada){
        int maxLetras = palavraDigitada.length()-1;
        int contadorDeLetras = 2;
        List subStrings = new ArrayList();
        int quantidadeAnagrama = 0;
    
        //Iniciando laço para criação de novas strings com n letras:
        while(contadorDeLetras <=  maxLetras){
            //Cria palavras com o numero de letras igual ao do contador
            for(int letra =0; letra < palavraDigitada.length()-(contadorDeLetras-1); letra++){
                subStrings.add(palavraDigitada.substring(letra, letra+contadorDeLetras));
            
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
        return quantidadeAnagrama;
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
    public static boolean ehAnagrama(String s1, String s2){
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
}
