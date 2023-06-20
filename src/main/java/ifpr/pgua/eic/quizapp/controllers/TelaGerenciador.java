package ifpr.pgua.eic.quizapp.controllers;

import ifpr.pgua.eic.quizapp.models.ControladorQuiz;
import ifpr.pgua.eic.quizapp.models.Questao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TelaGerenciador {

    @FXML
    private ListView<Questao> lstQuestoes;

    @FXML
    private TextField tfEnunciado;

    @FXML
    private TextField tfRespostaCorreta;
    
    private ControladorQuiz controladorQuiz;


    @FXML
    private TextField tfRespostaErrada1;

    @FXML
    private TextField tfRespostaErrada2;

    @FXML
    private TextField tfRespostaErrada3;

    public TelaGerenciador (ControladorQuiz controladorQuiz){
        this.controladorQuiz = controladorQuiz;
    };

    @FXML
    void cadastrar(ActionEvent event) {
        String enunciado = tfEnunciado.getText();
        String respostaCorreta = tfRespostaCorreta.getText();
        String respostaErrada1 = tfRespostaErrada1.getText();
        String respostaErrada2 = tfRespostaErrada2.getText();
        String respostaErrada3 = tfRespostaErrada3.getText();

        Questao questao = new Questao(enunciado, respostaCorreta, new String[]{respostaErrada1,respostaErrada2,respostaErrada3} );
        controladorQuiz.adicionarQuestao(questao);

        limpar();
        atualizarLista();
    }

    private void limpar(){
        tfEnunciado.clear();
        tfRespostaCorreta.clear();
        tfRespostaErrada1.clear();
        tfRespostaErrada2.clear();
        tfRespostaErrada3.clear();

    }
    private void atualizarLista(){
        lstQuestoes.getItems().clear();
        lstQuestoes.getItems().addAll(controladorQuiz.getQuestao());
    }

    @FXML
    void voltar(ActionEvent event) {

    }



}
