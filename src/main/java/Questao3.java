import javax.swing.*;
import java.math.BigInteger;
import java.util.*;

public class Questao3 {
    public static void main(String[] args) {
        String palavraDigitada = "";
        palavraDigitada= JOptionPane.showInputDialog("Digite uma palavra: ");
        int quantidadeAnagrama = 0;
        List subStrings = new ArrayList<>();
        int letraRepetida =0;
        
        //List<Map<String, Integer>> subStringQtdLetras = new ArrayList<>();
        
        //Dividindo a palavra digitada em grupos de palavras:
        //pegando letra a letra
        for(int i=0; i< palavraDigitada.length(); i++){
            if(!subStrings.contains(palavraDigitada.toLowerCase(Locale.ROOT).charAt(i))){
                subStrings.add(palavraDigitada.toLowerCase(Locale.ROOT).charAt(i));
            } else {
                quantidadeAnagrama++;
            }
        }
        
        //-----------------------------------------------------
        System.out.println("PASSO 2: Verificando letras iguais");
        
        //Percorrendo vetor e verificando se existe mais de uma letra igual
        for(int i=0; i< subStrings.size(); i++){
            String auxiliar = subStrings.get(i).toString();
            palavraDigitada.replaceAll(auxiliar, "");
            System.out.println("AUXILIAR "+(i+1)+ ": "+ auxiliar);
            int repete = 0;
            //Verificando igualdade entre as letras:
            for(int j =0; j < subStrings.size(); j++){
                if(auxiliar.equals(subStrings.get(j).toString()) ){
                    repete++;
                    System.out.println("REPETE "+ repete);
                }
                if(repete>1){
                    quantidadeAnagrama++;
                    System.out.println("QUANTIDADE ANAGRAMA "+ quantidadeAnagrama);
                }
            }
            System.out.println("QUANTIDADE ANAGRAMA "+ quantidadeAnagrama);

            System.out.println("VERIFICANDO OUTRAS SUBSTRINGS MAIORES QUE 1 LETRA: ");
            //Limpando a lista:
            subStrings.clear();
            
            /*int repete = 0;
            int loop = 0;
            while (loop < subStrings.size()){
                if(auxiliar.equals(subStrings.get(i).toString()) ){
                    repete++;
                    System.out.println("REPETE "+ repete);
                }
                loop++;
            }
            if(repete>1){
                quantidadeAnagrama++;
            }*/
        }
    
        //PASSO 3: CRIANDO SUBSTRINGS COM MAIS LETRAS
        //Formando palavras até palavraDigitada.length()-1:
        int maxLetras = palavraDigitada.length()-1;
        int contadorDeLetras = 2;
        while(contadorDeLetras <=  maxLetras){
            for(int letra =0; letra < palavraDigitada.length()-(contadorDeLetras-1); letra++){
                subStrings.add(palavraDigitada.substring(letra, letra+contadorDeLetras));
                /*System.out.println("SUBSTRING "+(letra)+": " +subStrings.get(letra));
                System.out.println("TESTE " +(letra == palavraDigitada.length()-1));
                System.out.println("LETRA: "+ letra+ " | TAMNHO PALAVRA DIGITADA: "+(palavraDigitada.length()-1));*/
        
            }
            for(int k=0; k < subStrings.size()-1; k++){
                System.out.println("ENTREI "+k);
                if(ehAnagrama(subStrings.get(k).toString(), subStrings.get(k+1).toString())){
                    quantidadeAnagrama++;
                }
            }
            //System.out.println(ehAnagrama(subStrings.get(0).toString(), subStrings.get(1).toString()));
            System.out.println("QUANTIDADE ANAGRAMA "+ quantidadeAnagrama);
            contadorDeLetras++;
            subStrings.clear();
        }
        
        
        
        
        
        /*Iterator it = subStrings.iterator();
        while (it.hasNext()){
            for(int i=0; i < subStrings.size(); i++){
                //ehAnagrama(subStrings.get(i).toString(), it.next().toString());
            }
        }*/
    
        /*String[] s = geraAnagramas(palavraDigitada);
    
    
        for(int i = 0; i<s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println("Encontrados "+s.length+" anagramas.");
    
        System.out.println(quantidadeAnagrama);*/
        
    }
    
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
        System.out.println("s1: "+ s1+ " s2: "+ s2);
        return (Arrays.equals(temporaria1, temporaria2));
    }
    
    public static void imprimeAnagramas(String prefix, String word) {
        if (word.length() <= 1) {
            System.out.println(prefix + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String cur = word.substring(i, i + 1);
                String before = word.substring(0, i);
                String after = word.substring(i + 1);
                imprimeAnagramas(prefix + cur, before + after);
            }
        }
    }
    
    
    
    
    
    private final static int MAX_ANAGRAMAS = 250;
    
    private static BigInteger fatorial(int num) {
        BigInteger resultado = BigInteger.ONE;
        for (int i=1; i<=num; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i)) ;
        }
        return resultado;
    }
    
    
    public static String[]geraAnagramas (String palavra) {
        String[] retorno;
        palavra = palavra.toUpperCase();
        if (palavra.length() == 1) {
            retorno = new String[1];
            retorno[0]=palavra;
        } else {
            
            //Conta repetições de letras
            int[] repeticoes = new int[palavra.length()];
            char[] letras = new char[palavra.length()];
            int[]posicoes = new int[palavra.length()];
            int numLetrasDistintas = 0;
            for (int i=0; i<palavra.length(); i++){
                int lugar =-1;
                for (int j=0; j<numLetrasDistintas; j++) {
                    if (letras[j] == palavra.charAt(i))
                    {
                        lugar=j;
                        break;
                    }
                }
                
                if(lugar < 0){
                    letras[numLetrasDistintas] = palavra.charAt(i);
                    posicoes[numLetrasDistintas] = i;
                    repeticoes[numLetrasDistintas]++;
                    numLetrasDistintas++;
                } else {
                    repeticoes[lugar]++;
                }
            }
            
            //Calcula o número de anagramas possíveis
            BigInteger numAnagramasSemRepeticao = fatorial(palavra.length());
            for (int i=0; i<numLetrasDistintas; i++) {
                numAnagramasSemRepeticao =
                        numAnagramasSemRepeticao.divide(fatorial(repeticoes[i])) ;
            }
            
            //Cria o vetor que guardará os anagramas
            if (numAnagramasSemRepeticao.compareTo(
                    BigInteger.valueOf(MAX_ANAGRAMAS)) <= 0)
                retorno = new String[numAnagramasSemRepeticao.intValue()];
            else
                retorno = new String[MAX_ANAGRAMAS];
  
  
            /*
             Percorre cada letra distinta, colocando em sequência
             na primeira posição e gerando os anagramas para o resto
             */
            int k=0;
            for (int i =0; i<numLetrasDistintas; i++) {
                
                String resto = palavra.substring(0, posicoes[i]) +
                        palavra.substring(posicoes[i]+1);
                String[] anagramasResto = geraAnagramas(resto);
                for (int j=0; j<anagramasResto.length; j++) {
                    retorno[k] = letras[i]+anagramasResto[j];
                    k++;
                    if (k > MAX_ANAGRAMAS - 1)
                        break;
                }
                if (k > MAX_ANAGRAMAS - 1)
                    break;
            }
        }
        
        return retorno;
    }
}
