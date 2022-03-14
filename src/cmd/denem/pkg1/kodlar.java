package cmd.denem.pkg1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class kodlar {

    Scanner K = new Scanner(System.in);
    private String konum;

    public kodlar(String konum) {
        this.konum = konum;
    }

    public void getkonum() {
        System.out.print(konum + " >> ");
    }

    public void setKonum(String konum) {
        if (konum.equals("..")) {
            String kelime = null, kelimd = this.konum;
            String a = "";
            for (int i = kelimd.length() - 1; i >= 0; i--) {
                a += kelimd.charAt(i);
            }
            String met = a;
            String b = "";
            String f = "/";
            String[] böl = met.split(f, 2);
            String kelim = böl[1];
            for (int i = kelim.length() - 1; i >= 0; i--) {
                b += kelim.charAt(i);
            }
            this.konum = "";
            String s = "";
            if (b.charAt(b.length() - 1) == '/') {
                for (int i = 0; i < b.length() - 1; i++) {
                    s += b.charAt(i);
                }
                if (s.equals("c:")) {
                    this.konum = s + "/";

                } else {
                    this.konum = s;
                }
            } else {
                if (b.equals("c:") || b.equals("C:")) {
                    this.konum = b + "/";

                } else {
                    this.konum = b;
                }
            }
        } else {
            int b = this.konum.length();
            if (this.konum.charAt(b - 1) == '/') {
                String a = this.konum;
                konum = a + konum;
                this.konum = konum;
            } else {
                String a = this.konum;
                konum = a + "/" + konum;
                this.konum = konum;
            }
        }
    }

    public void içindekiler() {
        File klasor = new File(this.konum);
        String dosyalar[] = klasor.list();
        for (int i = 0; i < dosyalar.length; i++) {
            System.out.println(dosyalar[i]);
        }
    }

    public void dosyakontrol(String konum) {
        File klasor = new File(this.konum);
        String dosyalar[] = klasor.list();
        boolean a = false;
        for (int i = 0; i < dosyalar.length; i++) {
            dosyalar[i] = dosyalar[i].toLowerCase();
            if (dosyalar[i].equals(konum)) {
                setKonum(konum);
                a = true;
            }
        }
        if (a == false) {
            System.out.println("yanlış dosya ismi");
        }
    }

    public void klasörsil(String isim) {
        File klasor = new File(this.konum);
        String dosyalar[] = klasor.list();
        boolean a = false;
        for (int i = 0; i < dosyalar.length; i++) {
            dosyalar[i] = dosyalar[i].toLowerCase();
            if (dosyalar[i].equals(isim)) {
                a = true;
            }
        }
        if (a == false) {
            System.out.println("bu isimde dosya yok");
        } else {
            File f = new File(this.konum + "/" + isim);
            f.delete();
        }
    }

    public void klasöroluşturma(String dosya_ismi) {
        File f = new File(this.konum + "/" + dosya_ismi);
        if (f.exists()) {
            System.out.println("klasör zaten var");
        } else {
            f.mkdir();
        }
    }

    public void dosyaoluşturma(String dosya_ismi) {
        File f = new File(this.konum + "/" + dosya_ismi);
        if (f.exists()) {
            System.out.println("dosya zaten var");
        } else {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(kodlar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void dosyakopyalama(String hedef) throws FileNotFoundException, IOException {
        String[] böl = hedef.split(" ", 2);
            hedef = böl[0];
            String hedefkonum=böl[1];
        FileInputStream fis = new FileInputStream(this.konum + "/" + hedef);
        BufferedInputStream oku = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream(hedefkonum);
        BufferedOutputStream yazici = new BufferedOutputStream(fos);
        int veri=0;
        while ((veri =oku.read())!= -1) {            
            byte girdi =(byte)veri;
            System.out.println("byte : "+girdi);
            yazici.write(girdi);
        }
        yazici.flush();
        yazici.close();
        oku.close();
    }
}
