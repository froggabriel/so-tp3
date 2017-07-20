package cr.ac.ucr.ecci.ci1310.cache.build;

import java.util.Scanner;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public class MenuController {

    public static void main(String[] args) {
        new MenuController().Menu();
    }
    public void Menu() {
        System.out.println("Especifique si desea usar el cache.\n 1 - el cache sera utilizado\n 2 - el cache no sera utilizado");
        Scanner scanner = new Scanner(System.in);
        int useCache = scanner.nextInt();
        switch (useCache) {
            case 1: //usa cache
                System.out.println("-- El cache sera utilizado -- ");
                System.out.println("Puede realizar consultas a la base de datos de acuerdo a id y/o titulo");
                System.out.println("Especifique el tipo de consulta que desea realizar.\n 1 - Buscar por id \n 2 - Buscar por titulo");
                int tipoConsulta = scanner.nextInt();
                switch (tipoConsulta) {
                    case 1: //id
                        //Cache cache = new
                        System.out.println("Ingrese el id a consultar");
                        String findId = scanner.next();


                }


            case 2: //no usa cache
                System.out.println("El cache no sera utilizado");


        }

    }
}
