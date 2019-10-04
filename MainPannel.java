import java.util.Vector;
import java.io.*;
import java.beans.*;

public class MainPannel extends javax.swing.JPanel {
    
    private Vector listaRegistros;  //A lista de registros do banco
    private int indice;             //O elemento atual. Se -1, o banco está vazio
    private final String dataFileName = "LivroEndereco.xml";
    
    /** Construtor da classe */
    public MainPannel() {
        initComponents();
        this.listaRegistros = loadRegistros();
        if (this.loadRegistros().size() == 0)
            this.indice = -1;
        else
            this.indice = 0;
        showRegistro(this.listaRegistros, this.indice);
    }
    
    /**
     *Lê todos os registros em um vetor.
     **/
    private Vector loadRegistros() {
        Object result = new Object();
        try {
            XMLDecoder d = new XMLDecoder(
                    new BufferedInputStream(
                    new FileInputStream(dataFileName)));
            result = d.readObject();
            d.close();
        } catch (FileNotFoundException e) {
            return(new Vector());
        }
        return((Vector)result);
    }
    
    /**
     *Salva o catálogo de enderecos atual.
     */
    private void saveRegistros() {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream(this.dataFileName)));
            encoder.writeObject(this.listaRegistros);
            encoder.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void updateMemory(Vector lista, int posicao) {
        if (posicao >= 0) {
            Registro tmpReg = new Registro();
            tmpReg.setNome(this.jTextField2.getText());
            tmpReg.setEndereco(this.jTextField3.getText());
            tmpReg.setTelefone(this.jTextField4.getText());
            lista.insertElementAt(tmpReg, posicao);
            posicao++;
            lista.removeElementAt(posicao);
        }
    }
    
    /**
     *Mostra o registro presente em registros mostrado por indice.
     */
    private void showRegistro(Vector registros, int indice) {
        if (indice != -1) {
            this.jLabel5.setText(String.valueOf(indice));
            Registro tmpReg = (Registro)registros.elementAt(indice);
            this.jTextField2.setText(tmpReg.getNome());
            this.jTextField3.setText(tmpReg.getEndereco());
            this.jTextField4.setText(tmpReg.getTelefone());
        } else {
            this.jLabel5.setText("Lista vazia");
            this.jTextField2.setText("");
            this.jTextField3.setText("");
            this.jTextField4.setText("");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setText("N\u00famero do registro");
        jPanel1.add(jLabel1);

        jPanel1.add(jLabel5);

        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2);

        jPanel1.add(jTextField2);

        jLabel3.setText("Endere\u00e7o:");
        jPanel1.add(jLabel3);

        jPanel1.add(jTextField3);

        jLabel4.setText("Telefone:");
        jPanel1.add(jLabel4);

        jPanel1.add(jTextField4);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 4));

        jButton1.setText("Anterior");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel2.add(jButton1);

        jButton2.setText("Pr\u00f3ximo");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jPanel2.add(jButton2);

        jButton3.setText("Novo");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jPanel2.add(jButton3);

        jButton4.setText("Remover");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jPanel2.add(jButton4);

        add(jPanel2, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (this.listaRegistros.size() > 0) {
            this.listaRegistros.removeElementAt(this.indice);
            this.indice--;
            if ((this.indice < 0) && (this.listaRegistros.size() > 0))
                this.indice = 0;
        }
        showRegistro(this.listaRegistros, this.indice);
        saveRegistros();
    }//GEN-LAST:event_jButton4MouseClicked
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        updateMemory(this.listaRegistros, this.indice);
        this.indice++;
        if (this.indice > this.listaRegistros.size()-1)
            this.indice = 0;
        showRegistro(this.listaRegistros, this.indice);
        saveRegistros();
    }//GEN-LAST:event_jButton2MouseClicked
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        updateMemory(this.listaRegistros, this.indice);
        this.indice--;
        if (this.indice < 0)
            this.indice = this.listaRegistros.size()-1;
        showRegistro(this.listaRegistros, this.indice);
        saveRegistros();
    }//GEN-LAST:event_jButton1MouseClicked
    
    /**Adiciona um novo registro*/
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        updateMemory(this.listaRegistros, this.indice);
        this.listaRegistros.add(new Registro());
        this.indice = this.listaRegistros.size()-1;
        showRegistro(this.listaRegistros, this.indice);
        saveRegistros();
    }//GEN-LAST:event_jButton3MouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    
}
