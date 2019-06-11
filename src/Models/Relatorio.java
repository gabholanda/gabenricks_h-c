/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author patrick.chagas
 */
public class Relatorio {

    String DataInicio;
    String DataFinal;

    public Relatorio() {

    }

    public Relatorio(String dataInicio, String dataFinal) {
        this.DataInicio = dataInicio;
        this.DataFinal = dataFinal;
    }

    public String getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(String DataInicio) {
        this.DataInicio = DataInicio;
    }

    public String getDataFinal() {
        return DataFinal;
    }

    public void setDataFinal(String DataFinal) {
        this.DataFinal = DataFinal;
    }
}
