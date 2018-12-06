/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadastroFrames;
import Objetos.*;
import Util.FormatoDataHora;
import gerenciador.de.igreja.GerenciadorFrame;
import gerenciador.de.igreja.TestadorString;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elise
 */
public class CadFrameEvento extends javax.swing.JFrame {

    
    private GerenciadorFrame gerenciador;
    private List<Evento> eventos;
    private Evento eventoSelecionado;
    
    /**
     * Creates new form CadFrameEvento
     */
    public CadFrameEvento(GerenciadorFrame gerenciador) {
        initComponents();
        preencherEventos();
        this.gerenciador = gerenciador;
    }
    
    public CadFrameEvento(GerenciadorFrame gerenciador, Evento evento) {
        initComponents();
        preencherEventos();
        this.gerenciador = gerenciador;
        this.eventoSelecionado = evento;
        preencherCamposEventoSelecionado();
    }
    
    public final void preencherCamposEventoSelecionado(){
        txtTema.setText(eventoSelecionado.getId().getTema());
        txtData.setText(FormatoDataHora.userData(eventoSelecionado.getId().getDiaHora()));
        txtHora.setText(FormatoDataHora.userHora(eventoSelecionado.getId().getDiaHora()));
        txtPublicoAlvo.setText(eventoSelecionado.getPublicoAlvo());
        txtTipo.setText(eventoSelecionado.getTipo());
        panelGeral.setSelectedIndex(1);
        ckboxAtualizar.setSelected(true);
    }
    
    public final void preencherEventos(){
        boolean sTema, sData, sHora;
        String temaEvento = txtTemaEvento.getText();
        String dataEvento = txtDataEvento.getText();
        String horaEvento = txtHoraEvento.getText();
        sTema = !temaEvento.isEmpty();
        sData = !dataEvento.equals("  /  /    ");
        sHora = !horaEvento.equals("  :  ");
        Date date = null;
        if (sData){
            date = FormatoDataHora.getData(txtDataEvento.getText());
        }
        String[] horas;
        //System.out.println(txtHoraEvento.getText());
        if (sData && sHora){
            horas = horaEvento.split(":");
            date.setHours(Integer.parseInt(horas[0]));
            date.setMinutes(Integer.parseInt(horas[1]));
            date.setSeconds(0);
        }
        DefaultTableModel model = (DefaultTableModel) tabelaEventos.getModel();
        model.setNumRows(0);
        Evento eventoUnico;
        if (sTema){
            if (sData){
                if (sHora){
                    eventos = new ArrayList();
                    eventoUnico = Evento.selectEventoPk(temaEvento, date);
                    eventos.add(eventoUnico);
                }
                else{
                    eventos = Evento.selectEventoPorTemaeDia(temaEvento, date);
                }
            }
            else{
                eventos = Evento.selectEventoPorTema(temaEvento, Ordem.DECRESCENTE);
            }
        }
        else if(sData){
            eventos = Evento.selectEventoPorData(date, sHora);
        }
        else{
            //listar todos
            eventos = Evento.listarTodos(Ordem.DECRESCENTE);
        }
        Object[] objs = new Object[3];
        for (Evento evento: eventos){
            objs[0] = evento.getId().getTema();
            objs[1] = FormatoDataHora.userData(evento.getId().getDiaHora());
            objs[2] = FormatoDataHora.userHora(evento.getId().getDiaHora());
            model.addRow(objs);
        }
    }
    
