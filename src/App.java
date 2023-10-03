import calendario.DataHora;
import controller.AgendadorDataHora;
import exceptions.ErrorAgendadorException;
import exceptions.ErrorDataException;
import telas.AppAntigo;
import telas.AppNovo;

//Corrigir as janelas
import javax.swing.*;

public class App extends JFrame{

    DataHora dataHora = null;
    AgendadorDataHora agendaDataHora = new AgendadorDataHora ();

    public App () {
        Painel = new javax.swing.JPanel();
        exibirData = new javax.swing.JButton();
        criarData = new javax.swing.JButton();
        adiarData = new javax.swing.JButton();
        alterarData = new javax.swing.JButton();
        texto = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frame"); // NOI18N
        setResizable(false);

        Painel.setBackground(new java.awt.Color(153, 153, 153));
        Painel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Painel.setName("painel"); // NOI18N

        exibirData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exibirData.setText("Exibir uma data");
        exibirData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exibirData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirDataActionPerformed(evt);
            }
        });

        criarData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criarData.setText("Criar uma data");
        criarData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        criarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    criarDataActionPerformed(evt);
                }
                catch (ErrorDataException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        adiarData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        adiarData.setText("Adiar uma data");
        adiarData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adiarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adiarDataActionPerformed(evt);
            }
        });

        alterarData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alterarData.setText("Alterar uma data");
        alterarData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarDataActionPerformed(evt);
            }
        });

        texto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setText(" Escolha uma das opções baixo:");

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Bem-vindo à agenda SENAI");

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
                PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PainelLayout.createSequentialGroup()
                                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(criarData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alterarData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(adiarData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(exibirData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(45, 45, 45))
                                        .addGroup(PainelLayout.createSequentialGroup()
                                                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(12, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
        );
        PainelLayout.setVerticalGroup(
                PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(titulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(exibirData)
                                        .addComponent(criarData))
                                .addGap(53, 53, 53)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adiarData)
                                        .addComponent(alterarData))
                                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Painel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    private void exibirDataActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int diaAula =
                Integer.parseInt (JOptionPane.showInputDialog (null, """
                        Digite o dia da aula que deseja consultar:
                        """));

        int opcao =
                Integer.parseInt (JOptionPane.showInputDialog (null, """
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
                    int dataAula =
                            agendaDataHora.consultarDataHoraAulas (diaAula, opcao, dataHora);
                    JOptionPane.showMessageDialog (null, "Dia: " +
                            dataAula);
                }
                catch (ErrorAgendadorException e) {
                    JOptionPane.showMessageDialog (null, e.getMessage (), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            case 2 -> {
                try {
                    int dataAula =
                            agendaDataHora.consultarDataHoraAulas (diaAula, opcao, dataHora);
                    JOptionPane.showMessageDialog (null, "Mês: " +
                            dataAula);
                }
                catch (ErrorAgendadorException e) {
                    JOptionPane.showMessageDialog (null, e.getMessage (), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            case 3 -> {
                try {
                    int dataAula =
                            agendaDataHora.consultarDataHoraAulas (diaAula, opcao, dataHora);
                    JOptionPane.showMessageDialog (null, "Ano: " +
                            dataAula);
                }
                catch (ErrorAgendadorException e) {
                    JOptionPane.showMessageDialog (null, e.getMessage (), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            case 4 -> {

                try {
                    String dataAula =
                            agendaDataHora.consultarDataHoraAulas (diaAula, dataHora);
                    JOptionPane.showMessageDialog (null, dataAula);
                }
                catch (ErrorAgendadorException e) {
                    JOptionPane.showMessageDialog (null, e.getMessage (), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    private void criarDataActionPerformed(java.awt.event.ActionEvent evt) throws ErrorDataException {


        Painel.add(new JLabel ("Dia:"));
        JTextField diaField = new JTextField (5);
        Painel.add (diaField);

        Painel.add (new JLabel ("Mês:"));
        JTextField mesField = new JTextField (5);
        Painel.add (mesField);

        Painel.add (new JLabel ("Ano:"));
        JTextField anoField = new JTextField (5);
        Painel.add (anoField);

        Painel.add (new JLabel ("Hora: "));
        JTextField horaField = new JTextField (5);
        Painel.add (horaField);

        Painel.add (new JLabel ("Minuto:"));
        JTextField minutoField = new JTextField (5);
        Painel.add (minutoField);

        Painel.add (new JLabel ("Segundo:"));
        JTextField segundoField = new JTextField (5);
        Painel.add (segundoField);

        result = JOptionPane.showConfirmDialog (null,
                Painel, "Validação de datas",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION){
            dia = Integer.parseInt (diaField.getText ());
            mes = Integer.parseInt (mesField.getText ());
            ano = Integer.parseInt (anoField.getText ());
            hora = Integer.parseInt (horaField.getText ());
            minuto = Integer.parseInt (mesField.getText ());
            segundo =
                    Integer.parseInt (segundoField.getText ());
        }
        try{
            dataHora = new DataHora (dia, mes, ano, hora,
                    minuto, segundo);
            agendaDataHora.agendarDataHoraAulas (dataHora);
        }catch (ErrorAgendadorException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void adiarDataActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void alterarDataActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JPanel Painel;
    private javax.swing.JButton adiarData;
    private javax.swing.JButton alterarData;
    private javax.swing.JButton criarData;
    private javax.swing.JButton exibirData;
    private javax.swing.JLabel texto;
    private javax.swing.JLabel titulo;
    private int hora, minuto, segundo, modificarHora, modificarMinuto, modificarSegundo;
    private int result;
    private int dia, mes, ano, modificarDia, ModificarMes, modificarAno;
    // End of variables declaration



    public static void main(String[] args) {

        App app = new App ();
        app.setVisible (true);
    }
}