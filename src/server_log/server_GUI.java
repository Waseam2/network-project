/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import static server_log.server_GUI.date;
//import static server_log.server_GUI.formatter;
//import static server_log.server_GUI.indata;
//import static server_log.server_GUI.input;
//import static server_log.server_GUI.link;
//import static server_log.server_GUI.link2;
//import static server_log.server_GUI.output;
import static server_log.multi.link1;
import static server_log.server_GUI.port;
import static server_log.server_GUI.serversoket;
//import static server_log.server_GUI.serversocket2;
//import static server_log.server_GUI.serversoket;


/**
 *
 * @author was12
 */

public class server_GUI extends javax.swing.JFrame {

    public static ServerSocket serversoket;
    public static final int port = 4545; 
    
    
    public server_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        getlogdata();
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        log_file_list = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        suc_login_tap = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        suc_log = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        failed_log = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        log_file_list.setCurrentDirectory(new java.io.File("C:\\Users\\was12\\OneDrive\\Documents\\NetBeansProjects\\server_log\\logs"));
        log_file_list.setBorder(null);
        log_file_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_file_listActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("login history ");

        suc_log.setColumns(20);
        suc_log.setRows(5);
        jScrollPane3.setViewportView(suc_log);

        suc_login_tap.addTab("successful login", jScrollPane3);

        failed_log.setColumns(20);
        failed_log.setRows(5);
        jScrollPane4.setViewportView(failed_log);

