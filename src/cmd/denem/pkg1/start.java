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
                kod.setKonum(böl[1]);
            }
            else if (böl[0].equals("dir")) {
                kod.içindekiler();
            }
        }
    }

}
