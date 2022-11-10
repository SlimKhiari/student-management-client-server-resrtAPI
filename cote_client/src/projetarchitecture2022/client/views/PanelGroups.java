/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetarchitecture2022.client.views;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JComboBox;

import projetarchitecture2022.client.model.Group;
import projetarchitecture2022.client.model.GroupImplementation;
import projetarchitecture2022.client.model.Student;
import projetarchitecture2022.client.model.Subject;
import projetarchitecture2022.client.model.TeachingUnit;

/**
 *
 * @author james
 */
public class PanelGroups extends javax.swing.JPanel {

    /**
     * Creates new form PanelGroups
     */
    
    private final String entete_eleve[] = {"Numéro étudiant", "Nom", "Prenoms"};
    private final String entete_group[] = {"Numéro group", "Nom du groupe", "Sujet", "Membres"};
    private int selectedindex;
    private int selectedindex_group;
    private Group group_al;
    private GroupImplementation group;
    
    public PanelGroups(GroupImplementation group) {
    	this.group = group;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jt_name_group = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cb_subject = new javax.swing.JComboBox<>();
        cb_ue = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Object[][] data = null;

        ArrayList<Student> student = this.group.getStudents();

        data = new Object[student.size()][4];

        for (int i = 0; i < student.size(); i++) {
            data[i][0] = student.get(i).id;
            data[i][1] = student.get(i).lastname;
            data[i][2] = student.get(i).firstname;
            data[i][3] = false;
        }
        System.out.print(""+data.length);
        listStudents = new javax.swing.JTable();
        listStudents.setModel(new javax.swing.table.DefaultTableModel(data,entete_eleve));
        listStudents = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        Object[][] data2 = null;

        ArrayList<Group> g = this.group.getGroups();

        data2 = new Object[g.size()][4];

        for (int i = 0; i < g.size(); i++) {
            data2[i][0] = g.get(i).id;
            data2[i][1] = g.get(i).name;
            data2[i][2] = g.get(i).subject.title;
            String liststud = "";
            ArrayList<Student> st = g.get(i).getStudents();
            System.out.println("" + st.size());
            for(int j=0; j< st.size(); j++){
                liststud += " " +st.get(j).getLastname() + " -- ";
            }
            data2[i][3] = liststud;
        }

        listGroup = new javax.swing.JTable();
        listGroup.setModel(new javax.swing.table.DefaultTableModel(data2,entete_group));
        listGroup = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setRequestFocusEnabled(false);

        jLabel1.setText("GROUPES");

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 614));

        jLabel2.setText("Nom du groupe");

        jLabel3.setText("UE");

        jLabel4.setText("Sujet");

        jButton1.setText("CREER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CREATION ALEATOIRE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("ACTUALISER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Liste des élèves");

        cb_subject = new javax.swing.JComboBox<>();
        ArrayList<Subject> s = this.group.getSubjects();

        for(int i=0; i< s.size(); i++) {
            cb_subject.addItem(s.get(i).getTitle());
        }
        cb_subject.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cb_subjectComponentAdded(evt);
            }
        });

        ArrayList<TeachingUnit> ues = this.group.getTeachingUnits();

        for(int i=0; i< ues.size(); i++) {
            cb_ue.addItem(ues.get(i).title);
        }

        listStudents.setModel(new javax.swing.table.DefaultTableModel(data,entete_eleve));
        jScrollPane2.setViewportView(listStudents);

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel5.setText("Liste des groupes");

        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        listGroup.setModel(new javax.swing.table.DefaultTableModel(data2, entete_group));
        jScrollPane3.setViewportView(listGroup);

        jScrollPane4.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_ue, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jt_name_group, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(129, 129, 129))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_name_group, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_ue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here
        selectedindex_group = listGroup.getSelectedRow();
        Group s = new Group(Integer.parseInt(listGroup.getValueAt(selectedindex_group, 0).toString()), null, null, null, null);
        System.out.println("delete group: "+ selectedindex_group);
        this.group.deleteGroup(s.getId());
        rafraichissement_du_tableau();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb_subjectComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cb_subjectComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_subjectComponentAdded

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        rafraichissement_du_tableau();
        
        
        ArrayList<TeachingUnit> ues = this.group.getTeachingUnits();
        System.out.println("ues ; "+ ues.toString());
        
        
        cb_ue = new JComboBox();
        for(int i=0; i< ues.size(); i++) {
            cb_ue.addItem(ues.get(i).title);
        }
        cb_ue.revalidate();
        
        ArrayList<Subject> s = this.group.getSubjects();

        cb_subject = new JComboBox();
        for(int i=0; i< s.size(); i++) {
            cb_subject.addItem(s.get(i).getTitle());
        }

        jPanel1.revalidate();
        jPanel1.repaint();

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList<Student> stud = this.group.getStudents();

        ArrayList<Subject> sub = this.group.getSubjects();

        ArrayList<TeachingUnit> tu = this.group.getTeachingUnits();

        //generer le nom aléatoire
        //ProjetArchitecture2022 nana = new ProjetArchitecture2022();
        String name = ale_name();

        // generer l'UE
        Collections.shuffle(tu);
        Collections.shuffle(stud);
        Collections.shuffle(sub);
        Random random1 = new Random();
        int index1 = random1.nextInt(stud.size());
        TeachingUnit tuAleatoire = tu.get(index1);

        //etudiant aléa
        ArrayList<Student> studsAleatoire = new ArrayList<Student>(); 
        Random random = new Random();
        int index = random.nextInt(stud.size());
        System.out.println(" Etu " + stud.size());
        studsAleatoire.add(stud.get(index));

        //sujet   aléa
        Subject suAleatoire = sub.get(0);
       //create group
       Group newG = new Group(name, tuAleatoire, studsAleatoire, suAleatoire);
       this.group.addGroupe(newG.getId(), newG.getName(), newG.getStudents(), newG.getSubject(), newG.getTeachingUnit());
       rafraichissement_du_tableau();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public String ale_name() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int [] selectedindex = listStudents.getSelectedRows();
        ArrayList<Student> s = new ArrayList<Student>();
        for (int i = 0; i < selectedindex.length; i++) {
            //s.add(st.getStudentById(selectedindex[i]));
            //System.out.println("List selection" + selectedindex.length + " -- "+ listStudents.getValueAt(i, 0));
            System.out.println("List selection" + selectedindex.length + " -- "+ this.group.getStudentById(Integer.parseInt(listStudents.getValueAt(selectedindex[i], 0).toString())));
            s.add(this.group.getStudentById(Integer.parseInt(listStudents.getValueAt(selectedindex[i], 0).toString())));
        }
        
        //System.out.println(" "+ s.toString());

        TeachingUnit ue = this.group.getTeachingUnitByTitle(cb_ue.getSelectedItem().toString());
        Subject sub = this.group.getSubjectByTitle(cb_subject.getSelectedItem().toString());
        //System.out.println("Unité d'enseignement -- " + ue.toString());
        //System.out.println("Sujet -- " + sub.toString());

        Group g = new Group(jt_name_group.getText(), ue, s, sub);
        group_al = g;
        //System.out.println("Group " + g.toString());
        this.group.addGroupe(g.getId(), g.getName(), g.getStudents(), g.getSubject(), g.getTeachingUnit());
        rafraichissement_du_tableau();
        jt_name_group.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    public void rafraichissement_du_tableau(){
        Object[][] data2 = null;

            ArrayList<Group> g = this.group.getGroups();

            data2 = new Object[g.size()][9];

            for (int i = 0; i < g.size(); i++) {
                data2[i][0] = g.get(i).id;
                data2[i][1] = g.get(i).name;
                data2[i][2] = g.get(i).subject.title;
                String liststud = "";
                ArrayList<Student> st = g.get(i).getStudents();
                System.out.println("" + st.size());
                for(int j=0; j< st.size(); j++){
                    liststud += " " +st.get(j).getLastname() + " -- ";
                }
                data2[i][3] = liststud;
            }
        listGroup = new javax.swing.JTable();
        listGroup.setModel(new javax.swing.table.DefaultTableModel(data2,entete_group));
        jScrollPane4.setViewportView(listGroup);
        listGroup.revalidate();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_subject;
    private javax.swing.JComboBox<String> cb_ue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jt_name_group;
    private javax.swing.JTable listGroup;
    private javax.swing.JTable listStudents;
    // End of variables declaration//GEN-END:variables
}
