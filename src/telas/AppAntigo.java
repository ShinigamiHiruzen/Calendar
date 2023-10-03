package telas;

import calendario.DataHora;
import controller.AgendadorDataHora;
import exceptions.ErrorAgendadorException;
import exceptions.ErrorDataException;

import javax.swing.*;

public class AppAntigo {
    private int dia, mes, ano, modificarDia, modificarMes, modificarAno;
    private int hora, minuto, segundo, modificarHora, modificarMinuto, modificarSegundo;

    //Aplicação
    private int escolha, opcao, result, quantidadeDias, diaAula;

    public AppAntigo(){
        initComponents ();
    }

    private void initComponents(){
        try {
            DataHora validacaoDataHora = null;
            AgendadorDataHora agendadorData = new AgendadorDataHora();
            do {
                JPanel panel = new JPanel();

                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Escolha uma das opções baixo:
                        | 1 - Criar uma Data
                        | 2 - Exibir uma Data
                        | 3 - Alterar uma Data
                        | 4 - Adiar uma Data
                        | 9 - Sair
                        """));

                switch (escolha) {

                    case 1 -> {

                        panel.add(new JLabel("Dia:"));
                        JTextField diaField = new JTextField(5);
                        panel.add(diaField);

                        panel.add(new JLabel("Mês:"));
                        JTextField mesField = new JTextField(5);
                        panel.add(mesField);

                        panel.add(new JLabel("Ano:"));
                        JTextField anoField = new JTextField(5);
                        panel.add(anoField);

                        panel.add(new JLabel("Hora:"));
                        JTextField horaField = new JTextField(5);
                        panel.add(horaField);

                        panel.add(new JLabel("Minuto:"));
                        JTextField minutoField = new JTextField(5);
                        panel.add(minutoField);

                        panel.add(new JLabel("Segundo:"));
                        JTextField segundoField = new JTextField(5);
                        panel.add(segundoField);

                        result = JOptionPane.showConfirmDialog(null, panel, "Validação de datas", JOptionPane.OK_CANCEL_OPTION);

                        if (result == JOptionPane.OK_OPTION) {
                            dia = Integer.parseInt(diaField.getText());
                            mes = Integer.parseInt(mesField.getText());
                            ano = Integer.parseInt(anoField.getText());
                            hora = Integer.parseInt(horaField.getText());
                            minuto = Integer.parseInt(minutoField.getText());
                            segundo = Integer.parseInt(segundoField.getText());


                            validacaoDataHora = new DataHora(dia, mes, ano, hora, minuto, segundo);

                            try {
                                agendadorData.agendarDataHoraAulas(validacaoDataHora);
                            } catch (
                                    ErrorAgendadorException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                            JOptionPane.showMessageDialog(null, "Data Valida!");
                        }
                    }

                    case 2 -> {

                        diaAula = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                Digite o dia da aula que deseja consultar:
                                """));

                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                Selecione o modelo de impressão da data:
                                | 1 - Imprimir apenas a hora
                                | 2 - Imprimir apenas o minuto
                                | 3 - Imprimir apenas o segundo
                                | 4 - Imprimir a data formatada  
                                | 9 - Sair                                
                            """));

                        switch (opcao) {

                            case 1 -> {
                                try {
                                    int dataAula = agendadorData.consultarDataHoraAulas(diaAula, opcao, validacaoDataHora);
                                    JOptionPane.showMessageDialog(null, "Dia: " + dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }


                            case 2 -> {
                                try {
                                    int dataAula = agendadorData.consultarDataHoraAulas(diaAula, opcao, validacaoDataHora);
                                    JOptionPane.showMessageDialog(null,"Mês: " + dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }


                            case 3 -> {
                                try {
                                    int dataAula = agendadorData.consultarDataHoraAulas(diaAula, opcao, validacaoDataHora);
                                    JOptionPane.showMessageDialog(null,"Ano: " + dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }


                            case 4 -> {

                                try {
                                    String dataAula = agendadorData.consultarDataHoraAulas(diaAula, validacaoDataHora);
                                    JOptionPane.showMessageDialog(null, dataAula);
                                } catch (ErrorAgendadorException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }

                    case 3 -> {

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

                        panel.add(new JLabel("Ano:"));
                        JTextField alterarHora = new JTextField(5);
                        panel.add(alterarHora);

                        panel.add(new JLabel("Ano:"));
                        JTextField alterarMinuto = new JTextField(5);
                        panel.add(alterarMinuto);

                        panel.add(new JLabel("Ano:"));
                        JTextField alterarSegundo = new JTextField(5);
                        panel.add(alterarSegundo);

                        result = JOptionPane.showConfirmDialog(null, panel, "Validação de datas", JOptionPane.OK_CANCEL_OPTION);

                        if (result == JOptionPane.OK_OPTION) {

                            modificarDia = Integer.parseInt(alterarDia.getText());
                            modificarMes = Integer.parseInt(alterarMes.getText());
                            modificarAno = Integer.parseInt(alterarAno.getText());
                            modificarHora = Integer.parseInt(alterarHora.getText());
                            modificarMinuto= Integer.parseInt(alterarMinuto.getText());
                            modificarSegundo = Integer.parseInt(alterarSegundo.getText());


                            agendadorData.alterarDataHoraAulas(diaAula, modificarDia,modificarMes, modificarAno, modificarHora, modificarMinuto, modificarSegundo, validacaoDataHora);

                            JOptionPane.showMessageDialog(null, "Data Valida!");
                        }
                    }

                    case 4 -> {
                        diaAula = Integer.parseInt(JOptionPane.showInputDialog("""
                                Insira o dia da aula que deseja adiar:
                                """));
                        quantidadeDias = Integer.parseInt(JOptionPane.showInputDialog("""
                                Insira a quantidade de dias:
                                """));

                        agendadorData.adiarDataHoraAulas(diaAula, quantidadeDias, validacaoDataHora);
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
