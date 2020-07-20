/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Words {
    String English,Vietnam,ExampleE,ExampleV;

    public Words() {
    }

    public Words(String English, String Vietnam, String ExampleE, String ExampleV) {
        this.English = English;
        this.Vietnam = Vietnam;
        this.ExampleE = ExampleE;
        this.ExampleV = ExampleV;
    }

    public Words(String English, String Vietnam) {
        this.English = English;
        this.Vietnam = Vietnam;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String English) {
        this.English = English;
    }

    public String getVietnam() {
        return Vietnam;
    }

    public void setVietnam(String Vietnam) {
        this.Vietnam = Vietnam;
    }

    public String getExampleE() {
        return ExampleE;
    }

    public void setExampleE(String Example) {
        this.ExampleE = Example;
    }

    public String getExampleV() {
        return ExampleV;
    }

    public void setExampleV(String ExampleV) {
        this.ExampleV = ExampleV;
    }
    
}
