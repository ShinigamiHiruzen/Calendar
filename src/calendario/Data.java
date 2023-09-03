package calendario;

import exceptions.ErrorDataException;

public class Data {
    
    //Calendário
    private int dia, mes, ano;
    private boolean bissexto;
    
    //CONSTRUTOR
    public Data(int dia, int mes, int ano) throws ErrorDataException{

       if (validarData(dia, mes, ano)) {

            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    protected boolean validarData(int dia, int mes, int ano) throws ErrorDataException{

        bissexto = ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0);

        if (ano > 0 && dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12) {
            if ((mes == 2 && bissexto && dia <= 29) || (mes == 2 && !bissexto && dia <= 28) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30 ) || (mes != 2 && mes != 4 && mes != 6 && mes != 9 && mes != 11)) {
                return true;
            }else{
                throw new ErrorDataException("Data Invalida!");
            }
        }

        return false;
    }

    public boolean alterarData(int dia, int mes, int ano) throws ErrorDataException {

       if (validarData(dia, mes, ano)){

            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
            return true;

       }
        return false;
    }

    public Data avancarDias(int quantidadeDias) throws ErrorDataException{

        if (quantidadeDias <= 0) {
            throw new ErrorDataException("Quantidade de dias inválida!");
        }
        
        int[] diasMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (bissexto) {
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
                    if (!bissexto) {
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