/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author alancisneros
 */
public class Dato implements Serializable{
    int punta;
    Ficha f;
    ArrayList jugadores;
    
 public Dato(Ficha f,int punta,ArrayList jugadores ){
 this.punta=punta;this.f=f;this.jugadores=jugadores;
 }   
}
