/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AltinToplamaOyunu;

import java.util.ArrayList;

/**
 *
 * @author Bayram
 */
public class Coyuncusu {
    int Altin=200;
    int HedefMaliyeti=15;
    int HamleMaliyeti=5;
    int KonumSatir=19;
    int KonumSütün=19;
    int HedefAltinSatir=-1;
    int HedefAltinSütün=-1;
    int KalinanRota=0;
    int HarcananAltinMiktari=0;
    int ToplananAltinMiktari=0;
    int AdımSayısı=0;

    public int getHarcananAltinMiktari() {
        return HarcananAltinMiktari;
    }

    public void setHarcananAltinMiktari(int HarcananAltinMiktari) {
        this.HarcananAltinMiktari = HarcananAltinMiktari;
    }

    public int getToplananAltinMiktari() {
        return ToplananAltinMiktari;
    }

    public void setToplananAltinMiktari(int ToplananAltinMiktari) {
        this.ToplananAltinMiktari = ToplananAltinMiktari;
    }

    public int getAdımSayısı() {
        return AdımSayısı;
    }

    public void setAdımSayısı(int AdımSayısı) {
        this.AdımSayısı = AdımSayısı;
    }
    public int getKalinanRota() {
        return KalinanRota;
    }

    public void setKalinanRota(int KalinanRota) {
        this.KalinanRota = KalinanRota;
    }
    public int getHedefAltinSatir() {
        return HedefAltinSatir;
    }

    public void setHedefAltinSatir(int HedefAltinSatir) {
        this.HedefAltinSatir = HedefAltinSatir;
    }

    public int getHedefAltinSütün() {
        return HedefAltinSütün;
    }

    public void setHedefAltinSütün(int HedefAltinSütün) {
        this.HedefAltinSütün = HedefAltinSütün;
    }

    public int getKonumSatir() {
        return KonumSatir;
    }

    public void setKonumSatir(int KonumSatir) {
        this.KonumSatir = KonumSatir;
    }

    public int getKonumSütün() {
        return KonumSütün;
    }

    public void setKonumSütün(int KonumSütün) {
        this.KonumSütün = KonumSütün;
    }
  
    
    public Coyuncusu(){
        
    }

    public int getAltin() {
        return Altin;
    }

    public void setAltin(int Altin) {
        this.Altin = Altin;
    }

    public int getHedefMaliyeti() {
        return HedefMaliyeti;
    }

    public void setHedefMaliyeti(int HedefMaliyeti) {
        this.HedefMaliyeti = HedefMaliyeti;
    }

    public int getHamleMaliyeti() {
        return HamleMaliyeti;
    }

    public void setHamleMaliyeti(int HamleMaliyeti) {
        this.HamleMaliyeti = HamleMaliyeti;
    }

}
