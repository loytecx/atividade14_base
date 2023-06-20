package ifpr.pgua.eic.quizapp.controllers;

import ifpr.pgua.eic.quizapp.App;
import javafx.event.Event;
import javafx.fxml.FXML;

public class TelaPrincipal {

    @FXML
    private void abrirTelaCadastro(Event event){
        App.pushScreen("GERENCIADOR");
    }
    
}
