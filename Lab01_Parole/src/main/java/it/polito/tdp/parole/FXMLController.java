package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private URL location;

    @FXML
    private TextField txtParola;
    
    @FXML
    private TextArea txtTempo;
    
    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
 	long start, end;
 	
    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	start = 0;
    	end = 0;
    	start = System.nanoTime();
    	elenco.addParola(txtParola.getText());
        String ss = "";
        
    	for (String s : elenco.getElenco()) {
    		ss = ss + s + "\n";
    	}
    	
    	txtResult.setText(ss);
    	end = System.nanoTime();
    	txtTempo.setText("Tempo di esecuzione: " + (end-start));
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	start = 0;
    	end = 0;
    	start = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	end = System.nanoTime();
    	txtTempo.setText("Tempo di esecuzione: " + (end-start));
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	start = 0;
    	end = 0;
    	start = System.nanoTime();
    	String stringaSelezionata = txtResult.getSelectedText();
    	elenco.eliminaParola(stringaSelezionata);
    	
    	String sss = "";
    	for (String s : elenco.getElenco()) {
    		sss = sss + s + "\n";
    	}
    	
    	txtResult.setText(sss);
    	end = System.nanoTime();
    	txtTempo.setText("Tempo di esecuzione: " + (end-start));
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