    private void esvaziarCampos(){
        txtData.setText("  /  /    ");
        txtHora.setText("  :  ");
        txtTema.setText("");
        txtTipo.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeral = new javax.swing.JTabbedPane();
        panelRemover = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaEventos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTemaEvento = new javax.swing.JTextField();
        txtDataEvento = new javax.swing.JTextField();
        try{      javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");      txtDataEvento = new javax.swing.JFormattedTextField(data);  }catch(Exception e){        }
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtHoraEvento = new javax.swing.JTextField();
        try{      
            javax.swing.text.MaskFormatter hora = new javax.swing.text.MaskFormatter("##:##");      
            txtHoraEvento = new javax.swing.JFormattedTextField(hora);  
        }catch(Exception e){        }
        jLabel10 = new javax.swing.JLabel();
        btnSelecionar = new javax.swing.JButton();
        panelCadastrar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTema = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnFecharCad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPublicoAlvo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        try{      
            javax.swing.text.MaskFormatter hora = new javax.swing.text.MaskFormatter("##:##");      
            txtHora = new javax.swing.JFormattedTextField(hora);  }catch(Exception e){        }
        jLabel6 = new javax.swing.JLabel();
        ckboxAtualizar = new javax.swing.JCheckBox();

        setTitle("Connect Church - Eventos");

        panelGeral.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnExcluir.setBackground(new java.awt.Color(255, 204, 204));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deletar.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        tabelaEventos.setBackground(new java.awt.Color(255, 226, 226));
        tabelaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOME", "DATA", "HORA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEventos.setGridColor(new java.awt.Color(0, 102, 102));
        tabelaEventos.setSelectionBackground(new java.awt.Color(155, 126, 126));
        tabelaEventos.setShowHorizontalLines(false);
        tabelaEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEventosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaEventos);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Eventos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar2.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("Tema:");

        jLabel9.setText("Data:");

        jLabel10.setText("Hora:");

        btnSelecionar.setText("Selecionar");

        javax.swing.GroupLayout panelRemoverLayout = new javax.swing.GroupLayout(panelRemover);
        panelRemover.setLayout(panelRemoverLayout);
        panelRemoverLayout.setHorizontalGroup(
            panelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRemoverLayout.createSequentialGroup()
                .addGroup(panelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRemoverLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTemaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoraEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscar))
                    .addGroup(panelRemoverLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRemoverLayout.createSequentialGroup()
                                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelecionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)))))
                .addGap(52, 52, 52))
        );
        panelRemoverLayout.setVerticalGroup(
            panelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRemoverLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTemaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtHoraEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );

        panelGeral.addTab("Selecionar/Remover", panelRemover);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("*Tema:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("*Tipo:");

        btnCadastrar.setBackground(new java.awt.Color(153, 255, 204));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnFecharCad.setText("Fechar");
        btnFecharCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharCadActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Evento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Públic Alvo:");

        try{      
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");      
            txtData = new javax.swing.JFormattedTextField(data);  }catch(Exception e){        }

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("*Data:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("*Horário:");

        ckboxAtualizar.setText("Alterar existente");
        ckboxAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckboxAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCadastrarLayout = new javax.swing.GroupLayout(panelCadastrar);
        panelCadastrar.setLayout(panelCadastrarLayout);
        panelCadastrarLayout.setHorizontalGroup(
            panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastrarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelCadastrarLayout.createSequentialGroup()
                        .addComponent(ckboxAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFecharCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastrar))
                    .addGroup(panelCadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTema))
                    .addGroup(panelCadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPublicoAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addGap(40, 40, 40))
        );
        panelCadastrarLayout.setVerticalGroup(
            panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPublicoAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFecharCad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ckboxAtualizar))
                .addContainerGap())
        );

        panelGeral.addTab("Cadastrar", panelCadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeral, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 346, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try{    
            String tema = txtTema.getText();
            String publicoAlvo = TestadorString.testeEmpty(txtPublicoAlvo.getText());
            String tipo = TestadorString.testeEmpty(txtTipo.getText());
            Date dataEvento = FormatoDataHora.getData(txtData.getText());
            String[] horario = txtHora.getText().split(":");
            dataEvento.setHours(Integer.parseInt(horario[0]));
            dataEvento.setMinutes(Integer.parseInt(horario[1]));
            dataEvento.setSeconds(0);
            String feedback = "Evento cadastrado com successo";
            if (ckboxAtualizar.isSelected()){
                Evento.deletarEvento(eventoSelecionado);
                feedback = "Evento atualizado com successo";
            }
            Evento evento = new Evento(tema, dataEvento, publicoAlvo, tipo);
            Evento.cadastrarOuAtualizarEvento(evento);
            JOptionPane.showMessageDialog(null, feedback);
            gerenciador.refresh();
            preencherEventos();
            esvaziarCampos();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique todos os campos obrigatórios. Erro: "+e.toString());
        }
            
    }//GEN-LAST:event_btnCadastrarActionPerformed
    
    private void btnFecharCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharCadActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            this.dispose();
        } catch (Throwable ex) {
            Logger.getLogger(CadFrameEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFecharCadActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            this.dispose();
        } catch (Throwable ex) {
            Logger.getLogger(CadFrameEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        preencherEventos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int indexNoticia = tabelaEventos.getSelectedRow();
        if (indexNoticia == -1){
            JOptionPane.showMessageDialog(null, "Selecione um evento para excluir");
            return;
        }
        
        eventoSelecionado = eventos.get(indexNoticia);
        try{
            Evento.deletarEvento(eventoSelecionado);
            preencherEventos();
            gerenciador.refresh();
            JOptionPane.showMessageDialog(null, "Evento excluído");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Houve um problema ao tentar excluir: "+e.toString());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEventosMouseClicked
        if (evt.getClickCount() == 2){
            int index = tabelaEventos.getSelectedRow();
            eventoSelecionado = eventos.get(index);
            preencherCamposEventoSelecionado();
        }
    }//GEN-LAST:event_tabelaEventosMouseClicked

    private void ckboxAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckboxAtualizarActionPerformed
        if (ckboxAtualizar.isSelected()){
            JOptionPane.showMessageDialog(null, "Para atualizar um evento, primeiro selecione um");
            ckboxAtualizar.setSelected(false);
        }
    }//GEN-LAST:event_ckboxAtualizarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFecharCad;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JCheckBox ckboxAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelCadastrar;
    private javax.swing.JTabbedPane panelGeral;
    private javax.swing.JPanel panelRemover;
    private javax.swing.JTable tabelaEventos;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDataEvento;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtHoraEvento;
    private javax.swing.JTextField txtPublicoAlvo;
    private javax.swing.JTextField txtTema;
    private javax.swing.JTextField txtTemaEvento;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
