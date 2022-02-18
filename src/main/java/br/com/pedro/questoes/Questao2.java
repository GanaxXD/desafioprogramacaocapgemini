package br.com.pedro.questoes;

import br.com.pedro.funcoes.FuncoesQuestao2;

import javax.swing.*;
import java.util.regex.Pattern;

public class Questao2 {
    public static void main(String[] args) {
        String senhaDigitada = "";
        
        senhaDigitada = JOptionPane.showInputDialog(null, "Digite uma senha: ");
        FuncoesQuestao2.validaSenha(senhaDigitada);
    }
}
