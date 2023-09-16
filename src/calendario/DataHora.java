package calendario;

import exceptions.ErrorDataException;

public class DataHora extends Data{

    private int hora, minuto, segundo;

    public DataHora(int dia, int mes, int ano, int hora, int minuto, int segundo) throws ErrorDataException {

        super(dia, mes, ano);

        if (validarDataHora(hora, minuto, segundo)){
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;
        }else{
            throw new ErrorDataException("Horário Inválido!");
        }
    }

    //SETTERS
    private boolean validarDataHora(int hora, int minuto, int segundo){
        return (hora >= 0 && hora <= 23 && minuto >= 0 && minuto <= 59 && segundo >= 0 && segundo <= 59);
    }

    public void alterarDataHora(int dia, int mes, int ano, int hora, int minuto, int segundo) throws ErrorDataException {
        if (super.validarData(dia, mes, ano) && validarDataHora(hora, minuto, segundo)){
            super.alterarData(dia, mes, ano);
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;
        }else{
            throw new RuntimeException("Data Inválida!");
        }
    }

    //GETTERS
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public String horaFormatada(){
        return hora + ":" + minuto + ":" + segundo;
    }
    @Override
    public String dataFormatada() {
        return super.dataFormatada() + "|" + horaFormatada();
    }

}
