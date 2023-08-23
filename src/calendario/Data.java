package calendario;

import exceptions.ErrorDataException;

public class Data {
    
    //Calendário
    private int dia, mes, ano, bissexto;
    
    //CONSTRUTOR
    public Data(int dia, int mes, int ano) throws ErrorDataException{   

        bissexto = ano % 4;

       if (ano > 0 && dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12) {
            if ((mes == 2 && bissexto == 0 && dia <= 29) || (mes == 2 && bissexto != 0 && dia <= 28) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30 ) || (mes != 2 && mes != 4 && mes != 6 && mes != 9 && mes != 11)) {

                this.dia = dia;
                this.mes = mes;
                this.ano = ano;
            }else{
                throw new ErrorDataException("Data Invalida!");
            }
       }else {
            throw new ErrorDataException("Data Invalida!");
       }
    }

    public int alterarData(int dia, int mes, int ano) throws ErrorDataException{

        bissexto = ano % 4;

        if (ano > 0 && dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12) {
            if ((mes == 2 && bissexto == 0 && dia <= 29) || (mes == 2 && bissexto != 0 && dia <= 28) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30 ) || (mes != 2 && mes != 4 && mes != 6 && mes != 9 && mes != 11)) {

                this.dia = dia;
                this.mes = mes;
                this.ano = ano;
            }else{
                throw new ErrorDataException("Data Invalida!");
            }
        }else {
            throw new ErrorDataException("Data Invalida!");
       }
       return 1;
    }

    public Data avancarDias(int quantidadeDias) throws ErrorDataException{

        if (quantidadeDias <= 0) {
            throw new ErrorDataException("Quantidade de dias inválida!");
        }
        
        int[] diasMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (bissexto == 0) {
            diasMes[2] = 29;
        }

        for(int i = 0; i < quantidadeDias; i++){
            dia++;
            if (dia > diasMes[mes]) {
                dia = 1;
                mes++;
            }
                if (mes > 12) {
                    mes = 1;
                    ano++;
                }
                    if (bissexto == 0) {
                        diasMes[2] = 29;
                    }
        }
        return null;
    }
   
    //GETTERS
    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }

    public String dataFormatada(){
        return getDia()+"/"+getMes()+"/"+getAno();
    }
}