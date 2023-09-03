package controller;

import calendario.Data;
import calendario.DataHora;
import exceptions.ErrorAgendadorException;
import exceptions.ErrorDataException;
import java.util.ArrayList;
import java.util.List;

public class AgendadorDataHora extends AgendadorData {

    private List <DataHora> dataList;

    public AgendadorDataHora(){
        dataList = new ArrayList<>();
    }

    public void agendarDataHoraAulas(DataHora data) throws ErrorAgendadorException {
        super.agendarDataAula(data);
    }

    public String consultarDataHoraAulas(int diaAula, DataHora dataFormatada) throws ErrorAgendadorException {
       super.consultarDataAula(diaAula, dataFormatada);
       return null;
    }

    public int consultarDataHoraAulas(int diaAula, int escolha, DataHora dataFormatada) throws ErrorAgendadorException {
        if (diaAula >= 0 && diaAula < dataList.size() && escolha >= 1 && escolha <= 3) {
            dataFormatada = dataList.get(diaAula);
            if (dataFormatada != null){
                if (escolha == 1){
                    return dataFormatada.getHora();
                } else if (escolha == 2) {
                    return dataFormatada.getMinuto();
                } else {
                    return dataFormatada.getSegundo();
                }
            }
        } else{
            throw new ErrorAgendadorException("Data da aula inexistente!");
        }
        return 1;
    }

    public void alterarDataHoraAulas(int diaAula, int dia, int mes, int ano, int hora, int minuto, int segundo, DataHora obterDataAula) throws ErrorDataException {
        if (diaAula >= 0 && diaAula < dataList.size()){

            obterDataAula = dataList.get(diaAula);
            obterDataAula.alterarDataHora(dia, mes, ano, hora, minuto, segundo);
        }else {
            throw new ErrorDataException("Data de aula inválida ou inexistente!");
        }
    }

    public void adiarDataHoraAulas(int diaAula, int quantidadeDias, DataHora obterDataAula) throws ErrorDataException{
       super.adiarDataAula(diaAula, quantidadeDias, obterDataAula);
    }
}