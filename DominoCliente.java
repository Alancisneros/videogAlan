/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   @author alancisneros
 */


import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class DominoCliente extends JFrame {

   
    
    java.util.Timer vueltas=new java.util.Timer();
    Random ramdon=new Random();
    ArrayList fichas=new ArrayList();    
    ArrayList jugadores=new ArrayList();
    int X1,Y1,X2,Y2;
    Jugador j1,j2,j3,j4; 
    int jugadorpos=0;
    Ficha cursor=null;
    Ficha f=null;
    int b1=0,b2=0;
    Enlace ip;
    boolean entrado=false;
    Nombre n;
    boolean entrado1=false;     
    
    private javax.swing.JScrollPane jScrollPane1; 
    private javax.swing.JTextArea area;
    
  static public ArrayList fichastodas=new ArrayList();
    
    
   
    public DominoCliente() {
        initComponents();
        
        
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
                
    }
        
        
      
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Tablero = new javax.swing.JPanel();
        panelJugador3 = new javax.swing.JPanel();
        panelJugador1 = new javax.swing.JPanel();
        panelJugador2 = new javax.swing.JPanel();
        panelJugador4 = new javax.swing.JPanel();
        nombreJugador3 = new javax.swing.JLabel();
        nombreJugador1 = new javax.swing.JLabel();
        nombreJugador4 = new javax.swing.JLabel();
        nombreJugador2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
       
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1350, 800));
        setType(java.awt.Window.Type.NORMAL);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablero.setPreferredSize(new java.awt.Dimension(1000, 800));
        Tablero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJugador3.setPreferredSize(new java.awt.Dimension(280, 80));
        panelJugador3.setLayout(new java.awt.GridLayout(1, 7));
        Tablero.add(panelJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 280, 80));
        panelJugador3.getAccessibleContext().setAccessibleDescription("");

        panelJugador1.setPreferredSize(new java.awt.Dimension(280, 80));
        panelJugador1.setLayout(new java.awt.GridLayout(1, 7));
        Tablero.add(panelJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 280, 80));

        panelJugador2.setPreferredSize(new java.awt.Dimension(80, 280));
        panelJugador2.setLayout(new java.awt.GridLayout(7, 1));
        Tablero.add(panelJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 80, 280));

        panelJugador4.setPreferredSize(new java.awt.Dimension(80, 280));
        panelJugador4.setLayout(new java.awt.GridLayout(7, 1));
        Tablero.add(panelJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 80, 280));
        Tablero.add(nombreJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 10, 80, 30));
        Tablero.add(nombreJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 100, 30));
        Tablero.add(nombreJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 144, 90, 30));
        Tablero.add(nombreJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 120, 80, 30));

        getContentPane().add(Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1190, 770));

        jPanel2.setMinimumSize(new java.awt.Dimension(200, 800));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 800));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Empezar Partida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 200, 770));
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 720));
        ip=new Enlace(this,true);
        n=new Nombre(null,true);
         
        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
       
        Tablero.removeAll();
        fichas=new ArrayList();    
        jugadores=new ArrayList();
        vueltas.cancel();
        area.setText("");
        cursor=null;
        f=null;
        b1=0;b2=0;
        j=null;
        fichastodas=new ArrayList();
        
        panelJugador3 = new javax.swing.JPanel();
        panelJugador1 = new javax.swing.JPanel();
        panelJugador2 = new javax.swing.JPanel();
        panelJugador4 = new javax.swing.JPanel();
        nombreJugador3 = new javax.swing.JLabel();
        nombreJugador1 = new javax.swing.JLabel();
        nombreJugador4 = new javax.swing.JLabel();
        nombreJugador2 = new javax.swing.JLabel();
        
        panelJugador3.setPreferredSize(new java.awt.Dimension(280, 80));
        panelJugador3.setLayout(new java.awt.GridLayout(1, 7));
        Tablero.add(panelJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 280, 80));
        panelJugador3.getAccessibleContext().setAccessibleDescription("");

        panelJugador1.setPreferredSize(new java.awt.Dimension(280, 80));
        panelJugador1.setLayout(new java.awt.GridLayout(1, 7));
        Tablero.add(panelJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 280, 80));

        panelJugador2.setPreferredSize(new java.awt.Dimension(80, 280));
        panelJugador2.setLayout(new java.awt.GridLayout(7, 1));
        Tablero.add(panelJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 80, 280));

        panelJugador4.setPreferredSize(new java.awt.Dimension(80, 280));
        panelJugador4.setLayout(new java.awt.GridLayout(7, 1));
        Tablero.add(panelJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 80, 280));
        Tablero.add(nombreJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 10, 80, 30));
        Tablero.add(nombreJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 100, 30));
        Tablero.add(nombreJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 144, 90, 30));
        Tablero.add(nombreJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 120, 80, 30));
 
       
        
        Ficha f00=new Ficha(0,0,fichas);
        Ficha f01=new Ficha(0,1,fichas);
        Ficha f02=new Ficha(0,2,fichas);
        Ficha f03=new Ficha(0,3,fichas);
        Ficha f04=new Ficha(0,4,fichas);
        Ficha f05=new Ficha(0,5,fichas);
        Ficha f06=new Ficha(0,6,fichas);
        
        Ficha f11=new Ficha(1,1,fichas);
        Ficha f12=new Ficha(1,2,fichas);
        Ficha f13=new Ficha(1,3,fichas);
        Ficha f14=new Ficha(1,4,fichas);
        Ficha f15=new Ficha(1,5,fichas);
        Ficha f16=new Ficha(1,6,fichas);
        
        Ficha f22=new Ficha(2,2,fichas);
        Ficha f23=new Ficha(2,3,fichas);
        Ficha f24=new Ficha(2,4,fichas);
        Ficha f25=new Ficha(2,5,fichas);
        Ficha f26=new Ficha(2,6,fichas);
        
        Ficha f33=new Ficha(3,3,fichas);
        Ficha f34=new Ficha(3,4,fichas);
        Ficha f35=new Ficha(3,5,fichas);
        Ficha f36=new Ficha(3,6,fichas);
        
        Ficha f44=new Ficha(4,4,fichas);
        Ficha f45=new Ficha(4,5,fichas);
        Ficha f46=new Ficha(4,6,fichas);
        
        Ficha f55=new Ficha(5,5,fichas);
        Ficha f56=new Ficha(5,6,fichas);
        
        Ficha f66=new Ficha(6,6,fichas);
        
        panelJugador1.removeAll();
        panelJugador2.removeAll();
        panelJugador3.removeAll();
        panelJugador4.removeAll();
        
       
        vueltas=new java.util.Timer();
        
        ArrayList fichas1=new ArrayList();
        ArrayList fichas2=new ArrayList();
        ArrayList fichas3=new ArrayList();
        ArrayList fichas4=new ArrayList();
        
                
        try{
            if(!entrado)
            {    
            ip.setLocationRelativeTo(null);
            ip.setVisible(true);
            entrado=true;
            }
        ArrayList a=null;
        
        area.setText(
                      "Conectando........\n"+
                      area.getText()
                     );
        
       while(a==null){
        s = new Socket(ip.ip.getText(),Integer.parseInt(ip.puerto.getText()));
       // s=new Socket("192.168.1.37",100);
        r = new ObjectInputStream( s.getInputStream());
        w= new ObjectOutputStream(s.getOutputStream());
        
        area.setText(
        "Conectado. \n"+
        area.getText()               
        );
       
         a=(ArrayList)r.readObject();
       }
       
       for(int i=0;i<a.size();i++)
        {Ficha f1=(Ficha)a.get(i);
         for(int h=0;h<fichas.size();h++)
         {Ficha f2=(Ficha)fichas.get(h);
           if (f1.equals(f2)) {fichas1.add(f2);fichas.remove(f2);}
        
         }
        }
         
         area.setText(
         "Esperando Jugadores....\n"+
         area.getText()
                 );
         
      
         if (!entrado1){
         n.setLocationRelativeTo(null);
         n.setVisible(true); 
         entrado1=true;
         }
         
         if (n.virtual.isSelected()) j1=new JugadorVirtual2(fichas1);
         else j1=new Jugador(fichas1);
         
         j1.nombre=n.nombre.getText();
         
         
         w.writeObject(j1);
         
       
        
             
        nombreJugador1.setText(j1.nombre);
        setTitle(j1.nombre);
        
        for(int i=0;i<fichas1.size();i++)
        {Ficha f=(Ficha)fichas1.get(i);
          if (!f.visible) f.vuelta();
        if (f.horizontal)f.gira();
        panelJugador1.add(f);
        }
        
        
            
	
        jugadores=(ArrayList)r.readObject();
       
        } catch (Exception e) {
                                                        javax.swing.JOptionPane.showMessageDialog
                                (null,"Error de conexion","Fin del juego....",javax.swing.JOptionPane.OK_OPTION);      
                                   
                                 area.setText(
                                 "Error de conexion\n"
                                 + "Fin del juego"+
                                 area.getText()
                                 );
                                 return;             }
        
        
        
        ArrayList aux=new ArrayList();
        aux.add(j1);
        
       Jugador a=(Jugador)(jugadores.get((int)(ramdon.nextFloat()*jugadores.size())));
      
       
        while(aux.contains(a)){a=(Jugador)(jugadores.get((int)(ramdon.nextFloat()*jugadores.size())));}
        
        for(int i=0;i<a.fichas.size();i++)
        {Ficha f1=(Ficha)a.fichas.get(i);
         for(int h=0;h<fichas.size();h++)
         {Ficha f2=(Ficha)fichas.get(h); 
             if (f1.equals(f2)) {fichas2.add(f2);fichas.remove(f2);}
        
         }
        }
        
        for(int i=0;i<fichas2.size();i++)
        {Ficha f=(Ficha)fichas2.get(i);
        //if (!f.visible) f.vuelta();
        if (!f.horizontal)f.gira();
         panelJugador2.add(f);
        }
        // j2=new Jugador(fichas2);
         //j2.nombre=a.nombre;
         j2=a;j2.fichas=fichas2;
         nombreJugador2.setText(j2.nombre);
         
         aux.add(a);
         
       if (aux.size()<jugadores.size())
       {
        while(aux.contains(a)){a=(Jugador)(jugadores.get((int)(ramdon.nextFloat()*jugadores.size())));}
         
         
         for(int i=0;i<a.fichas.size();i++)
        {Ficha f1=(Ficha)a.fichas.get(i);
         for(int h=0;h<fichas.size();h++)
         {Ficha f2=(Ficha)fichas.get(h);
             if (f1.equals(f2)) {fichas3.add(f2);fichas.remove(f2);}
        
         }
        }
           
        for(int i=0;i<fichas3.size();i++)
        {Ficha f=(Ficha)fichas3.get(i);
         //if (!f.visible) f.vuelta();
        if (f.horizontal)f.gira();
        panelJugador3.add(f);
        }
        
        //j3=new Jugador(fichas3);
        j3=a;j3.fichas=fichas3;
        //j3.nombre=a.nombre;
        nombreJugador3.setText(j3.nombre);
       }
       
        
        aux.add(a);
        
         if (aux.size()<jugadores.size())
       {
         while(aux.contains(a)){a=(Jugador)(jugadores.get((int)(ramdon.nextFloat()*jugadores.size())));}
         
           for(int i=0;i<a.fichas.size();i++)
        {Ficha f1=(Ficha)a.fichas.get(i);
         for(int h=0;h<fichas.size();h++)
         {Ficha f2=(Ficha)fichas.get(h);
             if (f1.equals(f2)) {fichas4.add(f2);fichas.remove(f2);}
        
         }
        }
            
        for(int i=0;i<fichas4.size();i++)
        {Ficha f=(Ficha)fichas4.get(i);
         //if (!f.visible) f.vuelta();
        if (!f.horizontal)f.gira();
        panelJugador4.add(f);
        }
       
        //j4=new Jugador(fichas4);
        j4=a;j4.fichas=fichas4;
      //  j4.nombre=a.nombre;
        nombreJugador4.setText(j4.nombre);
        
       }
         
        
       jugadorpos=0;
      
       TimerTask timerTask = new TimerTask() {public void run() {try { vueltas();
                                                               } catch (Exception ex) {ex.printStackTrace();}
                                                            }
                                         };
        
        X2=X1=Tablero.getWidth()/2;
        Y2=Y1=Tablero.getHeight()/2;
        
       
         Tablero.repaint();
        Tablero.validate();
        
         vueltas.scheduleAtFixedRate(timerTask, 0,2000);
        
