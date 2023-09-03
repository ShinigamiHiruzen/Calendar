package controller;

import java.util.List;

import calendario.Data;
import exceptions.ErrorAgendadorException;
import exceptions.ErrorDataException;

import java.util.ArrayList;

public class AgendadorData {
    
    private List <Data> datasAulas;

    public AgendadorData(){
        datasAulas = new ArrayList<>();
    }
    
    public void agendarDataAula(Data data) throws ErrorAgendadorException{
        if (datasAulas.size() < 10) {
            datasAulas.add(data);
        }else{
            throw new ErrorAgendadorException("O limite de aula foi atingido!");
        }
    }

    public String consultarDataAula(int diaAula, Data dataFormatada) throws ErrorAgendadorException{
        if (diaAula >= 0 && diaAula < datasAulas.size()) {
            dataFormatada = datasAulas.get(diaAula);
            if (dataFormatada != null) {
                return dataFormatada.dataFormatada();
            } else {
                throw new ErrorAgendadorException("Data da aula inexistente!");
            }
        }else{
            throw new ErrorAgendadorException("Data da aula inexistente!");
        }
    }

    public int consultarDataAula(int diaAula, int escolha, Data dataFormatada) throws ErrorAgendadorException{
        if (diaAula >= 0 && diaAula < datasAulas.size() && escolha >= 1 && escolha <= 3){
            dataFormatada = datasAulas.get(diaAula);
            if (dataFormatada != null) {
                if (escolha == 1){
                    return dataFormatada.getDia();
                } else if (escolha == 2) {
                    return dataFormatada.getMes();
                } else {
                    return dataFormatada.getAno();
                }
            } else {
                throw new ErrorAgendadorException("Data da aula inexistente!");
            }
        }
        return 1;
    }

    public void adiarDataAula(int diaAula, int quantidadeDias, Data obterDataAula) throws ErrorDataException{
        if (diaAula >= 0 && diaAula < datasAulas.size()) {

            obterDataAula = datasAulas.get(diaAula);
            obterDataAula.avancarDias(quantidadeDias);

            datasAulas.set(diaAula, obterDataAula);
        }else{
            throw new ErrorDataException("Data da aula inválida ou inexistente!");
        }
    }

    public void alterarDataAula(int diaAula, int dia, int mes, int ano, Data obterDataAula) throws ErrorDataException {

        if (diaAula >= 0 && diaAula < datasAulas.size()){

            obterDataAula = datasAulas.get(diaAula);
            obterDataAula.alterarData(dia, mes, ano);
        }else {
            throw new ErrorDataException("Data de aula inválida ou inexistente!");
        }
    }

}