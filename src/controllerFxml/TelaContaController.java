package controllerFxml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import controller.ControlUsuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class TelaContaController implements Initializable{
    
    //BARRA SUPERIOR
    @FXML
    private Pane barra;
    
    @FXML
    private ImageView btnVoltar;

    @FXML
    private ImageView btnFechar;

    @FXML
    private ImageView btnMinimizar;
    
    @FXML
    private ImageView imgCarrinho;

    @FXML
    private Circle circleUsu;

    @FXML
    private Label lbNomeUsuario;

    @FXML
    private TextField tfPesquisa;

    @FXML
    private ImageView imgLupa;

    //Modal things
    
    @FXML
    private Pane pnModal;

    @FXML
    private Button btnTelaConta;
    
    @FXML
    private Button btnTelaBiblioteca;

    @FXML
    private Button btnTelaDesejo;

    @FXML
    private Button btnTelaAdmin;

    @FXML
    private Line linha4;

    //Campos para edicao
    @FXML
    private Circle circleUsu2;

    @FXML
    private Label lbConfirmaFoto;

    @FXML
    private ImageView imgConfirmaFoto;

    @FXML
    private ImageView imgCancelaFoto;
    
    private String caminhoImg;

    @FXML
    private Label lbNovoNome;

    @FXML
    private TextField tfNovoNome;

    @FXML
    private ImageView imgUpdateNome;

    //parte inferior
    @FXML
    private Label lbSairConta;

    @FXML
    private ImageView imgSairConta;

    @FXML
    private Label lbExcluirConta;

    @FXML
    private ImageView imgExcluirConta;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        preLoadDados();

        Helper.preLoadComum(barra, btnVoltar, btnMinimizar, btnFechar, lbNomeUsuario, circleUsu, imgLupa, imgCarrinho, btnTelaConta, btnTelaBiblioteca, 
                            btnTelaDesejo, btnTelaAdmin, tfPesquisa, pnModal, linha4);

                            
        circleUsu2.setOnMouseClicked((MouseEvent e)->{
            selecionaFoto();
            lbConfirmaFoto.setVisible(true);
            imgConfirmaFoto.setVisible(true);
            imgCancelaFoto.setVisible(true);
        });
        
        imgConfirmaFoto.setOnMouseClicked((MouseEvent e)->{
            ControlUsuario cu = new ControlUsuario();
            cu.alterarFotoUsuario(caminhoImg);
            Main.usuImg = caminhoImg;
            SceneController sc = new SceneController();
            try {
                sc.switchTelaConta(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
             
        });

        imgCancelaFoto.setOnMouseClicked((MouseEvent e)->{
            lbConfirmaFoto.setVisible(false);
            imgConfirmaFoto.setVisible(false);
            imgCancelaFoto.setVisible(false);
            Image usuImage = new Image(Main.usuImg, false);
            circleUsu2.setFill(new ImagePattern(usuImage));

        });
        
        imgUpdateNome.setOnMouseClicked((MouseEvent e)->{
            ControlUsuario cu = new ControlUsuario();
            if(tfNovoNome.getText() != "" || tfNovoNome.getText() != null){
                cu.alterarNomeUsuario(tfNovoNome.getText());
                Main.nomeUsuario = tfNovoNome.getText();
                SceneController sc = new SceneController();
                try {
                    sc.switchTelaConta(e);
                } catch (IOException e1) {

                    e1.printStackTrace();
                }
            }
             
        });

        lbSairConta.setOnMouseClicked((MouseEvent e)->{
            SceneController sc = new SceneController();
            try {
                sc.switchTelaLogin(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        imgSairConta.setOnMouseClicked((MouseEvent e)->{
            SceneController sc = new SceneController();
            try {
                sc.switchTelaLogin(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        lbExcluirConta.setOnMouseClicked((MouseEvent e)->{
            
            SceneController sc = new SceneController();
            try {
                sc.switchTelaLogin(e);
                ControlUsuario cu = new ControlUsuario();
                cu.deletarUsuario(Main.idIdent);
            } catch (IOException e1) {
                e1.printStackTrace();
            }      
        });

        imgExcluirConta.setOnMouseClicked((MouseEvent e)->{
            
            SceneController sc = new SceneController();
            try {
                sc.switchTelaLogin(e);
                ControlUsuario cu = new ControlUsuario();
                cu.deletarUsuario(Main.idIdent);
            } catch (IOException e1) {
                e1.printStackTrace();
            }      
        });
    }

    private void selecionaFoto(){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Imagens","*.png", "*.jpg", "*.jpeg", "*.gif")); 
        File file = fc.showOpenDialog(new Stage());
        //se der erro no notebook, colcoar ali em baixo o "file:///"+
        if(file != null){
            Image Img = new Image(file.getAbsolutePath(), false);
            circleUsu2.setFill(new ImagePattern(Img));
            caminhoImg = file.getAbsolutePath();
        }}
     
    private void preLoadDados(){
        Image usuImage = new Image(Main.usuImg, false);
        circleUsu2.setFill(new ImagePattern(usuImage));
        lbNovoNome.setText(Main.nomeUsuario);
    }
    
}
