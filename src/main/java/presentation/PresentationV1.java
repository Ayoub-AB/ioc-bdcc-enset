package presentation;

import dao.*;
import metier.*;

import java.io.File;
import java.util.Scanner;

public class PresentationV1 {
    public static void main(String[] args) {
        //Injection des dépendances utilisant instanciation statique avec new
        IDao dao=new DaoImpl();
        MetierImpl metier=new MetierImpl(dao);
        //metier.setiDao(dao);
        System.out.println("Res="+metier.calcul());
    }
}
