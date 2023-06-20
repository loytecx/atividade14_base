package ifpr.pgua.eic.quizapp;

import java.util.ArrayList;

import ifpr.pgua.eic.quizapp.models.ControladorQuiz;
import ifpr.pgua.eic.quizapp.models.Questao;
import ifpr.pgua.eic.quizapp.screens.TelaCadastro;
import ifpr.pgua.eic.quizapp.controllers.TelaGerenciador;
import ifpr.pgua.eic.quizapp.controllers.TelaPrincipal;
import ifpr.pgua.eic.quizapp.screens.TelaQuiz;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;
import io.github.hugoperlin.navigatorfx.ScreenRegistryNoFXML;


/*A classe App extende a classe BaseAppNavigator, o que
 * permite fazer a navegação entre telas.
 */
public class App extends BaseAppNavigator{


    /*controlador do quiz que será compartilhado com as diferentes telas
     * da aplicação.
     */
    private ControladorQuiz controladorQuiz;


    /*método utilizado para inicializar dependências da aplicação. Este
     * método é executado sempre uma vez no início da aplicação.
     */
    @Override
    public void init() throws Exception {
        super.init();

        /*Cria uma lista de questões e passa para controlador */
        ArrayList<Questao> lista = new ArrayList<>();

        lista.add(new Questao("Qual a capital do Paraná?", "Curitiba", new String[]{"Floripa", "Porto Alegre", "São Paulo"}));
        lista.add(new Questao("Qual a capital de São Paulo?", "São Paulo", new String[]{"Floripa", "Rio de Janeiro", "Campo Grande"}));
        lista.add(new Questao("Qual a capital do Acre?", "Rio Branco", new String[]{"Manaus","Palmas", "João Pessoa"}));
        lista.add(new Questao("Qual a capital de Rondonia?", "Porto Velho", new String[]{"Belém", "Macapá", "Manaus"}));

        controladorQuiz = new ControladorQuiz(lista);
    }

    /*método para indicar qual é a tela inicial da aplicação */
    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    /*método para indicar o nome da aplicação */
    @Override
    public String getAppTitle() {
        return "Quiz App";
    }

    /*método para registrar as telas da aplicação*/
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class,"principal.fxml",o->new TelaPrincipal()));
        registraTela("GERENCIADOR", new ScreenRegistryFXML(App.class, "gerenciarquestoes.fxml",o->new TelaGerenciador(controladorQuiz)));
    }
    
}
