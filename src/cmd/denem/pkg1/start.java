package cmd.denem.pkg1;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class start {

    public static void main(String[] args) {
        System.out.println("sistem başlatılıyor.......");
        kodlar kod=new kodlar("C:/");
        Scanner K=new Scanner(System.in);
        String met;
        while (true) {
            kod.getkonum();
            met=K.nextLine();
            String []böl=met.split(" ", 2);
            if (böl[0].equals("cd")) { 
                if (böl[1].equals("..")) {
                    kod.setKonum(böl[1]);
                }
                else kod.dosyakontrol(böl[1]);
            }
            else if (böl[0].equals("dir")) {
                kod.içindekiler();
            }
            else if (böl[0].equals("exit")) {
                System.exit(0);
            }
            else if (böl[0].equals("rm")) {
                kod.klasörsil(böl[1]);
            }
            else if (böl[0].equals("mkdir")) {
                kod.klasöroluşturma(böl[1]);
            }
            else if (böl[0].equals("mk")) {
                kod.dosyaoluşturma(böl[1]);
            }
            else if (böl[0].equals("help")) {
                System.out.println("dir: dizindeki dosyaları gösterir ");
                System.out.println("cd <hedef>: sizi yazılı olan yere götürü");
                System.out.println("exit: sistemi kapatır");
                System.out.println("rm <hedef>: dosya veya klasör kaldırır");
                System.out.println("mk <hedef>: dosya oluşturu");
                System.out.println("mkdir <hedef>: klasör oluşturu");
                System.out.println("cop <copyalanıcak öğe> <oluşacak dosyanın konumu ve adı>: dosyaları bir yere kopyalar");
            }
            else if (böl[0].equals("cop")) {
                try {
                    kod.dosyakopyalama(böl[1]);
                } catch (IOException ex) {
                    Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }

}