        suc_login_tap.addTab("failed login", jScrollPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(log_file_list, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(suc_login_tap)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(log_file_list, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(suc_login_tap, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log_file_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_file_listActionPerformed
            showLog log = new showLog(log_file_list.getSelectedFile().toString());
            log.setVisible(true);
    }//GEN-LAST:event_log_file_listActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void getlogdata()
    {
            File file = new File("faild_dlogin.txt");
               
 
        try (FileReader fr = new FileReader(file))
        {
            char[] chars = new char[(int) file.length()];
            fr.read(chars);
 
            String fileContent = new String(chars);
              failed_log.setText(fileContent);
              
              
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        File file2 = new File("validlogin.txt");
               
 
        try (FileReader fr = new FileReader(file2))
        {
            char[] chars = new char[(int) file2.length()];
            fr.read(chars);
 
            String fileContent = new String(chars);
              suc_log.setText(fileContent);
              
              
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }
    public static void main(String args[]) throws Exception{
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(server_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(server_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(server_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(server_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new server_GUI().setVisible(true);
                
            }        });
        serversoket = new ServerSocket(58585);
       ServerSocket serversoket2 = new ServerSocket(45454);
        
        JOptionPane.showMessageDialog(null, "connection open pn port1 "+port);
       do
       {
        Socket link = serversoket.accept();   
        new Thread(new multi(link)).start();
        
        
        Socket link2 = serversoket2.accept();
        new Thread(new saving(link2)).start();
        
        
           
        
       }while(true);
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea failed_log;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFileChooser log_file_list;
    private static javax.swing.JTextArea suc_log;
    private javax.swing.JTabbedPane suc_login_tap;
    // End of variables declaration//GEN-END:variables
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 class multi implements Runnable
{
     
    public static PrintWriter output ; 
    public static Scanner input ;
    public static  SimpleDateFormat formatter ;  // for get time in particular format
    public static  Date date ;  
   public static RSA rr = new RSA();
    public static  Socket link1 ; 

  //  public static ServerSocket serversocket2;
    
    
    multi(Socket socket )
    {
        this.link1=socket;
        
         formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
         date = new Date();
    }
        public static  boolean searchonfile(String fileName,String searchStr) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(fileName));  
        while(scan.hasNext()){ // this loop raed file line by line 
            String line = scan.nextLine().toLowerCase();
            if(line.contentEquals(searchStr)){         // if found the passowrd retrun true else return false ; 
               return true ;
             
            }
            
        }
        return false ; 
    }
    public static void authentication()throws Exception   // this function will do all authetication between server and client (||waseam.safwat||);
    {
        
        output = new PrintWriter(link1.getOutputStream() , true);
       Scanner input = new Scanner (link1.getInputStream());
        
        String UID , PID , credintial ; 
        String temp ;// credintial is user:passwword combine usernaem and passord to make search easy in fcredintial file 
        while(true)
        {
            UID = input.nextLine();
            PID = rr.decryptString(input.nextLine()); 
            credintial=UID+":"+PID;
            if(searchonfile("credential.txt", credintial))
            {
                FileWriter validlogin = new FileWriter("validlogin.txt" , true);
                validlogin.append("$'"+UID+"'  has login successfully in "+formatter.format(date)+"\n");
                validlogin.flush();
                output.println("true");
                break;
            }
            
            else 
            {
                FileWriter notvalidlogin = new FileWriter("faild_dlogin.txt" , true);
                notvalidlogin.append("$'"+UID+"'  failed to login  in "+formatter.format(date)+"\n");
                notvalidlogin.flush();
                output.println("false");
            }
      
            
            
            
            
        }
        //////////////////closing connection here to clien_GUI               done by(w.s);
        link1.close();
        input.close(); 
        output.close();
       // serversoket.close();
      
        
    }
    
    public void run()
    {
        try {
                authentication();
                
        } catch (Exception ex) {
            Logger.getLogger(multi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////

class saving implements Runnable
{
    public static DataInputStream indata ; 
    public static  SimpleDateFormat formatter ;  // for get time in particular format
    public static  Date date ; 
    public static Socket link;
     public static RSA rr = new RSA();
    public saving(Socket socket ) 
    {
        this.link = socket ; 
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
         date = new Date();
    }
    
    
 public static void saving_data()throws Exception  // for recive data from client and save this data in file every data save in different file 
    {
        String fileName , MSG ;
           //  serversoket = new ServerSocket(port);
        // JOptionPane.showMessageDialog(null, "connection open pn port "+port);
         //   link1 = serversoket.accept();
      //  JOptionPane.showMessageDialog(null, "connect");
//      ServerSocket serversocket2 =new ServerSocket(5565); 
//      Socket link2 = serversocket2.accept();
        indata = new DataInputStream(link.getInputStream());
  
        while(true)
        {
          fileName =  indata.readUTF();
          MSG      = rr.decryptString(indata.readUTF());
            
            
            
            writeLog(fileName, MSG);
            
            
         //   JOptionPane.showMessageDialog(null, "message recieves");
      
            /*fileName = input.nextLine();
           
                
               // FileWriter file = new FileWriter ("C:\\Users\\was12\\OneDrive\\Documents\\NetBeansProjects\\server_log\\logs\\temp5.txt", true);
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\was12\\OneDrive\\Documents\\NetBeansProjects\\server_log\\logs\\temp5.txt"));
                    while(!input.nextLine().equals("$end$")) 
                    {
                        System.out.println(input.nextLine());
                        writer.append(input.nextLine());
                    }
                
                     writer.close();
                    
                System.err.println("d");
              //writeLog(fileName , "d");*/
         
        }
        
        
    }
    public static void writeLog(String fileName , String logMsg) throws Exception   //this function write the message come from the client to the file if the file is exist append to the file and if the file don't exist create file done by (w.s)
    {
       
      FileWriter file = new FileWriter ("C:\\Users\\was12\\OneDrive\\Documents\\NetBeansProjects\\server_log\\logs\\"+fileName+".txt",true);
        PrintWriter printWriter = new PrintWriter (file,true);
        printWriter.println ("************** "+formatter.format(date)+" ************"+logMsg);
        printWriter.close ();  
    }
    @Override
    public void run() {
     try {
         saving_data();
     } catch (Exception ex) {
         Logger.getLogger(saving.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
}

