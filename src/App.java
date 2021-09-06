/*
* File: App.java
* Author: Bán Cintia
* Copyright: 2021, Bán Cintia
* Group: Szoft II N
* Date: 2021-09-06
* Github: https://github.com/bncinti/
* Licenc: GNU GPL
*/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        nameCard();
        /*Fejrész kiírása*/
        System.out.println("Jelszavak");
        /*Verzió kiírása*/
        System.out.println("Verzió: 0.0.1");
        
        /*Az a objektummal kérhetünk be a konzolról*/
        Scanner a = new Scanner(System.in);

        System.out.print("Felhasználónév: ");
        /* A b változó tárolja a jelszót*/
        String b = a.nextLine();
        System.out.print("Jelszó: ");
        String c = a.nextLine();
        System.out.print("Hely: ");
        String d = a.nextLine();
        a.close();
        int Success = 0;
        try {
            /* 
            A jelszó, a felhasználónév és a 
            használati helye a passList 
            objektumban van tárolva            
            */
            Store passList = new Store(b, c, d);
            FileWriter f = new FileWriter("pass.txt");
            PrintWriter pwr = new PrintWriter(f);
            pwr.print(passList.user);
            if(!passList.hollow()) { pwr.print(passList.retrieval()); }
            pwr.print(passList.place);
            pwr.close();
            Success = 1;
        } catch (IOException e) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }

        if(Success == 1) { System.out.println("Ok. A kiírás sikeres.");  }else {  System.out.println("Hiba! A kiírás sikertelen"); }

    }

    public static void nameCard() {
        System.out.println("Bán Cintia");
    }
}
