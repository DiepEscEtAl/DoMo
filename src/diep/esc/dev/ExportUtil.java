/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diep.esc.dev;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author diep
 */
public class ExportUtil {
    public static void exportAllToDME(JTable table,File f){
        int t[]=new int[table.getRowCount()];
        for(int i=0;i<t.length;i++){
            t[i]=i;
        }
        exportDME(table.getModel(),t, f);
    }
    public static void exportAllToTXT(JTable table,File f){
        int t[]=new int[table.getRowCount()];
        for(int i=0;i<t.length;i++){
            t[i]=i;
        }
        exportTXT(table.getModel(),t, f);
    }
    public static void exportSeletedToDME(JTable table, File f){
        exportDME(table.getModel(), table.getSelectedRows(), f);
    }
    public static void exportSeletedToTXT(JTable table, File f){
        exportTXT(table.getModel(), table.getSelectedRows(), f);
    }
    
    private static void exportDME(TableModel model,int[] rows,File f){
        try {
            FileWriter fw=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            for(int i=0;i<rows.length;i++){
                bw.append("<item>"); bw.newLine();
                bw.append("\t<name>"+model.getValueAt(i, 1)+"</name>"); bw.newLine();
                bw.append("\t<queue>"+model.getValueAt(i, 2)+"</queue>"); bw.newLine();
                bw.append("\t<size>"+model.getValueAt(i, 3)+"</size>"); bw.newLine();
                bw.append("\t<status>"+model.getValueAt(i, 4)+"</status>"); bw.newLine();
                bw.append("\t<timeleft>"+model.getValueAt(i, 5)+"</timeleft>"); bw.newLine();
                bw.append("\t<transferrate>"+model.getValueAt(i, 6)+"</lasttry>"); bw.newLine();
                bw.append("\t<lasttry>"+model.getValueAt(i, 7)+"</timeleft>"); bw.newLine();
                bw.append("\t<description>"+model.getValueAt(i, 8)+"</description>"); bw.newLine();
                bw.append("\t<dateadded>"+model.getValueAt(i, 9)+"</dateadded>"); bw.newLine();
                bw.append("\t<saveto>"+model.getValueAt(i, 10)+"</saveto>"); bw.newLine();
                bw.append("\t<url>"+model.getValueAt(i, 11)+"</url>"); bw.newLine();
                bw.append("\t<referer>"+model.getValueAt(i, 12)+"</referer>"); bw.newLine();
                bw.newLine();
                bw.append("</item>");
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void exportTXT(TableModel model,int[] rows,File f){
        try {
            FileWriter fw=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            for(int i=0;i<rows.length;i++){
                bw.append(model.getValueAt(i, 11).toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
