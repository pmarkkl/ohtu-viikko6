
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa implements Komento {
    
    private TextField tuloskentta, syotekentta;
    private Button nollaa, undo;
    private Sovelluslogiikka sovellus;
    private int edellinenTulos;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    @Override
    public void suorita() {
        this.edellinenTulos = sovellus.tulos();
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        int tulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        if (tulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + this.edellinenTulos);
        if (this.edellinenTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    }
    
}
