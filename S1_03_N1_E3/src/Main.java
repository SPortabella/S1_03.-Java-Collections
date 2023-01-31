import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String PATH = "C:\\Users\\Susana\\Documents\\GitHub\\ProjectsITACADEMY\\S1\\03\\";
    private static String READ_FILE = "countries.txt";
    private static String WRITE_FILE = "classificacio.txt";

    public static void main(String[] args) {

        HashMap<String, String> map = readFile();

        Integer points = 0;
        String user = askUsername();

        for (int i = 0; i < 10; i++) {

            String country = selectOneCountry(map);
            System.out.println("Pais: " + country);
            String capital = askCapital();

            if (checkCapital(map, country, capital))
                points++;
            else System.out.println("Capital incorrecta");
        }
        System.out.println("Has aconseguit " + points + " punts");
        writeResultInFile(user, points);

    }

    private static void writeResultInFile(String user, Integer points) {
        try {
            File file = new File(PATH + WRITE_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(user + ". Has aconseguit " + points + " punts");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean checkCapital(HashMap<String, String> map, String country, String capital) {
        Iterator<String> it = map.keySet().iterator();

        while (it.hasNext()) {
            String clave = it.next();
            String valor = map.get(clave);
            if (clave.equals(country)) {
                if (valor.equals(capital)) {
                    return true;
                } else return false;
            }
        }
        return false;
    }

    private static String askCapital() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix la capital:");
        return sc.nextLine();
    }

    private static String selectOneCountry(HashMap<String, String> map) {
        Object[] aux = map.keySet().toArray();
        Object key = aux[new Random().nextInt(aux.length)];
        return key.toString();
    }

    private static String askUsername() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix Usuari:");
        return sc.nextLine();
    }

    private static HashMap<String, String> readFile() {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        HashMap<String, String> map = new HashMap<String, String>();

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            file = new File(PATH + READ_FILE);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] cortarString = linea.split(" ");
                map.put(cortarString[0], cortarString[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return map;
    }
}