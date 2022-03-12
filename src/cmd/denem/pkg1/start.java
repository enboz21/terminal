package cmd.denem.pkg1;

import java.util.Scanner;

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
        }
    }

}