// TODO add your handling code here:
    }                                        
    
    Jugador j;
    Random random=new  Random();
    Socket s;
    ObjectInputStream r;
    ObjectOutputStream w;
   
    
    void vueltas(){
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMinimum()); 
        jScrollPane1.repaint(); 
        
        
        j=(Jugador)jugadores.get(jugadorpos);
        
               
        area.setText(
        "Es el turno de:\n"+
        j.nombre+"\n"+
        area.getText()
        );
        
        if (cursor!=null&&(j.LLeva(cursor.e1)||j.LLeva(cursor.e2))){ 
            try{
            if(j.equals(j1)) {f= j1.dameFicha(cursor);
                              
                                       
                              if (f!=null) 
                              {j1.fichas.remove(f);
                              w.writeObject(new Dato(f,f.punta,jugadores));
                              }
                    }                                    
                                                            
         else if (j.equals(j2)) {Dato d=(Dato)r.readObject();
                                f=d.f;
                                
                                 if (f!=null) f.punta=d.punta;
                                
                                }
                                          
         else if (j.equals(j3))   {Dato d=(Dato)r.readObject();
                                f=d.f;
                                 if (f!=null) f.punta=d.punta;
                                 }
                                          
         else if (j.equals(j4))  {Dato d=(Dato)r.readObject();
                                f=d.f;
                                 if (f!=null) f.punta=d.punta;
                                 }
                                          
               } catch (Exception e) {
                                                        javax.swing.JOptionPane.showMessageDialog
                                (null,"Error de conexion","Fin del juego....",javax.swing.JOptionPane.OK_OPTION);      
                                   
                                area.setText(
                                "Error de conexion \n"+
                                "Fin del juego....\n"+
                                area.getText()
                                );
                           
                                vueltas.cancel(); return; }                      
                                          
                                          
                                     
                                                                              }
        
        else if (cursor!=null) {  
                                if (!(j instanceof JugadorVirtual))
                                     javax.swing.JOptionPane.showMessageDialog
                                (null,"No LLevo",((Jugador)jugadores.get(jugadorpos)).nombre+" Paso Turno",javax.swing.JOptionPane.OK_OPTION);      
                                 
                                 area.setText(
                                j.nombre+"\n"+         
                                "No llevo \n"+
                                "Paso Turno\n"+
                                area.getText()
                                );
                                   jugadorpos++;
                                  if (jugadorpos==jugadores.size()) jugadorpos=0;
                                 
                                  return;
                                      }        
        else if (cursor==null){
           try{
            if(j.equals(j1)) {f= j1.dameFicha(cursor);
                              
                              
                              if (f!=null) 
                              {j1.fichas.remove(f);
                                  
                              w.writeObject(new Dato(f,f.punta,jugadores));
                              }
                    }                                    
                                                            
         else if (j.equals(j2)) {Dato d=(Dato)r.readObject();
                                 
                                 
                                 f=d.f;
                                 if (f!=null)f.punta=d.punta;
                                 }
                                          
         else if (j.equals(j3))   {Dato d=(Dato)r.readObject();
                                f=d.f;
                                 if (f!=null) f.punta=d.punta;
                                 }
                                          
         else if (j.equals(j4))  {Dato d=(Dato)r.readObject();
                                f=d.f;
                                 if (f!=null) f.punta=d.punta;
                                 }
                                          
               } catch (Exception e) { 
                                                        javax.swing.JOptionPane.showMessageDialog
                                (null,"Error de conexion","Fin del juego....",javax.swing.JOptionPane.OK_OPTION);      
                                 area.setText(
                                "Error de conexion \n"+
                                "Fin del juego....\n"+
                                area.getText()
                                );
                             
                                            vueltas.cancel();   return;     }               
}
        
        
        
                                    
        
        
                        
       
       
   if(f!=null){
         area.setText(
          j.nombre+"\n"+
          "juega "+
          f.e1+":"+f.e2+"\n"+
          area.getText()
         );
                         
        if (cursor==null) {cursor=new Ficha(f.e1,f.e2,fichas);
                           cursor.setVisible(false);
                            
                                                  
                           
                           if (f.esDoble()&&f.horizontal)f.gira();
                           if (!f.esDoble()&&!f.horizontal) f.gira(); 
                           if (f.esDoble())
                                Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X1,Y1-Ficha.tamaño/2, -1, -1));
                           else Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X1,Y1, -1, -1));
                           if (!f.visible) f.vuelta();
                           
                           if (!f.esDoble())  X2+=Ficha.tamaño*2;
                           else  X2+=Ficha.tamaño;
                           
                           j.fichas.remove(f);  
                           f=null;
                           Tablero.validate();
                           
                             }
    else{
              int c1,c2;
             
             
          
     if (cursor.e1==f.punta){
            
                             if (X1>220&&b1==0){
                                 if (!f.esDoble())  X1-=Ficha.tamaño*2; 
                                    else X1-=Ficha.tamaño;
                                // X1-=Ficha.tamaño*2;         
                                    if(f.e1==f.punta) {c1=f.e2;}
                                    else {c1=f.e1;}
                                    c2=cursor.e2;
                                    if (f.punta==f.e1) f.invierte();
                                    
                                    
                                    if (f.esDoble()&&f.horizontal)f.gira();
                                    if (!f.esDoble()&&!f.horizontal) f.gira();
                                    if (f.esDoble())
                                         Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X1,Y1-Ficha.tamaño/2, -1, -1));
                                    else Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X1,Y1, -1, -1));
                                     
                                      if (!f.visible) f.vuelta();
                                     
                                     j.fichas.remove(f);
                                     f=null;
                                     cursor.e1=c1;
                                     cursor.e2=c2;
                                      Tablero.validate(); 
                                     
                                    }
                             else{b1=1;
                                    if (X1<=220) {Y1=Y1-100;
                                    //X1-=Ficha.tamaño;
                                    }
                                    
                                    
                                  //  X1+=Ficha.tamaño*2; 
                                    if(f.e1==f.punta) {c1=f.e2;}
                                    else {c1=f.e1;}
                                    c2=cursor.e2;
                                    if (f.punta==f.e2) f.invierte();
                                    if (f.esDoble()&&f.horizontal)f.gira();
                                    if (!f.esDoble()&&!f.horizontal) f.gira();
                                    if(f.esDoble())
                                         Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X1,Y1-Ficha.tamaño/2, -1, -1));
                                    else Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X1,Y1, -1, -1));
                                 
                                    if (!f.esDoble()) X1+=Ficha.tamaño*2;
                                    else X1+=Ficha.tamaño;
                                     if (!f.visible) f.vuelta();
                                    
                                    if(X1>=Tablero.getWidth()-300) {Y1=Y1-100;b1=0;
                                    //X1+=Ficha.tamaño*2;
                                    }
                                      
                                    j.fichas.remove(f);   
                                    f=null;
                                     cursor.e1=c1;
                                     cursor.e2=c2;
                                    Tablero.validate(); 
                                     
                                }
                                    
       }
           
     else if(cursor.e2==f.punta) {
                                if (X2<Tablero.getWidth()-280&&b2==0){
                                   // X2+=Ficha.tamaño*2;
                                    if(f.e1==f.punta) {c2=f.e2;}
                                    else {c2=f.e1;}
                                    c1=cursor.e1;
                                    if (f.punta==f.e2) f.invierte();
                                          
                                     if (f.esDoble()&&f.horizontal)f.gira();
                                     if (!f.esDoble()&&!f.horizontal) f.gira();
                                     if (f.esDoble())
                                          Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X2,Y2-Ficha.tamaño/2, -1, -1));
                                     else Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X2,Y2, -1, -1));
                                       
                                     if (!f.esDoble()) X2+=Ficha.tamaño*2;
                                    else X2+=Ficha.tamaño;
                                       if (!f.visible) f.vuelta();
                                        
                                   j.fichas.remove(f);     
                                   f=null;
                                    cursor.e1=c1;
                                    cursor.e2=c2;
                                    Tablero.validate();
                                    
                                }
                                else{  b2=1; 
                                       if (X2>Tablero.getWidth()-300) {Y2=Y2+100;
                                       //X2=X2+Ficha.tamaño;
                                       }
                                 
                                        if (!f.esDoble()) X2-=Ficha.tamaño*2;
                                      else   X2-=Ficha.tamaño;

                                       //X2-=Ficha.tamaño*2;
                                       if(f.e1==f.punta) {c2=f.e2;}
                                       else {c2=f.e1;}
                                       c1=cursor.e1;
                                       if (f.punta==f.e1) f.invierte();
                                       if (f.esDoble()&&f.horizontal)f.gira();
                                       if (!f.esDoble()&&!f.horizontal) f.gira();
                                       if (f.esDoble())
                                            Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X2,Y2-Ficha.tamaño/2, -1, -1));
                                       else Tablero.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(X2,Y2, -1, -1));
                                        
                                        if (!f.visible) f.vuelta();
                                         if(X2<220){Y2=Y2+100;b2=0;
                                         //X2-=Ficha.tamaño*2;
                                         }
                                        
                                      
                                      j.fichas.remove(f);
                                      f=null;
                                      cursor.e1=c1;
                                      cursor.e2=c2;
                                      Tablero.validate();
                                       
                                }
                                     
       }   
    else {  if (!(j instanceof JugadorVirtual))
                javax.swing.JOptionPane.showMessageDialog
                                (null,"Seleccion incorrecta "+f.toString(),"Forro"+j.nombre+" pierdes el turno",javax.swing.JOptionPane.OK_OPTION);      
                   area.setText(
                   j.nombre+"\n"+
                   "Seleccion incorrecta\n"+
                   "Esto es Forro...\n"+
                   area.getText()
                    ); 
    
                 f.seleccionada=false;
                 j.fichas.add(f);
                  
                 }               
        }
       
        
       ////////////////////////////////////////////////////////////////////////
        boolean llevaalguien=false; 
        
        
        for(int i=0;i<jugadores.size();i++) 
         {Jugador x=(Jugador)jugadores.get(i);
             if (cursor!=null&&(x.LLeva(cursor.e1)||x.LLeva(cursor.e2))) llevaalguien=true;
         
         }
        
        if (j.fichas.isEmpty())
            
            
                  { for(int i=0;i<jugadores.size();i++)
                       for(int y=0;y<((Jugador)jugadores.get(i)).fichas.size();y++)
                       {Ficha fi=(Ficha)((Jugador)jugadores.get(i)).fichas.get(y);
                       
                         if (!fi.visible) fi.vuelta();
                        
                       }
                      
                      
                      javax.swing.JOptionPane.showMessageDialog
                                (null,"Ha ganado "+j.nombre,"Fin",javax.swing.JOptionPane.OK_OPTION);
                                              
                     area.setText(
                   j.nombre+"\n"+
                   "Ha ganado\n"+
                   "Fin\n"+
                   area.getText()
                    );       
                  
                  
                   vueltas.cancel();
                   Tablero.removeAll();
                   Tablero.repaint();
                  }
        
        else if (!llevaalguien){                          
                           Hashtable tabla=new Hashtable();
                           
                           for(int i=0;i<jugadores.size();i++)
                           {Jugador x=(Jugador)jugadores.get(i);
                            int puntos=0;
                              for(int p=0;p<x.fichas.size();p++)
                               {Ficha fx=(Ficha)x.fichas.get(p);
                               puntos+=fx.e1+fx.e2;
                               }     
                              
                            tabla.put(x,puntos);
                           
                           }
                           
                           int menor=100000;
                           Jugador ganador=null;
                           
                           Enumeration e=tabla.keys();
                            while(e.hasMoreElements())
                            {Jugador r=(Jugador)e.nextElement();
                             if (menor>(int)tabla.get(r)){menor=(int)tabla.get(r);ganador=r;}
                            }
                           
                           
                          
                              for(int i=0;i<jugadores.size();i++)
                       for(int y=0;y<((Jugador)jugadores.get(i)).fichas.size();y++)
                       {Ficha fi=(Ficha)((Jugador)jugadores.get(i)).fichas.get(y);
                       
                         if (!fi.visible) fi.vuelta();
                        
                       }
                            
                             e=tabla.keys();
                             
                            while(e.hasMoreElements())
                           { Jugador z=(Jugador)e.nextElement();
                             int r=(int)tabla.get(z);
                            if (r==menor){  
                                
                                
                                javax.swing.JOptionPane.showMessageDialog
                                (null,"Ha ganado "+z.nombre+"\n"+
                                        "con "+r+" puntos.","Fin",javax.swing.JOptionPane.OK_OPTION);
                            area.setText(
                            z.nombre+"\n"+
                           "Ha ganado\n"+
                           "con "+r+" puntos.\n"+
                           "Fin\n"+
                           area.getText()
                            );             
                            
                            }
                           }
                           
                         
                           
                            vueltas.cancel();
                           Tablero.removeAll();
                           Tablero.repaint();
        
                           }
        
        /////////////////////////////////////////////////////////////////////
        
        
        //////////////////////////////////////////////////////////////////////
        
        
        for(int i=0;i<jugadores.size();i++)
        {if (jugadores.get(i).equals(j1)) j1.fichas=((Jugador)jugadores.get(i)).fichas;
        if (jugadores.get(i).equals(j2)) j2.fichas=((Jugador)jugadores.get(i)).fichas;
        if (jugadores.get(i).equals(j3)) j3.fichas=((Jugador)jugadores.get(i)).fichas;
        if (jugadores.get(i).equals(j4)) j4.fichas=((Jugador)jugadores.get(i)).fichas;
        }
         panelJugador1.removeAll();
         panelJugador2.removeAll();
        panelJugador3.removeAll();
        panelJugador4.removeAll();
        for(int i=0;i<j1.fichas.size();i++) panelJugador1.add((Ficha)j1.fichas.get(i));
        for(int i=0;i<j2.fichas.size();i++) panelJugador2.add((Ficha)j2.fichas.get(i));
        if(jugadores.size()>=3)
        for(int i=0;i<j3.fichas.size();i++) panelJugador3.add((Ficha)j3.fichas.get(i));
        if (jugadores.size()==4)
        for(int i=0;i<j4.fichas.size();i++) panelJugador4.add((Ficha)j4.fichas.get(i));
        
         for(int i=0;i<j1.fichas.size();i++)
        {Ficha f=(Ficha)j1.fichas.get(i);
        if (f.horizontal)f.gira();
        if (!f.visible)f.vuelta();
        f.b1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {f.punta=f.e1;f.seleccionada=true;}
           public void mouseMoved(java.awt.event.MouseEvent evt) {}
            });
        f.b2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
           public void mouseDragged(java.awt.event.MouseEvent evt) {f.punta=f.e2;f.seleccionada=true;}
          public void mouseMoved(java.awt.event.MouseEvent evt) {}
            });      
        }
        
         for(int i=0;i<j2.fichas.size();i++)
        {Ficha f=(Ficha)j2.fichas.get(i);
        if (!f.horizontal) f.gira();
        if (f.visible)f.vuelta();
           
        }
         if(jugadores.size()>=3){
        for(int i=0;i<j3.fichas.size();i++)
        {Ficha f=(Ficha)j3.fichas.get(i);
        if (f.horizontal) f.gira();
           if (f.visible)f.vuelta();
        }}
         if(jugadores.size()==4){
        for(int i=0;i<j4.fichas.size();i++)
        {Ficha f=(Ficha)j4.fichas.get(i);
        if (!f.horizontal) f.gira();
           if (f.visible)f.vuelta();
        }}
         
        panelJugador1.repaint();
        panelJugador1.setLayout(new java.awt.GridLayout(1,j1.fichas.size(), 0, 0));
        Tablero.add(panelJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, Ficha.tamaño*j1.fichas.size(), Ficha.tamaño*2));

        panelJugador2.repaint();
        panelJugador2.setLayout(new java.awt.GridLayout(j2.fichas.size(), 1, 0, 0));
        Tablero.add(panelJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, Ficha.tamaño*2, j2.fichas.size()*Ficha.tamaño));
        
        if (jugadores.size()>=3){
        panelJugador3.repaint();
        panelJugador3.setLayout(new java.awt.GridLayout(1,j3.fichas.size(), 0, 0));
        Tablero.add(panelJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, Ficha.tamaño*j3.fichas.size(), Ficha.tamaño*2));
        }
        if (jugadores.size()==4){
        panelJugador4.repaint();
        panelJugador4.setLayout(new java.awt.GridLayout(j4.fichas.size(), 1, 0, 0));
        Tablero.add(panelJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, Ficha.tamaño*2,j4.fichas.size()*Ficha.tamaño));
        }
        Tablero.validate();
        
        jugadorpos++;           
        if (jugadorpos==jugadores.size()) jugadorpos=0;
        
    
        
        }

}
   
    // Variables declaration - do not modify                     
    private javax.swing.JPanel Tablero;
    private javax.swing.JButton jButton1;
  
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombreJugador1;
    private javax.swing.JLabel nombreJugador2;
    private javax.swing.JLabel nombreJugador3;
    private javax.swing.JLabel nombreJugador4;
    private javax.swing.JPanel panelJugador1;
    private javax.swing.JPanel panelJugador2;
    private javax.swing.JPanel panelJugador3;
    private javax.swing.JPanel panelJugador4;
    // End of variables declaration                   

}
