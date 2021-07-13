/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AltinToplamaOyunu;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import javax.swing.*;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import static javax.swing.JSplitPane.TOP;

/**
 *
 * @author Bayram
 */


public class Panel extends javax.swing.JFrame { 
         OyunTahtası OyunTahtası=new OyunTahtası();
         //Altinlarin yerlerini tutan matris ve miktarini tutan dizi
         int[][] altinmatris = new int[OyunTahtası.getSatirsayisi()][OyunTahtası.getSütünsayisi()];
         int [] altinmiktari=new int[OyunTahtası.getAltinmiktari()+OyunTahtası.getGizlialtinmiktari()];
         //Altınlar ve oyun tahtasını oluşturan butonlar
         JButton altin[]=new JButton[OyunTahtası.getAltinmiktari()];
         JButton buton[][]=new JButton[OyunTahtası.getSatirsayisi()][OyunTahtası.getSütünsayisi()];
         String Baglanti="C:\\Users\\Bayram\\Desktop";//Buraya çıktıların oluşacağı adresi giriniz
         Aoyuncusu Aoyuncusu=new Aoyuncusu();
         Boyuncusu Boyuncusu=new Boyuncusu();
         Coyuncusu Coyuncusu=new Coyuncusu();
         Doyuncusu Doyuncusu=new Doyuncusu();  
         //Oyuncuların hedeflenen altına rotalarını tutan arraylistler
         ArrayList<Integer> ARota = new ArrayList<Integer>();
         ArrayList<Integer> BRota = new ArrayList<Integer>();
         ArrayList<Integer> CRota = new ArrayList<Integer>();
         ArrayList<Integer> DRota = new ArrayList<Integer>();
         int j;
         int i;
         //Dinamik boyutlandırma için image icon scale kullanımı
         ImageIcon coin1; ImageIcon coin11=new javax.swing.ImageIcon(getClass().getResource("/img/1coin.jpg"));
         ImageIcon coin2; ImageIcon coin22=new javax.swing.ImageIcon(getClass().getResource("/img/2coin.jpg"));
         ImageIcon coin3; ImageIcon coin33=new javax.swing.ImageIcon(getClass().getResource("/img/3coin.jpg"));
         ImageIcon coin4; ImageIcon coin44=new javax.swing.ImageIcon(getClass().getResource("/img/4coin.jpg"));
         ImageIcon gizlicoin1; ImageIcon gizlicoin11=new javax.swing.ImageIcon(getClass().getResource("/img/gizli1coin.jpg"));
         ImageIcon gizlicoin2; ImageIcon gizlicoin22=new javax.swing.ImageIcon(getClass().getResource("/img/gizli2coin.jpg"));
         ImageIcon gizlicoin3; ImageIcon gizlicoin33=new javax.swing.ImageIcon(getClass().getResource("/img/gizli3coin.jpg"));
         ImageIcon gizlicoin4; ImageIcon gizlicoin44=new javax.swing.ImageIcon(getClass().getResource("/img/gizli4coin.jpg"));
         ImageIcon AOyuncusu; ImageIcon Ao=new javax.swing.ImageIcon(getClass().getResource("/img/Aoyuncusu.jpg"));
         ImageIcon BOyuncusu; ImageIcon Bo=new javax.swing.ImageIcon(getClass().getResource("/img/Boyuncusu.jpg"));
         ImageIcon COyuncusu; ImageIcon Co=new javax.swing.ImageIcon(getClass().getResource("/img/Coyuncusu.jpg"));
         ImageIcon DOyuncusu; ImageIcon Do=new javax.swing.ImageIcon(getClass().getResource("/img/Doyuncusu.jpg"));
         int Boyut;
     //Dosyaya yazma fonksiyonları      
        private static void DosyaAc(String data) {
        File file = new File(data);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);           
        } catch (IOException e) {
            e.printStackTrace();
        }finally{          
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        private static void DosyaYaz(String data,String File) {       
        PrintWriter pw = null;
  try {
     File file = new File(File);
     FileWriter fw = new FileWriter(file, true);
     pw = new PrintWriter(fw);
     pw.println(data);
  } catch (IOException e) {
     e.printStackTrace();
  } finally {
     if (pw != null) {
        pw.close();
     }
  }
    }
     //Manuel görsel eklentiler
        public void myinitComponents() {
 //   Ayarlar();
            ImageIcon coin1; ImageIcon coin11=new javax.swing.ImageIcon(getClass().getResource("/img/1coin.jpg"));
            ImageIcon coin2; ImageIcon coin22=new javax.swing.ImageIcon(getClass().getResource("/img/2coin.jpg"));
            ImageIcon coin3; ImageIcon coin33=new javax.swing.ImageIcon(getClass().getResource("/img/3coin.jpg"));
            ImageIcon coin4; ImageIcon coin44=new javax.swing.ImageIcon(getClass().getResource("/img/4coin.jpg"));
            ImageIcon gizlicoin1; ImageIcon gizlicoin11=new javax.swing.ImageIcon(getClass().getResource("/img/gizli1coin.jpg"));
            ImageIcon gizlicoin2; ImageIcon gizlicoin22=new javax.swing.ImageIcon(getClass().getResource("/img/gizli2coin.jpg"));
            ImageIcon gizlicoin3; ImageIcon gizlicoin33=new javax.swing.ImageIcon(getClass().getResource("/img/gizli3coin.jpg"));
            ImageIcon gizlicoin4; ImageIcon gizlicoin44=new javax.swing.ImageIcon(getClass().getResource("/img/gizli4coin.jpg"));
            int satir=OyunTahtası.getSatirsayisi();
            int sütün=OyunTahtası.getSütünsayisi();
            if(satir>sütün){
                Boyut=1000/satir;
            }
            else{
                Boyut=1000/sütün;
            }
            
            coin1 = new ImageIcon(coin11.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin2 = new ImageIcon(coin22.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin3 = new ImageIcon(coin33.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin4 = new ImageIcon(coin44.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            gizlicoin1 = new ImageIcon(gizlicoin11.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            gizlicoin2 = new ImageIcon(gizlicoin22.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            gizlicoin3 = new ImageIcon(gizlicoin33.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            gizlicoin4 = new ImageIcon(gizlicoin44.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            AOyuncusu = new ImageIcon(Ao.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            BOyuncusu = new ImageIcon(Bo.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            COyuncusu = new ImageIcon(Co.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            DOyuncusu = new ImageIcon(Do.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
     altinmatris = new int[OyunTahtası.getSatirsayisi()][OyunTahtası.getSütünsayisi()];
         
     altin=new JButton[OyunTahtası.getAltinmiktari()-4];
     buton=new JButton[OyunTahtası.getSatirsayisi()][OyunTahtası.getSütünsayisi()];
     altinmiktari=new int[OyunTahtası.getAltinmiktari()];
     A=new javax.swing.JButton();
     B=new javax.swing.JButton();  
     C=new javax.swing.JButton();  
     D=new javax.swing.JButton();     
                Random rand = new Random();                
       for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
           for (int l = 0; l < OyunTahtası.getSütünsayisi(); l++) {
               altinmatris[k][l]=-1;
           }
        
    }
       
       int ay=10;
        for(j=0;j<OyunTahtası.getSatirsayisi();j++){
        for(i=0;i<OyunTahtası.getSütünsayisi();i++){
        buton[j][i]=new javax.swing.JButton();
        jPanel3.add(buton[j][i],CENTER,0);
        buton[j][i].setBounds(10+i*Boyut,ay, Boyut,Boyut);
        
       // buton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));    
        buton[j][i].setVisible(true);
        buton[j][i].setBackground(Color.white);
        if((j+i)%2==0){
            buton[j][i].setBackground(Color.LIGHT_GRAY);
        }
        buton[j][i].setRolloverEnabled(false);
        buton[j][i].setEnabled(false);
        buton[j][i].setFocusable(false);
        
     // buton.setLayout(null);
        }
        ay=ay+Boyut;
        }       
        for (int k = 0; k <OyunTahtası.getAltinmiktari()-4; k++) {         
                    int rand1=rand.nextInt(OyunTahtası.getSatirsayisi());
                    int rand2=rand.nextInt(OyunTahtası.getSütünsayisi());
                    int rand3=rand.nextInt(4)+1;
                if(altinmatris[rand1][rand2]!=-1||(rand1==0&&rand2==0)||(rand1==OyunTahtası.getSatirsayisi()-1&&rand2==OyunTahtası.getSütünsayisi()-1)||(rand1==0&&rand2==OyunTahtası.getSütünsayisi()-1)||(rand1==OyunTahtası.getSatirsayisi()-1&&rand2==0)){
                    k--;
                    continue;
                }    
                altin[k]=new javax.swing.JButton();
                altinmiktari[k]=rand3;
                if(k<OyunTahtası.getAltinmiktari()-OyunTahtası.getGizlialtinmiktari()){
                if(rand3==1){
                    altin[k].setIcon(coin1);
                }
                if(rand3==2){
                    altin[k].setIcon(coin2);
                }
                if(rand3==3){
                    altin[k].setIcon(coin3);
                }
                if(rand3==4){
                    altin[k].setIcon(coin4);
                }}
                else{
                    if(rand3==1){
                    altin[k].setIcon(gizlicoin1);
                }
                if(rand3==2){
                    altin[k].setIcon(gizlicoin2);
                }
                if(rand3==3){
                    altin[k].setIcon(gizlicoin3);
                }
                if(rand3==4){
                    altin[k].setIcon(gizlicoin4);
                }
                }
               
              //  getContentPane().add(altin[k]);
               jPanel3.add(altin[k],CENTER,1);
            //   altin[k].setRolloverEnabled(false);
               altin[k].setBorder(null);
               altin[k].setFocusable(false);
                altin[k].setBounds(buton[rand1][rand2].getX()+1, buton[rand1][rand2].getY()+1, Boyut-2, Boyut-2);
                if(k<OyunTahtası.getAltinmiktari()-OyunTahtası.getGizlialtinmiktari()){
                altinmatris[rand1][rand2]=k;}
                else{
                    altinmatris[rand1][rand2]=-k;
                }     
        }
        jPanel3.add(A,TOP,0);
        jPanel3.add(B,TOP,0);
        jPanel3.add(C,TOP,0);
        jPanel3.add(D,TOP,0);
        A.setIcon(AOyuncusu);
       A.setBounds(11, 11, Boyut-2, Boyut-2);
       B.setIcon(BOyuncusu);
       
       B.setBounds(buton[0][OyunTahtası.getSütünsayisi()-1].getX()+1,buton[0][OyunTahtası.getSütünsayisi()-1].getY()+1, Boyut-2, Boyut-2);
       Boyuncusu.setKonumSütün(OyunTahtası.getSütünsayisi()-1);
     C.setIcon(COyuncusu);
       C.setBounds(buton[OyunTahtası.getSatirsayisi()-1][OyunTahtası.getSütünsayisi()-1].getX()+1,buton[OyunTahtası.getSatirsayisi()-1][OyunTahtası.getSütünsayisi()-1].getY()+1, Boyut-2, Boyut-2);
       D.setIcon(DOyuncusu);
       D.setBounds(buton[OyunTahtası.getSatirsayisi()-1][0].getX()+1,buton[OyunTahtası.getSatirsayisi()-1][0].getY()+1, Boyut-2, Boyut-2);
       Coyuncusu.setKonumSütün(OyunTahtası.getSütünsayisi()-1);
       Coyuncusu.setKonumSatir(OyunTahtası.getSatirsayisi()-1);
       Doyuncusu.setKonumSatir(OyunTahtası.getSatirsayisi()-1);
       A.setBorder(null);
        B.setBorder(null);
        C.setBorder(null);
        D.setBorder(null);
}
     //Oyuncu hareketleri için fonksiyonlar     
        public void ARotaCiz(){                                  
            if(Aoyuncusu.getKonumSatir()-Aoyuncusu.getHedefAltinSatir()>0){
                for (int k= 0; k < Aoyuncusu.getKonumSatir()-Aoyuncusu.getHedefAltinSatir(); k++) {
                    ARota.add(4);
                    
                }
            }
            if(Aoyuncusu.getKonumSatir()-Aoyuncusu.getHedefAltinSatir()<0){
                for (int k= 0; k < Aoyuncusu.getHedefAltinSatir()-Aoyuncusu.getKonumSatir(); k++) {
                    ARota.add(2);
                    
                }
            }
            if(Aoyuncusu.getKonumSütün()-Aoyuncusu.getHedefAltinSütün()>0){
                for (int k= 0; k < Aoyuncusu.getKonumSütün()-Aoyuncusu.getHedefAltinSütün(); k++) {
                    ARota.add(1);
                    
                }
            }
            if(Aoyuncusu.getKonumSütün()-Aoyuncusu.getHedefAltinSütün()<0){
                for (int k= 0; k < Aoyuncusu.getHedefAltinSütün()-Aoyuncusu.getKonumSütün(); k++) {
                    ARota.add(3);
                    
                }
            }
        }
        public void AHedefSec(){
            float adımsayısı=(float)OyunTahtası.getAdimsayisi();
       int enyakin=999;
       int enyakinaltin=999;
       int altinx=0;
       int altiny=0;        
            for (int n = 0; n < OyunTahtası.getSatirsayisi(); n++) {
                for (int m = 0; m < OyunTahtası.getSütünsayisi(); m++) {
                    if(altinmatris[n][m]>-1){
                        if(enyakin>Math.abs(Aoyuncusu.getKonumSatir()-n)+Math.abs(Aoyuncusu.getKonumSütün()-m)){
                            enyakinaltin=altinmatris[n][m];                         
                            enyakin=Math.abs(Aoyuncusu.getKonumSatir()-n)+Math.abs(Aoyuncusu.getKonumSütün()-m);
                            altinx=n;
                            altiny=m;
                        }
                    }
                    
                }
                
            }
            
              Aoyuncusu.setHedefAltinSatir(altinx);
            Aoyuncusu.setHedefAltinSütün(altiny);
            if(altinmatris[altinx][altiny]>-1){
            buton[altinx][altiny].setBackground(Color.red);
            altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut, Boyut);
            altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut-6, Boyut-6);  
          //  altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , artismiktari+6, artismiktari+6);        
            
            Aoyuncusu.setAltin(Aoyuncusu.getAltin()-Aoyuncusu.getHedefMaliyeti());
            Aoyuncusu.setHarcananAltinMiktari(Aoyuncusu.getHarcananAltinMiktari()+Aoyuncusu.getHedefMaliyeti());
            }
            
            
        }
        public void AHareketEt(){
            //Dinamik boyutlandırma için image icon scale kullanımı
            coin1 = new ImageIcon(coin11.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin2 = new ImageIcon(coin22.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin3 = new ImageIcon(coin33.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin4 = new ImageIcon(coin44.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            int k;
            int a=0;
            for ( k=Aoyuncusu.getKalinanRota() ; k <Aoyuncusu.getKalinanRota()+OyunTahtası.getAdimsayisi(); k++) {
                String konum="["+Aoyuncusu.getKonumSatir()+","+Aoyuncusu.getKonumSütün()+"]";
                DosyaYaz(konum,Baglanti+"\\A.txt");
                Aoyuncusu.setAdımSayısı(Aoyuncusu.getAdımSayısı()+1);
            if(altinmatris[Aoyuncusu.getHedefAltinSatir()][Aoyuncusu.getHedefAltinSütün()]==-1){
                ARota.clear();
                Aoyuncusu.setKalinanRota(0);
                if(Aoyuncusu.getHedefAltinSatir()==0&&Aoyuncusu.getHedefAltinSütün()==0){
                    break;
                }
                else{
                
                AHedefSec();   
                ARotaCiz();
                
                
                k=0;
                }
                
            }    
                if(ARota.size()>Aoyuncusu.getKalinanRota()){
                if(ARota.get(k)==1){
                    Aoyuncusu.setKonumSütün(Aoyuncusu.getKonumSütün()-1);
                    A.setLocation(buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getX()+1, buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getY()+1);
                    
                }
                if(ARota.get(k)==2){
                    Aoyuncusu.setKonumSatir(Aoyuncusu.getKonumSatir()+1);
                    A.setLocation(buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getX()+1, buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getY()+1);
                    
                    
                }
                if(ARota.get(k)==3){
                    Aoyuncusu.setKonumSütün(Aoyuncusu.getKonumSütün()+1);
                    A.setLocation(buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getX()+1, buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getY()+1);
                    
                   
                }
                if(ARota.get(k)==4){
                    Aoyuncusu.setKonumSatir(Aoyuncusu.getKonumSatir()-1);
                    A.setLocation(buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getX()+1, buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].getY()+1);
                    
                }
                }
                if(altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]<-1){
                    int gizlialtin=altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]*(-1);
                    if(altinmiktari[gizlialtin]==1){
                        altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]=altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]].setIcon(coin1);
                        
                    }
                    if(altinmiktari[gizlialtin]==2){
                        altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]=altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]].setIcon(coin2);
                    }
                    if(altinmiktari[gizlialtin]==3){
                        altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]=altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]].setIcon(coin3);
                    }
                    if(altinmiktari[gizlialtin]==4){
                        altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]=altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]].setIcon(coin4);
                    }
                }
                if(altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]!=-1&&Aoyuncusu.getHedefAltinSatir()==Aoyuncusu.getKonumSatir()&&Aoyuncusu.getHedefAltinSütün()==Aoyuncusu.getKonumSütün()){
                    ARota.clear();
                    Aoyuncusu.setKalinanRota(0);
                    //Aoyuncusu.setRota(ARota);
                    a++;
              //      getContentPane().remove(altin[altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]]);
                    if((Aoyuncusu.getKonumSatir()+Aoyuncusu.getKonumSütün())%2==0){
                        buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].setBackground(Color.LIGHT_GRAY);
                    }
                    else{
                        buton[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()].setBackground(Color.white);
                    }
                    int eklenecek=altinmiktari[altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]];
                     Aoyuncusu.setAltin(Aoyuncusu.getAltin()+eklenecek*5);
                     Aoyuncusu.setToplananAltinMiktari(Aoyuncusu.getToplananAltinMiktari()+eklenecek*5);
                     jPanel3.remove(altin[altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]]);
                    altinmatris[Aoyuncusu.getKonumSatir()][Aoyuncusu.getKonumSütün()]=-1;
                    AHedefSec();
                    ARotaCiz();        
                    
                    break;
                }
                
                
            }
            if(a==0){
            Aoyuncusu.setKalinanRota(k);
            }
            Aoyuncusu.setAltin(Aoyuncusu.getAltin()-Aoyuncusu.getHamleMaliyeti());
            Aoyuncusu.setHarcananAltinMiktari(Aoyuncusu.getHarcananAltinMiktari()+Aoyuncusu.getHamleMaliyeti());
        }
        public void BHedefSec(){
            float adımsayısı=(float)OyunTahtası.getAdimsayisi();
       float enyakin=(float) 9999.0;
       int enyakinaltin=999;
       int altinx=0;
       int altiny=0;      
       int kar=-9999;
            for (int n = 0; n < OyunTahtası.getSatirsayisi(); n++) {
                for (int m = 0; m < OyunTahtası.getSütünsayisi(); m++) {
                    if(altinmatris[n][m]>-1){
                        //if(enyakin>Math.abs(Boyuncusu.getKonumSatir()-n)+Math.abs(Boyuncusu.getKonumSütün()-m)){
                            enyakinaltin=altinmatris[n][m];                         
                            enyakin=Math.abs(Boyuncusu.getKonumSatir()-n)+Math.abs(Boyuncusu.getKonumSütün()-m);
                            if(((altinmiktari[enyakinaltin]*5)-(Math.ceil(enyakin/adımsayısı))*5)>kar){
                            altinx=n;
                            altiny=m;
                            kar=(altinmiktari[enyakinaltin]*5)-(int)(Math.ceil(enyakin/adımsayısı)*5);
                      //      }
                            
                        }
                    }
                    
                }
                
            }
            
                
            Boyuncusu.setHedefAltinSatir(altinx);
            Boyuncusu.setHedefAltinSütün(altiny);
          if(altinmatris[altinx][altiny]>-1){
            buton[altinx][altiny].setBackground(Color.blue);
            altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut, Boyut);
            altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut-6,Boyut-6);
            Boyuncusu.setAltin(Boyuncusu.getAltin()-Boyuncusu.getHedefMaliyeti());
            Boyuncusu.setHarcananAltinMiktari(Boyuncusu.getHarcananAltinMiktari()+Boyuncusu.getHedefMaliyeti());
                }
            
        }
        public void BRotaCiz(){
            if(Boyuncusu.getKonumSatir()-Boyuncusu.getHedefAltinSatir()>0){
                for (int k= 0; k < Boyuncusu.getKonumSatir()-Boyuncusu.getHedefAltinSatir(); k++) {
                    BRota.add(4);
                    
                }
            }
            if(Boyuncusu.getKonumSatir()-Boyuncusu.getHedefAltinSatir()<0){
                for (int k= 0; k < Boyuncusu.getHedefAltinSatir()-Boyuncusu.getKonumSatir(); k++) {
                    BRota.add(2);
                    
                }
            }
            if(Boyuncusu.getKonumSütün()-Boyuncusu.getHedefAltinSütün()>0){
                for (int k= 0; k < Boyuncusu.getKonumSütün()-Boyuncusu.getHedefAltinSütün(); k++) {
                    BRota.add(1);
                    
                }
            }
            if(Boyuncusu.getKonumSütün()-Boyuncusu.getHedefAltinSütün()<0){
                for (int k= 0; k < Boyuncusu.getHedefAltinSütün()-Boyuncusu.getKonumSütün(); k++) {
                    BRota.add(3);
                    
                }
            }
        }
        public void BHareketEt(){
            //Dinamik boyutlandırma için image icon scale kullanımı
            coin1 = new ImageIcon(coin11.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin2 = new ImageIcon(coin22.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin3 = new ImageIcon(coin33.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin4 = new ImageIcon(coin44.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
             int k;
            int a=0;
            for ( k=Boyuncusu.getKalinanRota() ; k <Boyuncusu.getKalinanRota()+OyunTahtası.getAdimsayisi(); k++) {
                
                String konum="["+Boyuncusu.getKonumSatir()+","+Boyuncusu.getKonumSütün()+"]";
                DosyaYaz(konum,Baglanti+"\\B.txt");
                Boyuncusu.setAdımSayısı(Boyuncusu.getAdımSayısı()+1);
                if(altinmatris[Boyuncusu.getHedefAltinSatir()][Boyuncusu.getHedefAltinSütün()]==-1){
                BRota.clear();
                Boyuncusu.setKalinanRota(0);
                
                
                if(Boyuncusu.getHedefAltinSatir()==0&&Boyuncusu.getHedefAltinSütün()==0){
                    break;
                }
                else{
                BHedefSec();
                BRotaCiz();          
                k=0;
                }
            }    
                
                if(BRota.size()>Boyuncusu.getKalinanRota()){
                if(BRota.get(k)==1){
                    Boyuncusu.setKonumSütün(Boyuncusu.getKonumSütün()-1);
                    B.setLocation(buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getX()+1, buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getY()+1);
                    
                }
                if(BRota.get(k)==2){
                    Boyuncusu.setKonumSatir(Boyuncusu.getKonumSatir()+1);
                    B.setLocation(buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getX()+1, buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getY()+1);
                    
                    
                }
                if(BRota.get(k)==3){
                    Boyuncusu.setKonumSütün(Boyuncusu.getKonumSütün()+1);
                    B.setLocation(buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getX()+1, buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getY()+1);
                    
                   
                }
                if(BRota.get(k)==4){
                    Boyuncusu.setKonumSatir(Boyuncusu.getKonumSatir()-1);
                    B.setLocation(buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getX()+1, buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].getY()+1);
                    
                }
                }
                if(altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]<-1){
                    int gizlialtin=altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]*(-1);
                    if(altinmiktari[gizlialtin]==1){
                        
                        altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]=altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]].setIcon(coin1);
                    }
                    if(altinmiktari[gizlialtin]==2){
                        altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]=altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]].setIcon(coin2);
                        
                    }
                    if(altinmiktari[gizlialtin]==3){
                        altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]=altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]].setIcon(coin3);
                        
                    }
                    if(altinmiktari[gizlialtin]==4){
                        altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]=altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]].setIcon(coin4);
                        
                    }
                }
                
                
                
                if(altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]!=-1&&Boyuncusu.getHedefAltinSatir()==Boyuncusu.getKonumSatir()&&Boyuncusu.getHedefAltinSütün()==Boyuncusu.getKonumSütün()){
                    BRota.clear();
                    Boyuncusu.setKalinanRota(0);
                    //Aoyuncusu.setRota(ARota);
                    a++;
                    jPanel3.remove(altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]]);
                    if((Boyuncusu.getKonumSatir()+Boyuncusu.getKonumSütün())%2==0){
                        buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].setBackground(Color.LIGHT_GRAY);
                    }
                    else{
                        buton[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()].setBackground(Color.white);
                    }
                //     getContentPane().remove(altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]]);
                     int eklenecek=altinmiktari[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]];
                     Boyuncusu.setAltin(Boyuncusu.getAltin()+eklenecek*5);
                     Boyuncusu.setToplananAltinMiktari(Boyuncusu.getToplananAltinMiktari()+eklenecek*5);
                    altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]=-1;
                    BHedefSec();
                    BRotaCiz();        
                    
                    break;
                }
                
                
                
            }
            if(a==0){
            Boyuncusu.setKalinanRota(k);
            }
            Boyuncusu.setAltin(Boyuncusu.getAltin()-Boyuncusu.getHamleMaliyeti());
            Boyuncusu.setHarcananAltinMiktari(Boyuncusu.getHarcananAltinMiktari()+Boyuncusu.getHamleMaliyeti());
        }
        public void CGizliAltinAc(){
       int enyakin[]={9999,9999};
       int enyakinaltin=999;
       int altinx[]={0,0};
       int altiny[]={0,0};
       int kontrol;
            coin1 = new ImageIcon(coin11.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin2 = new ImageIcon(coin22.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin3 = new ImageIcon(coin33.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin4 = new ImageIcon(coin44.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
       for(int k=0;k<2;k++){
           kontrol=0;
            for (int m = 0; m < OyunTahtası.getSütünsayisi(); m++) {
                for (int n = 0; n < OyunTahtası.getSatirsayisi(); n++) {
                    if(altinmatris[n][m]<-1){
                        if(enyakin[k]>Math.abs(Coyuncusu.getKonumSatir()-n)+Math.abs(Coyuncusu.getKonumSütün()-m)){
                            enyakinaltin=altinmatris[n][m];                         
                            enyakin[k]=Math.abs(Coyuncusu.getKonumSatir()-n)+Math.abs(Coyuncusu.getKonumSütün()-m);
                            altinx[k]=n;
                            altiny[k]=m;
                            kontrol++;
                        }
                    }
                    
                }
                
            }
            if(kontrol==0){
                break;
            }
       int gizlialtin=altinmatris[altinx[k]][altiny[k]]*(-1);
                    if(altinmiktari[gizlialtin]==1){
                        
                        altinmatris[altinx[k]][altiny[k]]=altinmatris[altinx[k]][altiny[k]]*(-1);
                        altin[altinmatris[altinx[k]][altiny[k]]].setIcon(coin1);
                    }
                    if(altinmiktari[gizlialtin]==2){
                        altinmatris[altinx[k]][altiny[k]]=altinmatris[altinx[k]][altiny[k]]*(-1);
                        altin[altinmatris[altinx[k]][altiny[k]]].setIcon(coin2);
                        
                    }
                    if(altinmiktari[gizlialtin]==3){
                        altinmatris[altinx[k]][altiny[k]]=altinmatris[altinx[k]][altiny[k]]*(-1);
                        altin[altinmatris[altinx[k]][altiny[k]]].setIcon(coin3);
                        
                    }
                    if(altinmiktari[gizlialtin]==4){
                        altinmatris[altinx[k]][altiny[k]]=altinmatris[altinx[k]][altiny[k]]*(-1);
                        altin[altinmatris[altinx[k]][altiny[k]]].setIcon(coin4);
                        
                    }
       
       }
        
        }
        public void CHedefSec(){
              float enyakin=(float) 9999.0;
              float adımsayısı=(float)OyunTahtası.getAdimsayisi();
       int enyakinaltin=999;
       int altinx=0;
       int altiny=0;      
       int enkarlix=0;
       int enkarliy=0;
       int kar=-9999;
            for (int n = 0; n < OyunTahtası.getSatirsayisi(); n++) {
                for (int m = 0; m < OyunTahtası.getSütünsayisi(); m++) {
                    if(altinmatris[n][m]>-1){
                        //if(enyakin>Math.abs(Boyuncusu.getKonumSatir()-n)+Math.abs(Boyuncusu.getKonumSütün()-m)){
                            enyakinaltin=altinmatris[n][m];                         
                            enyakin=Math.abs(Coyuncusu.getKonumSatir()-n)+Math.abs(Coyuncusu.getKonumSütün()-m);
                            if(((altinmiktari[enyakinaltin]*5)-(Math.ceil(enyakin/adımsayısı))*5)>kar){
                            altinx=n;
                            altiny=m;
                            kar=((altinmiktari[enyakinaltin]*5)-(int)(Math.ceil(enyakin/adımsayısı))*5);
                      //      }
                            
                        }
                    }
                    
                }
                
            }
            
            Coyuncusu.setHedefAltinSatir(altinx);
            Coyuncusu.setHedefAltinSütün(altiny);
            if(altinmatris[altinx][altiny]>-1){
            buton[altinx][altiny].setBackground(Color.GREEN);
           altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut, Boyut);
            altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut-6, Boyut-6);
            Coyuncusu.setAltin(Coyuncusu.getAltin()-Coyuncusu.getHedefMaliyeti());
            Coyuncusu.setHarcananAltinMiktari(Coyuncusu.getHarcananAltinMiktari()+Coyuncusu.getHedefMaliyeti());
            }
           
            
          
        }
        public void CRotaCiz(){
            if(Coyuncusu.getKonumSatir()-Coyuncusu.getHedefAltinSatir()>0){
                for (int k= 0; k < Coyuncusu.getKonumSatir()-Coyuncusu.getHedefAltinSatir(); k++) {
                    CRota.add(4);
                    
                }
            }
            if(Coyuncusu.getKonumSatir()-Coyuncusu.getHedefAltinSatir()<0){
                for (int k= 0; k < Coyuncusu.getHedefAltinSatir()-Coyuncusu.getKonumSatir(); k++) {
                    CRota.add(2);
                    
                }
            }
            if(Coyuncusu.getKonumSütün()-Coyuncusu.getHedefAltinSütün()>0){
                for (int k= 0; k < Coyuncusu.getKonumSütün()-Coyuncusu.getHedefAltinSütün(); k++) {
                    CRota.add(1);
                    
                }
            }
            if(Coyuncusu.getKonumSütün()-Coyuncusu.getHedefAltinSütün()<0){
                for (int k= 0; k < Coyuncusu.getHedefAltinSütün()-Coyuncusu.getKonumSütün(); k++) {
                    CRota.add(3);
                    
                }
            }
        }
        public void CHareketEt(){
            //Dinamik boyutlandırma için image icon scale kullanımı
            coin1 = new ImageIcon(coin11.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin2 = new ImageIcon(coin22.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin3 = new ImageIcon(coin33.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin4 = new ImageIcon(coin44.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            int k;
            int a=0;
            for ( k=Coyuncusu.getKalinanRota() ; k <Coyuncusu.getKalinanRota()+OyunTahtası.getAdimsayisi(); k++) {
                String konum="["+Coyuncusu.getKonumSatir()+","+Coyuncusu.getKonumSütün()+"]";
                DosyaYaz(konum,Baglanti+"\\C.txt");
                Coyuncusu.setAdımSayısı(Coyuncusu.getAdımSayısı()+1);
                if(altinmatris[Coyuncusu.getHedefAltinSatir()][Coyuncusu.getHedefAltinSütün()]==-1){
                CRota.clear();
                Coyuncusu.setKalinanRota(0);
                if(Coyuncusu.getHedefAltinSatir()==0&&Coyuncusu.getHedefAltinSütün()==0){
                    break;
                }
                
                else{
                CHedefSec();
                CRotaCiz();            
                k=0;
                }
            }    
                
                if(CRota.size()>Coyuncusu.getKalinanRota()){
                if(CRota.get(k)==1){
                    Coyuncusu.setKonumSütün(Coyuncusu.getKonumSütün()-1);
                    C.setLocation(buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getX()+1, buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getY()+1);
                    
                }
                if(CRota.get(k)==2){
                    Coyuncusu.setKonumSatir(Coyuncusu.getKonumSatir()+1);
                    C.setLocation(buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getX()+1, buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getY()+1);
                    
                    
                }
                if(CRota.get(k)==3){
                    Coyuncusu.setKonumSütün(Coyuncusu.getKonumSütün()+1);
                    C.setLocation(buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getX()+1, buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getY()+1);
                    
                   
                }
                if(CRota.get(k)==4){
                    Coyuncusu.setKonumSatir(Coyuncusu.getKonumSatir()-1);
                    C.setLocation(buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getX()+1, buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].getY()+1);
                    
                }
                }
                if(altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]<-1){
                    int gizlialtin=altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]*(-1);
                    if(altinmiktari[gizlialtin]==1){
                        
                        altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]=altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]].setIcon(coin1);
                    }
                    if(altinmiktari[gizlialtin]==2){
                        altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]=altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]].setIcon(coin2);
                        
                    }
                    if(altinmiktari[gizlialtin]==3){
                        altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]=altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]].setIcon(coin3);
                        
                    }
                    if(altinmiktari[gizlialtin]==4){
                        altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]=altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]].setIcon(coin4);
                        
                    }
                }
                
                
                
                if(altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]!=-1&&Coyuncusu.getHedefAltinSatir()==Coyuncusu.getKonumSatir()&&Coyuncusu.getHedefAltinSütün()==Coyuncusu.getKonumSütün()){
                    CRota.clear();
                    Coyuncusu.setKalinanRota(0);
                    //Aoyuncusu.setRota(ARota);
                    a++;
                    jPanel3.remove(altin[altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]]);
                    if((Coyuncusu.getKonumSatir()+Coyuncusu.getKonumSütün())%2==0){
                        buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].setBackground(Color.LIGHT_GRAY);
                    }
                    else{
                        buton[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()].setBackground(Color.white);
                    }
                //     getContentPane().remove(altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]]);
                     int eklenecek=altinmiktari[altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]];
                     Coyuncusu.setAltin(Coyuncusu.getAltin()+eklenecek*5);
                     Coyuncusu.setToplananAltinMiktari(Coyuncusu.getToplananAltinMiktari()+eklenecek*5);
                    altinmatris[Coyuncusu.getKonumSatir()][Coyuncusu.getKonumSütün()]=-1;
                    CHedefSec();
                    CRotaCiz();        
                    
                    break;
                }
                
                
                
            }
            if(a==0){
            Coyuncusu.setKalinanRota(k);
            }
            Coyuncusu.setAltin(Coyuncusu.getAltin()-Coyuncusu.getHamleMaliyeti());
            Coyuncusu.setHarcananAltinMiktari(Coyuncusu.getHarcananAltinMiktari()+Coyuncusu.getHamleMaliyeti());
        }
        public void DHedefSec(){
       float secilenaltinuzaklik=(float) 9999.0;
       float adımsayısı=(float)OyunTahtası.getAdimsayisi();
       int secilenaltin=999;
       int altinx=0;
       int altiny=0;      
       int enkarlix=0;
       int enkarliy=0;
       int kar=-9999;
            for (int n = 0; n < OyunTahtası.getSatirsayisi(); n++) {
                for (int m = 0; m < OyunTahtası.getSütünsayisi(); m++) {
                    if(altinmatris[n][m]>-1){
                        //if(enyakin>Math.abs(Boyuncusu.getKonumSatir()-n)+Math.abs(Boyuncusu.getKonumSütün()-m)){
                            secilenaltin=altinmatris[n][m];                         
                            secilenaltinuzaklik=Math.abs(Doyuncusu.getKonumSatir()-n)+Math.abs(Doyuncusu.getKonumSütün()-m);
                        //    if(((altinmiktari[secilenaltin]*5)-(Math.ceil(secilenaltinuzaklik/3.0))*5)>kar){
                                if(Aoyuncusu.getHedefAltinSatir()==n&&Aoyuncusu.getHedefAltinSütün()==m){
                                    if(Math.ceil(secilenaltinuzaklik/adımsayısı)>=Math.ceil((Math.abs(Aoyuncusu.getKonumSatir()-n)+Math.abs(Aoyuncusu.getKonumSütün()-m))/adımsayısı)){
                                        continue;
                                    }}
                                    if(Boyuncusu.getHedefAltinSatir()==n&&Boyuncusu.getHedefAltinSütün()==m){
                                    if(Math.ceil(secilenaltinuzaklik/adımsayısı)>=Math.ceil((Math.abs(Boyuncusu.getKonumSatir()-n)+Math.abs(Boyuncusu.getKonumSütün()-m))/adımsayısı)){
                                        continue;
                                    }}
                                    if(Coyuncusu.getHedefAltinSatir()==n&&Coyuncusu.getHedefAltinSütün()==m){
                                    if(Math.ceil(secilenaltinuzaklik/adımsayısı)>=Math.ceil((Math.abs(Coyuncusu.getKonumSatir()-n)+Math.abs(Coyuncusu.getKonumSütün()-m))/adımsayısı)){
                                        continue;
                                    }
                                }
                            if(((altinmiktari[secilenaltin]*5)-(Math.ceil(secilenaltinuzaklik/adımsayısı))*5)>kar){
                            altinx=n;
                            altiny=m;
                            kar=((altinmiktari[secilenaltin]*5)-(int)(Math.ceil(secilenaltinuzaklik/adımsayısı))*5);
                                    
                            
                      //      }
                            
                        }
                    }
                    
                }
                
            }
            
                
                Doyuncusu.setHedefAltinSatir(altinx);
            Doyuncusu.setHedefAltinSütün(altiny);
            if(altinmatris[altinx][altiny]>-1){
            buton[altinx][altiny].setBackground(Color.CYAN);
           altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut, Boyut);
            altin[altinmatris[altinx][altiny]].setBounds(buton[altinx][altiny].getX()+3,buton[altinx][altiny].getY()+3 , Boyut-6, Boyut-6);
            Doyuncusu.setAltin(Doyuncusu.getAltin()-Doyuncusu.getHedefMaliyeti());
            Doyuncusu.setHarcananAltinMiktari(Doyuncusu.getHarcananAltinMiktari()+Doyuncusu.getHedefMaliyeti());
                }
            
            
            
        }
        public void DRotaCiz(){
            if(Doyuncusu.getKonumSatir()-Doyuncusu.getHedefAltinSatir()>0){
                for (int k= 0; k < Doyuncusu.getKonumSatir()-Doyuncusu.getHedefAltinSatir(); k++) {
                    DRota.add(4);
                    
                }
            }
            if(Doyuncusu.getKonumSatir()-Doyuncusu.getHedefAltinSatir()<0){
                for (int k= 0; k < Doyuncusu.getHedefAltinSatir()-Doyuncusu.getKonumSatir(); k++) {
                    DRota.add(2);
                    
                }
            }
            if(Doyuncusu.getKonumSütün()-Doyuncusu.getHedefAltinSütün()>0){
                for (int k= 0; k < Doyuncusu.getKonumSütün()-Doyuncusu.getHedefAltinSütün(); k++) {
                    DRota.add(1);
                    
                }
            }
            if(Doyuncusu.getKonumSütün()-Doyuncusu.getHedefAltinSütün()<0){
                for (int k= 0; k < Doyuncusu.getHedefAltinSütün()-Doyuncusu.getKonumSütün(); k++) {
                    DRota.add(3);
                    
                }
            }
        }
        public void DHareketEt(){
            //Dinamik boyutlandırma için image icon scale kullanımı
            coin1 = new ImageIcon(coin11.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin2 = new ImageIcon(coin22.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin3 = new ImageIcon(coin33.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
            coin4 = new ImageIcon(coin44.getImage().getScaledInstance(Boyut, -1, Image.SCALE_SMOOTH));
             int k;
            int a=0;
            for ( k=Doyuncusu.getKalinanRota() ; k <Doyuncusu.getKalinanRota()+OyunTahtası.getAdimsayisi(); k++) {
                String konum="["+Doyuncusu.getKonumSatir()+","+Doyuncusu.getKonumSütün()+"]";
                DosyaYaz(konum,Baglanti+"\\D.txt");
                Doyuncusu.setAdımSayısı(Doyuncusu.getAdımSayısı()+1);
                if(altinmatris[Doyuncusu.getHedefAltinSatir()][Doyuncusu.getHedefAltinSütün()]==-1){
                DRota.clear();
                Doyuncusu.setKalinanRota(0);
                if(Doyuncusu.getHedefAltinSatir()==0&&Doyuncusu.getHedefAltinSütün()==0){
                    break;
                }
                
                
                else{     
                 DHedefSec();
                DRotaCiz();
                k=0;
                }
                
                
                
            }    
                
                if(DRota.size()>Doyuncusu.getKalinanRota()){
                if(DRota.get(k)==1){
                    Doyuncusu.setKonumSütün(Doyuncusu.getKonumSütün()-1);
                    D.setLocation(buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getX()+1, buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getY()+1);
                    
                }
                if(DRota.get(k)==2){
                    Doyuncusu.setKonumSatir(Doyuncusu.getKonumSatir()+1);
                    D.setLocation(buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getX()+1, buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getY()+1);
                    
                    
                }
                if(DRota.get(k)==3){
                    Doyuncusu.setKonumSütün(Doyuncusu.getKonumSütün()+1);
                    D.setLocation(buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getX()+1, buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getY()+1);
                    
                   
                }
                if(DRota.get(k)==4){
                    Doyuncusu.setKonumSatir(Doyuncusu.getKonumSatir()-1);
                    D.setLocation(buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getX()+1, buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].getY()+1);
                    
                }
                }
                if(altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]<-1){
                    int gizlialtin=altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]*(-1);
                    if(altinmiktari[gizlialtin]==1){
                        
                        altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]=altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]].setIcon(coin1);
                    }
                    if(altinmiktari[gizlialtin]==2){
                        altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]=altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]].setIcon(coin2);
                        
                    }
                    if(altinmiktari[gizlialtin]==3){
                        altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]=altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]].setIcon(coin3);
                        
                    }
                    if(altinmiktari[gizlialtin]==4){
                        altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]=altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]*(-1);
                        altin[altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]].setIcon(coin4);
                        
                    }
                }
                
                
                
                if(altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]!=-1&&Doyuncusu.getHedefAltinSatir()==Doyuncusu.getKonumSatir()&&Doyuncusu.getHedefAltinSütün()==Doyuncusu.getKonumSütün()){
                    DRota.clear();
                    Doyuncusu.setKalinanRota(0);
                    //Aoyuncusu.setRota(ARota);
                    a++;
                    jPanel3.remove(altin[altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]]);
                    if((Doyuncusu.getKonumSatir()+Doyuncusu.getKonumSütün())%2==0){
                        buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].setBackground(Color.LIGHT_GRAY);
                    }
                    else{
                        buton[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()].setBackground(Color.white);
                    }
                //     getContentPane().remove(altin[altinmatris[Boyuncusu.getKonumSatir()][Boyuncusu.getKonumSütün()]]);
                     int eklenecek=altinmiktari[altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]];
                     Doyuncusu.setAltin(Doyuncusu.getAltin()+eklenecek*5);
                     Doyuncusu.setToplananAltinMiktari(Doyuncusu.getToplananAltinMiktari()+eklenecek*5);
                    altinmatris[Doyuncusu.getKonumSatir()][Doyuncusu.getKonumSütün()]=-1;
                    DHedefSec();
                    DRotaCiz();        
                    
                    break;
                }
                
                
                
            }
            if(a==0){
            Doyuncusu.setKalinanRota(k);
            }
            Doyuncusu.setAltin(Doyuncusu.getAltin()-Doyuncusu.getHamleMaliyeti());
            Doyuncusu.setHarcananAltinMiktari(Doyuncusu.getHarcananAltinMiktari()+Doyuncusu.getHamleMaliyeti());
        }       
        public void Ayarlar(){
            OyunTahtası.setSatirsayisi(Integer.parseInt(jTextField2.getText()));
            OyunTahtası.setSütünsayisi(Integer.parseInt(jTextField3.getText()));
            OyunTahtası.setAltinmiktari((OyunTahtası.getSatirsayisi()*OyunTahtası.getSütünsayisi()*Integer.parseInt(jTextField4.getText()))/100);
            OyunTahtası.setGizlialtinmiktari((OyunTahtası.getAltinmiktari()*Integer.parseInt(jTextField5.getText()))/100);
            OyunTahtası.setAdimsayisi(Integer.parseInt(jTextField6.getText()));
            OyunTahtası.setBaslangıcaltiniA(Integer.parseInt(jTextField7.getText()));
            OyunTahtası.setAadimmaliyeti(Integer.parseInt(jTextField1.getText()));
            OyunTahtası.setAhedefbelirlememaliyeti(Integer.parseInt(jTextField8.getText()));
            OyunTahtası.setBaslangıcaltiniB(Integer.parseInt(jTextField9.getText()));
            OyunTahtası.setBadimmaliyeti(Integer.parseInt(jTextField10.getText()));
            OyunTahtası.setBhedefbelirlememaliyeti(Integer.parseInt(jTextField11.getText()));
            OyunTahtası.setBaslangıcaltiniC(Integer.parseInt(jTextField12.getText()));
            OyunTahtası.setCadimmaliyeti(Integer.parseInt(jTextField13.getText()));
            OyunTahtası.setChedefbelirlememaliyeti(Integer.parseInt(jTextField14.getText()));
            OyunTahtası.setBaslangıcaltiniD(Integer.parseInt(jTextField15.getText()));
            OyunTahtası.setDadimmaliyeti(Integer.parseInt(jTextField16.getText()));
            OyunTahtası.setDhedefbelirlememaliyeti(Integer.parseInt(jTextField17.getText()));
}   
        public Panel() {
        
        initComponents();
        DosyaAc(Baglanti+"\\A.txt");
        DosyaAc(Baglanti+"\\B.txt");
        DosyaAc(Baglanti+"\\C.txt");
        DosyaAc(Baglanti+"\\D.txt");
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        
      
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anamenu.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        jButton3.setText("jButton3");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(770, 793, 430, 100);

        jButton4.setText("jButton4");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(800, 913, 370, 90);

        jPanel2.setLayout(null);

        jButton1.setOpaque(false);
        jPanel2.add(jButton1);
        jButton1.setBounds(0, 0, 0, 0);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField2.setText("20");
        jTextField2.setToolTipText("");
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(80, 270, 160, 70);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField3.setText("20");
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(320, 270, 140, 70);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField4.setText("20");
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(630, 270, 250, 70);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField5.setText("10");
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(1090, 280, 240, 50);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField6.setText("3");
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(1570, 280, 240, 50);

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField7.setText("200");
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(238, 470, 380, 60);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField1.setText("5");
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(810, 470, 380, 60);

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField8.setText("5");
        jTextField8.setBorder(null);
        jTextField8.setOpaque(false);
        jPanel2.add(jTextField8);
        jTextField8.setBounds(1377, 470, 380, 60);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField9.setText("200");
        jTextField9.setBorder(null);
        jTextField9.setOpaque(false);
        jPanel2.add(jTextField9);
        jTextField9.setBounds(238, 590, 380, 60);

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField10.setText("5");
        jTextField10.setBorder(null);
        jTextField10.setOpaque(false);
        jPanel2.add(jTextField10);
        jTextField10.setBounds(812, 590, 380, 60);

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField11.setText("10");
        jTextField11.setBorder(null);
        jTextField11.setOpaque(false);
        jPanel2.add(jTextField11);
        jTextField11.setBounds(1377, 588, 380, 60);

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField12.setText("200");
        jTextField12.setBorder(null);
        jTextField12.setOpaque(false);
        jPanel2.add(jTextField12);
        jTextField12.setBounds(238, 712, 380, 60);

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField13.setText("5");
        jTextField13.setBorder(null);
        jTextField13.setOpaque(false);
        jPanel2.add(jTextField13);
        jTextField13.setBounds(812, 710, 380, 60);

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField14.setText("15");
        jTextField14.setBorder(null);
        jTextField14.setOpaque(false);
        jPanel2.add(jTextField14);
        jTextField14.setBounds(1377, 708, 380, 60);

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField15.setText("200");
        jTextField15.setBorder(null);
        jTextField15.setOpaque(false);
        jPanel2.add(jTextField15);
        jTextField15.setBounds(238, 835, 380, 60);

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField16.setText("5");
        jTextField16.setBorder(null);
        jTextField16.setOpaque(false);
        jPanel2.add(jTextField16);
        jTextField16.setBounds(812, 830, 380, 60);

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField17.setText("20");
        jTextField17.setBorder(null);
        jTextField17.setOpaque(false);
        jPanel2.add(jTextField17);
        jTextField17.setBounds(1380, 830, 380, 60);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ayarlar.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(0, 0, 1958, 1080);

        jButton5.setText("uygula");
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(1023, 930, 480, 130);

        jButton6.setText("geridön");
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(480, 930, 490, 130);

        jPanel3.setLayout(null);

        jButton2.setText("Tur Tur Oynat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(1130, 70, 200, 23);

        jButton7.setText("Otomatik Oynat");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(1360, 70, 200, 23);

        jButton8.setText("Başla!");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(1300, 20, 90, 23);

        jLabel6.setText("C Kasadaki Altın=");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(1070, 250, 100, 30);

        jLabel7.setText(String.valueOf(Coyuncusu.getAltin()));
        jPanel3.add(jLabel7);
        jLabel7.setBounds(1170, 250, 80, 30);

        jLabel5.setText("B Kasadaki Altın=");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(1070, 200, 100, 30);
        jLabel5.getAccessibleContext().setAccessibleName("B Kasadaki Altın");

        jLabel4.setText("A Kasadaki Altın=");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(1070, 150, 100, 30);

        jLabel2.setText(String.valueOf(Boyuncusu.getAltin()));
        jPanel3.add(jLabel2);
        jLabel2.setBounds(1170, 200, 80, 30);

        jLabel3.setText(String.valueOf(Aoyuncusu.getAltin()));
        jPanel3.add(jLabel3);
        jLabel3.setBounds(1170, 150, 80, 30);

        jLabel10.setText("D Kasadaki Altın=");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(1070, 300, 100, 30);

        jLabel11.setText(String.valueOf(Doyuncusu.getAltin()));
        jPanel3.add(jLabel11);
        jLabel11.setBounds(1170, 300, 80, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/onerilenaltinlarsizmasaarkaplan.jpg"))); // NOI18N
        jPanel3.add(jLabel8);
        jLabel8.setBounds(0, 0, 1920, 1080);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton7.setVisible(false);        
        java.util.Timer myTimer=new java.util.Timer();//Sıralı oynamayı gözlemlemek için timer kullanımı
             TimerTask gorev =new TimerTask() {
                 
                 int saniye=0;                             
                 public void run(){  
                     
                     int oyunsonu=0;
                    if(saniye==4){
                        myTimer.cancel();
                    }
                     saniye++;
        for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {
           //     System.out.print("|"+altinmatris[k][l]);
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }                
            }
         //   System.out.println();
        }              
        if(oyunsonu!=0&&Aoyuncusu.getAltin()>0&&saniye==1){
             AHareketEt();                      
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {                
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }                
            }            
        }
         if(oyunsonu!=0&&Boyuncusu.getAltin()>0&&saniye==2){         
             BHareketEt();   
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {               
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }              
            }         
        }
         if(oyunsonu!=0&&Coyuncusu.getAltin()>0&&saniye==3){   
            CGizliAltinAc(); 
            CHareketEt();           
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {               
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }               
            }            
        }
         if(oyunsonu!=0&&Doyuncusu.getAltin()>0&&saniye==4){            
             DHareketEt();             
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {               
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }               
            }           
        }      
             jLabel2.setText(String.valueOf(Boyuncusu.getAltin()));
             jLabel3.setText(String.valueOf(Aoyuncusu.getAltin()));
             jLabel7.setText(String.valueOf(Coyuncusu.getAltin()));
             jLabel11.setText(String.valueOf(Doyuncusu.getAltin()));       
         if(oyunsonu==0||(Aoyuncusu.getAltin()<=0&&Boyuncusu.getAltin()<=0&&Coyuncusu.getAltin()<=0&&Doyuncusu.getAltin()<=0)){   
            JOptionPane.showMessageDialog(jPanel3, "Oyun Bitti. \n"+"A---Kasadaki Altin Miktari:"+Aoyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Aoyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Aoyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Aoyuncusu.getAdımSayısı()+"\n"+
                                                                    "B---Kasadaki Altin Miktari:"+Boyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Boyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Boyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Boyuncusu.getAdımSayısı()+"\n"+
                                                                    "C---Kasadaki Altin Miktari:"+Coyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Coyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Coyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Coyuncusu.getAdımSayısı()+"\n"+
                                                                    "D---Kasadaki Altin Miktari:"+Doyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Doyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Doyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Doyuncusu.getAdımSayısı());
            jButton2.setVisible(false);
                    myTimer.cancel();
         }  
                 }                 
    };
        myTimer.schedule(gorev,0,200);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
             jPanel1.setVisible(false);
             jPanel3.setVisible(true);
             //Oyun ekranının görüntüsünün oluşturulması
             myinitComponents();
             jButton2.setVisible(false);
             jButton7.setVisible(false);
             jLabel2.setText(String.valueOf(Boyuncusu.getAltin()));
             jLabel3.setText(String.valueOf(Aoyuncusu.getAltin()));
             jLabel7.setText(String.valueOf(Coyuncusu.getAltin()));
             jLabel11.setText(String.valueOf(Doyuncusu.getAltin()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     int kontrol=0; 
  //Girilen değerin sayı olup olmadığının kontrolü     
try {
    Integer.parseInt(jTextField1.getText());
    Integer.parseInt(jTextField2.getText());
    Integer.parseInt(jTextField3.getText());
    Integer.parseInt(jTextField4.getText());
    Integer.parseInt(jTextField5.getText());
    Integer.parseInt(jTextField6.getText());
    Integer.parseInt(jTextField7.getText());
    Integer.parseInt(jTextField8.getText());
    Integer.parseInt(jTextField9.getText());
    Integer.parseInt(jTextField10.getText());
    Integer.parseInt(jTextField11.getText());
    Integer.parseInt(jTextField12.getText());
    Integer.parseInt(jTextField13.getText());
    Integer.parseInt(jTextField14.getText());
    Integer.parseInt(jTextField15.getText());
    Integer.parseInt(jTextField16.getText());
    Integer.parseInt(jTextField17.getText());
} catch (NumberFormatException e) {
    kontrol++;
    JOptionPane.showMessageDialog(jPanel2,"Ayarlar Uygulanmadı! Lütfen sadece sayı giriniz.!" );
}
if(Integer.parseInt(jTextField5.getText())>99){
    kontrol++;
    JOptionPane.showMessageDialog(jPanel2,"Ayarlar Uygulanmadı! Gizli Altın miktari %100 olamaz!" );
}
if(Integer.parseInt(jTextField4.getText())>100&&kontrol==0){
    kontrol++;
    JOptionPane.showMessageDialog(jPanel2,"Ayarlar Uygulanmadı! Altın miktari maksimum %100 olabilir!" );
}






if(kontrol==0){
            OyunTahtası.setSatirsayisi(Integer.parseInt(jTextField2.getText()));
            OyunTahtası.setSütünsayisi(Integer.parseInt(jTextField3.getText()));
            OyunTahtası.setAltinmiktari((OyunTahtası.getSatirsayisi()*OyunTahtası.getSütünsayisi()*Integer.parseInt(jTextField4.getText()))/100);
            OyunTahtası.setGizlialtinmiktari((OyunTahtası.getAltinmiktari()*Integer.parseInt(jTextField5.getText()))/100);
            OyunTahtası.setAdimsayisi(Integer.parseInt(jTextField6.getText()));
            Aoyuncusu.setAltin(Integer.parseInt(jTextField7.getText()));
            Aoyuncusu.setHamleMaliyeti(Integer.parseInt(jTextField1.getText()));
            Aoyuncusu.setHedefMaliyeti(Integer.parseInt(jTextField8.getText()));
            Boyuncusu.setAltin(Integer.parseInt(jTextField9.getText()));
            Boyuncusu.setHamleMaliyeti(Integer.parseInt(jTextField10.getText()));
            Boyuncusu.setHedefMaliyeti(Integer.parseInt(jTextField11.getText()));
            Coyuncusu.setAltin(Integer.parseInt(jTextField12.getText()));
            Coyuncusu.setHamleMaliyeti(Integer.parseInt(jTextField13.getText()));
            Coyuncusu.setHedefMaliyeti(Integer.parseInt(jTextField14.getText()));
            Doyuncusu.setAltin(Integer.parseInt(jTextField15.getText()));
            Doyuncusu.setHamleMaliyeti(Integer.parseInt(jTextField16.getText()));
            Doyuncusu.setHedefMaliyeti(Integer.parseInt(jTextField17.getText()));
            JOptionPane.showMessageDialog(jPanel2,"Ayarlar Uygulandı!" );
            jPanel2.setVisible(false);
            jPanel1.setVisible(true);
}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton2.setVisible(false);
        jButton7.setVisible(false);
        java.util.Timer myTimer=new java.util.Timer();//Sıralı oynamayı gözlemlemek için timer kullanımı
             TimerTask gorev =new TimerTask() {                 
                 int saniye=0;                               
                 public void run(){                      
                    int oyunsonu=0;
                    if(saniye==4){
                        saniye=0;
                    }
                     saniye++;
        for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {
         //       System.out.print("|"+altinmatris[k][l]);
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }               
            }
        //    System.out.println();
        }                      
        if(oyunsonu!=0&&Aoyuncusu.getAltin()>0&&saniye==1){
             AHareketEt();                        
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {                
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }               
            }            
        }
         if(oyunsonu!=0&&Boyuncusu.getAltin()>0&&saniye==2){         
             BHareketEt();             
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {                
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }                
            }           
        }
         if(oyunsonu!=0&&Coyuncusu.getAltin()>0&&saniye==3){   
            CGizliAltinAc(); 
            CHareketEt();                       
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {                
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }                
            }           
        }
         if(oyunsonu!=0&&Doyuncusu.getAltin()>0&&saniye==4){                  
            DHareketEt();             
         }
         oyunsonu=0;
         for (int k = 0; k < OyunTahtası.getSatirsayisi(); k++) {
            for (int l = 0; l < OyunTahtası.getSütünsayisi();l++) {               
                if(altinmatris[k][l]>-1){
                    oyunsonu++;
                }                
            }            
        }         
             jLabel2.setText(String.valueOf(Boyuncusu.getAltin()));
             jLabel3.setText(String.valueOf(Aoyuncusu.getAltin()));
             jLabel7.setText(String.valueOf(Coyuncusu.getAltin()));
             jLabel11.setText(String.valueOf(Doyuncusu.getAltin()));                  
         if(oyunsonu==0||(Aoyuncusu.getAltin()<=0&&Boyuncusu.getAltin()<=0&&Coyuncusu.getAltin()<=0&&Doyuncusu.getAltin()<=0)){
            JOptionPane.showMessageDialog(jPanel3, "Oyun Bitti. \n"+"A---Kasadaki Altin Miktari:"+Aoyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Aoyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Aoyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Aoyuncusu.getAdımSayısı()+"\n"+
                                                                    "B---Kasadaki Altin Miktari:"+Boyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Boyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Boyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Boyuncusu.getAdımSayısı()+"\n"+
                                                                    "C---Kasadaki Altin Miktari:"+Coyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Coyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Coyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Coyuncusu.getAdımSayısı()+"\n"+
                                                                    "D---Kasadaki Altin Miktari:"+Doyuncusu.getAltin()+"  Toplanan Altin Miktari:"+Doyuncusu.getToplananAltinMiktari()+"  Harcanan Altin Miktari:"+Doyuncusu.getHarcananAltinMiktari()+"  Adım Sayısı:"+Doyuncusu.getAdımSayısı());          
                    myTimer.cancel();      
         }  
                 }                
    };
        myTimer.schedule(gorev,0,200);     
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setVisible(false);
        jButton2.setVisible(true);
        jButton7.setVisible(true);
        AHedefSec();
        ARotaCiz();
        BHedefSec();
        BRotaCiz();
        CHedefSec();
        CRotaCiz();
        DHedefSec();
        DRotaCiz();        
    }//GEN-LAST:event_jButton8ActionPerformed
   
    public static void main(String args[]) {
        
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
                
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JButton A;
    public javax.swing.JButton B;
    public javax.swing.JButton C;
    public javax.swing.JButton D;   
}
