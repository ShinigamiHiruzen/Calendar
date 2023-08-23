import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calendario.Data;
import controller.Agendador;
import exceptions.ErrorAgendadorException;
import exceptions.ErrorDataException;

public class App {
    public static void main(String[] args) {

        //Calendário
        int dia, mes, ano, modificarDia, modificarMes, modificarAno;

        //Aplicação
        int escolha, opcao, result, quantidadeDias, diaAula;

        //Objetos
        Data validacaoCalendario = null;
        Agendador agendador = new Agendador();
        
        try {
            do {
                JPanel panel = new JPanel();

                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Escolha uma das opções baixo:
                        | 1 - Criar uma Data
                        | 2 - Exibir uma Data
                        | 3 - Avançar uma Data
                        | 4 - Alterar uma Data
                        | 9 - Sair
                        """));

                switch (escolha) {

                    case 1 ->{

                        panel.add(new JLabel("Dia:"));
                        JTextField diaField = new JTextField(5);
                        panel.add(diaField);
                        
                        panel.add(new JLabel("Mês:"));
                        JTextField mesField = new JTextField(5);
                        panel.add(mesField);
                        
                        panel.add(new JLabel("Ano:"));
                        JTextField anoField = new JTextField(5);
                        panel.add(anoField);

                        result = JOptionPane.showConfirmDialog(null, panel, "Validação de datas", JOptionPane.OK_CANCEL_OPTION);
                        
                        if (result == JOptionPane.OK_OPTION) {
                            dia = Integer.parseInt(diaField.getText());
                            mes = Integer.parseInt(mesField.getText());
                            ano = Integer.parseInt(anoField.getText());            
                            
                            validacaoCalendario = new Data(dia, mes, ano);

                            try {
                                agendador.agendarDataAulas(validacaoCalendario);
                            } catch (ErrorAgendadorException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                            JOptionPane.showMessageDialog(null, "Data Valida!");
                        }                 
                    }         
                    
                    case 2 ->{

                        diaAula = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                Digite o dia da aula que deseja consultar:
                                """));

                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                Selecione o modelo de impressão da data:
                                | 1 - Imprimir apenas o dia
                                | 2 - Imprimir apenas o mês
                                | 3 - Imprimir apenas o ano
                                | 4 - Imprimir a data formatada  
                                | 9 - Sair                                
                            """));

                        switch (opcao) {

                            case 1 -> {
                                try {
                                    int dataAula = agendador.consultarDataAula(diaAula, opcao);
                                    JOptionPane.showMessageDialog(null, "Dia: " + dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }


                            case 2 -> {
                                try {
                                    int dataAula = agendador.consultarDataAula(diaAula, opcao);
                                    JOptionPane.showMessageDialog(null,"Mês: " + dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }


                            case 3 -> {
                                try {
                                    int dataAula = agendador.consultarDataAula(diaAula, opcao);
                                    JOptionPane.showMessageDialog(null,"Ano: " + dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }


                            case 4 -> {

                                try {
                                    String dataAula = agendador.consultarDataAula(diaAula);
                                    JOptionPane.showMessageDialog(null, dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }                        
                    }
                    
                    case 3 ->{

                        diaAula = Integer.parseInt(JOptionPane.showInputDialog("""
                                Digite o dia da aula que você deseja adiar:
                                """));

                        quantidadeDias = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            Digite a quantidade dias que você deseja avançar:
                        """));

                        agendador.adiarDataAula(diaAula, quantidadeDias);
                    }
                    
                    case 4 -> {

                        diaAula = Integer.parseInt(JOptionPane.showInputDialog("""
                                Insira o dia da aula que deseja alterar:
                                """));
                        panel.add(new JLabel("Dia:"));
                        JTextField alterarDia = new JTextField(5);
                        panel.add(alterarDia);

                        panel.add(new JLabel("Mês:"));
                        JTextField alterarMes = new JTextField(5);
                        panel.add(alterarMes);

                        panel.add(new JLabel("Ano:"));
                        JTextField alterarAno = new JTextField(5);
                        panel.add(alterarAno);

                        result = JOptionPane.showConfirmDialog(null, panel, "Validação de datas", JOptionPane.OK_CANCEL_OPTION);

                        if (result == JOptionPane.OK_OPTION) {

                            modificarDia = Integer.parseInt(alterarDia.getText());
                            modificarMes = Integer.parseInt(alterarMes.getText());
                            modificarAno = Integer.parseInt(alterarAno.getText());

                            agendador.alterarDataAula(diaAula, modificarDia,modificarMes, modificarAno);

                            JOptionPane.showMessageDialog(null, "Data Valida!");
                        }
                    }

                    case 9 -> {
                        JOptionPane.showMessageDialog(null, "Saindo da aplicação...");
                    }                    
                }                
            } while (escolha != 9);             
        } catch (ErrorDataException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}