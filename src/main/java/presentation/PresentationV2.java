package presentation;

import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        //Injection des dépendances utilisant instanciation dynamique
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            //IDao dao=new DaoImpl();
            String daoClassname = scanner.nextLine();
            Class cDao = Class.forName(daoClassname);
            IDao dao = (IDao) cDao.getConstructor().newInstance();

            //IMetier metier = new MetierImpl();
            String metierClassname = scanner.nextLine();
            Class cMetier = Class.forName(metierClassname);
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

            //metier.setiDao(dao);
            Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);

            System.out.println("Res=" + metier.calcul());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
