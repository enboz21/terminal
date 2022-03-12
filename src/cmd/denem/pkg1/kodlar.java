package cmd.denem.pkg1;

import java.io.File;
import java.util.Scanner;

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
            System.out.println(a);
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
        } 
        else {
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
}
