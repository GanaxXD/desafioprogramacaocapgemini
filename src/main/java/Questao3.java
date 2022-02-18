import javax.swing.*;
import java.util.*;

public class Questao3 {
    public static void main(String[] args) {
        String palavraDigitada = "";
        palavraDigitada= JOptionPane.showInputDialog("Digite uma palavra: ");
        int quantidadeAnagrama = 0;
        List subStrings = new ArrayList<>();//Lista de substrings formadas com as letras da palavraDigitada.
        
        /*
        * Verificação de anagramas para palavras que possuam apenas 1 letra:
        *
        * Adiciona na lista de subStrings apenas as letras que compõem a palavraDigitada
        *  que ainda não foram inseridas na lista. Caso já tenham sido inseridos, é incrementado a
        * variável quantidade de anagramas e a letra não é adicionada na lista novamente.
        *
         */
        for(int i=0; i< palavraDigitada.length(); i++){
            if(!subStrings.contains(palavraDigitada.toLowerCase(Locale.ROOT).charAt(i))){
                subStrings.add(palavraDigitada.toLowerCase(Locale.ROOT).charAt(i));
            } else {
                quantidadeAnagrama++;
            }
            
        }
        //ifailuhkqq
        subStrings.clear();
        
        /*for(int i=0; i< subStrings.size(); i++){
            String auxiliar = subStrings.get(i).toString();
            palavraDigitada.replaceAll(auxiliar, "");
            int repete = 0;
            //Verificando igualdade entre as letras:
            for(int j =0; j < subStrings.size(); j++){
                if(auxiliar.equals(subStrings.get(j).toString()) ){
                    repete++;
                }
                if(repete>1){
                    quantidadeAnagrama++;
                }
            }
            //Limpando a lista:
            subStrings.clear();
        }*/
    
        /*
        * Verificação de Anagramas para palavras com quantidade de letras = palavraDigitada.length()-1:
        *
        * Depois de verificadas os anagramas com uma só letra, é necessário criar palavras que possuam
        * 2, 3, 4... n-1 letras e verificar se entre essas palavras, existem mais anagramas.
        *
        * Variáveis utilizadas:
        * int maxLetras: indica o máximo de letras que as palavras formadas devem ter (palavraDigitada.length()-1);
        * int contador de letras: indica a partir de quantas letras as próximas palavras serão formadas;
        *
        *
         */
        int maxLetras = palavraDigitada.length()-1;
        int contadorDeLetras = 2;
        
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
        System.out.println(quantidadeAnagrama);
        
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
