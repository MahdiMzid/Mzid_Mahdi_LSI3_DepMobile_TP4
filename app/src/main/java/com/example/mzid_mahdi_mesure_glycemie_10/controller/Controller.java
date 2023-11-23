package com.example.mzid_mahdi_mesure_glycemie_10.controller;
import com.example.mzid_mahdi_mesure_glycemie_10.model.Patient;
public class Controller {
    //private static Controller instance = null;
    private static Patient patient;
    /*private Controller(){
    super();
    }
    public static final Controller getInstance(){
    if(Controller.instance == null)
    Controller.instance = new Controller();
    return Controller.instance;
    }*/
    public Controller()
    {
        super();
    }
    //Flèche "Update" Controller --> Model
    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        patient = new Patient(age, valeurMesuree, isFasting);
    }
    //Flèche "Notify" Model --> Controller
    public String getReponse() {
        return patient.getReponse();
    }
}
