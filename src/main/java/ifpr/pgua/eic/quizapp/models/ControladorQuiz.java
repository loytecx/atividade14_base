package ifpr.pgua.eic.quizapp.models;

import java.util.ArrayList;
import java.util.Collections;


/*Classe responsável por coordenar a execução do quiz.*/

public class ControladorQuiz {
    
    //lista de todas as questões
    private ArrayList<Questao> questoes;
    //indice da questão atual
    private int questaoAtual;
    //número de acertos
    private int acertos;
    //número de erros
    private int erros;

    public ControladorQuiz(ArrayList<Questao> questoes){
        
        Collections.shuffle(questoes);

        this.questoes = questoes;
        questaoAtual = 0;
        acertos = 0;
        erros = 0;
    }


    /*adicionar uma nova questão no conjunto de questões */

    public void adicionarQuestao(Questao questao){
        questoes.add(questao);
    }

    /* retorna o índica da questão atual */
    public int indiceQuestaoAtual(){
        return questaoAtual;
    }

    /*indica a quantidade de questões */

    public int totalQuestoes(){
        return questoes.size();
    }

    /* inidica se existe upróxima questão */
    public boolean temProximaQuestao(){
        return questaoAtual < questoes.size()-1;
    }

    /* atualiza o indice da questão atual para a próxima questão */
    public void proximaQuestao(){
        questaoAtual += 1;
    }

    /*retorna a questão que deve ser respondida */
    public Questao getQuestao(){
        if(questaoAtual < questoes.size()){
            return questoes.get(questaoAtual);
        }
        return null;
        
    }

    /*verifica se a alternativa escolhida é a resposta da questão. Se for, incrementa
     * os acertos e retorna true, senão incrementa os erros e retorna false.
     */
    public boolean respondeQuestao(String alternativa){
        Questao questao = questoes.get(questaoAtual);
        if(questao.getRespostaCorreta().equals(alternativa)){
            acertos +=1;
            return true;
        }
        erros +=1;
        return false;
    }

    public int getAcertos(){
        return acertos;
    }

    public int getErros(){
        return erros;
    }

    /*reinicia o quiz, voltando na primeira questão e zerando acertos e erros. */
    public void reiniciar(){
        Collections.shuffle(questoes);
        questaoAtual = 0;
        acertos = 0;
        erros = 0;
    }

}
