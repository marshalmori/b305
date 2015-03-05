/*
 * Autor: Marshal Mori Cavalheiro
 * email: marshalmori@gmail.com
 * Projeto: B 305
 */


package Utilitarios;


import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author marshal
 */
public class Conexao {
    
   public Connection con = null;
   public Statement stm = null;
   DefaultTableModel modeloTabela = new DefaultTableModel();
   ResultSet rs = null;


    
    public void conexaoBanco(){
   
           
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:b305.db");
            stm = con.createStatement();
            
           
      String sql = "CREATE TABLE IF NOT EXISTS BASE" +
                   "(id INTEGER  PRIMARY KEY AUTOINCREMENT," +
                   " nome           TEXT    NOT NULL, " + 
                   " origem         TEXT    NOT NULL, " + 
                   " contato        TEXT    NOT NULL, " + 
                   " url            TEXT    NOT NULL)" ; 
      
      String sql2 = "CREATE TABLE IF NOT EXISTS ORIGINAL " +
                   "(id_original INTEGER  PRIMARY KEY AUTOINCREMENT ," +
                   " path_original        TEXT           NOT NULL   ," +
                   " tipo_video           TEXT           NOT NULL   ," +
                   " altura               INTEGER        NOT NULL   ," +
                   " largura              INTEGER        NOT NULL   ," +
                   " tempo                DOUBLE         NOT NULL   ," +
                   " subamostragem        TEXT           NOT NULL   ," +
                   " fps                  DOUBLE         NOT NULL   ," +
                   " numero_frames        TEXT           NOT NULL   ," +
                   " varredura            TEXT           NOT NULL   ," +
                   " nr_bits              INTEGER        NOT NULL   ," + 
                   " observacao           VARCHAR (100)          NOT NULL   )" ; 
                   
                   
               
        String sql3 = "CREATE TABLE IF NOT EXISTS DISTORCIDOS" +
                   "(id_distorcido INTEGER  PRIMARY KEY AUTOINCREMENT," +
                   " path_distorcido           TEXT    NOT NULL) ";
        
      stm.executeUpdate(sql);
      stm.executeUpdate(sql2);
      stm.executeUpdate(sql3);
    
      //stm.close();

      
    }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Erro de conexão:" + e);
    
    }//fim catch
        
     
      
        
}//fim método conexaoBanco
    
    
    
     public DefaultTableModel selectBanco(){
        
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:b305.db");
            stm = con.createStatement();
             
           
            rs = stm.executeQuery("SELECT * FROM BASE;");
            ResultSetMetaData rsmd = rs.getMetaData();                       

              int colunas = rsmd.getColumnCount();
              //System.out.println(colunas);
              
              
                
          for (int i = 0; i < colunas; i++){
           modeloTabela.addColumn(rsmd.getColumnLabel(i + 1));
          }
          
          
                while(rs.next()){
                 
                 Object fila [] = new Object[colunas];
                 //System.out.println("Teste");
                 
                 for(int i = 0; i < colunas; i++){
                     //System.out.println("fila: "+fila[i]);
                     fila[i] = rs.getObject(i + 1);
                     //System.out.println("fila: "+fila[i]);
                 }//fim for
                 
                 modeloTabela.addRow(fila);
             }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não ocorreu o select:"+e);
        }
         return modeloTabela;
    }
    
    
    
    
    
    
    
    
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++    
//public void selectBanco (){
//    try {
//        Class.forName("org.sqlite.JDBC");
//            con = DriverManager.getConnection("jdbc:sqlite:b305.db");
//            stm = con.createStatement();
//            
//            
//            String slqt = "SELECT * FROM BASE;";
//            stm.executeQuery(slqt);
//     
//    } catch (Exception e) {
//        
//        
//    }
//      
//}//fim método selectBanco
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++     
     
    
}//fim da classe
