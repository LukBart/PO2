import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

// Zagadnienia do przygotowania: operacje wejścia/wyjścia (w tym: obsługa plików)
// W przykładowych plikach sin.dat oraz cos.dat zapisano dane w dwóch kolumnach: współrzędne oraz wartości funkcji. 

//     (1 pkt.) Napisz program, który przy pomocy BufferedReader oraz InputStreamReader z pakietu java.io pobierze od użytkownika nazwy dwóch plików tekstowych z danymi.
//     (4 pkt.) Dane należy wczytać do programu, otwierając oba pliki za pośrednictwem Files.newBufferedReader(...) z pakietu java.nio (wczytywanie ma działać uniwersalnie, tzn. niezależnie od liczby wierszy danych). Program powinien kończyć działanie w przypadku niepowodzenia otwarcia pliku.
//     (1 pkt.) Wartości obu funkcji należy dodać, sprawdzając, czy odpowiednie współrzędne xi się zgadzają w obu seriach danych.
//     (4 pkt.) Następnie program powinien pobrać od użytkownika nazwę pliku wyjściowego, w którym należy zapisać dane w formie dwóch kolumn: współrzędne xi oraz suma wejściowych wartości funkcji.
//     Program powinien sprawdzić, czy plik o takiej nazwie już istnieje -- jeśli tak, należy zapytać użytkownika, czy ma zostać nadpisany. Jeśli użytkownik odpowie "no" -- program powinien poprosić o nową nazwę pliku.
//     Zapisywanie do pliku powinno być zrealizowane przy użyciu Files.newBufferedWriter(...) z pakietu java.nio.

// Program najlepiej przetestować również na innych danych, np. test1.dat oraz test2.dat.

public class Main {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader( System.in ) );
        String filename1 = "";
        String filename2 = "";
        try{
            System.out.println ("Podaj nazwe pliku 1: ");
            filename1 = stdin.readLine();
            System.out.println("Podaj nazwe pliku 2:");
            filename2 = stdin.readLine();
        } catch(IOException e) {}

        Path path1 = Paths.get(filename1);
        Path path2 = Paths.get(filename2);

        Map<Double, Double> values1 = new HashMap<>();
        Map<Double, Double> values2 = new HashMap<>();
        List<Double> valuesOfX = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path1, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] val = line.split(" ");
                valuesOfX.add(Double.parseDouble(val[0]));
                values1.put(Double.parseDouble(val[0]), Double.parseDouble(val[1]));
            }
        } catch (IOException x) {
            System.err.println("IOException " + x);
        }
        try (BufferedReader reader = Files.newBufferedReader(path2, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] val = line.split(" ");
                values2.put(Double.parseDouble(val[0]), Double.parseDouble(val[1]));
            }
        } catch (IOException x) {
            System.err.println("IOException " + x);
        }

        List<Double> xi = new ArrayList<>();
        List<Double> yi = new ArrayList<>();


        for (Double x : valuesOfX) {
            if (values1.get(x) != null && values1.get(x).equals(values2.get(x))){
                xi.add(x);
                yi.add(values1.get(x)+values2.get(x));
            }
        }
        String newFileName = null;
        try{
            System.out.println("Podaj nazwe nowego pliku: ");
            newFileName = stdin.readLine();
            while (newFileName == null || Files.exists(Paths.get(newFileName))){
                System.out.println("czy chcesz nadpisac plik?");
                if (stdin.readLine().equals("no")){
                    System.out.println("Podaj nazwe nowego pliku: ");
                    newFileName = stdin.readLine();
                }else{
                    break;
                }
            }
        } catch(IOException e) {}


        try{
            BufferedWriter newFile = Files.newBufferedWriter(Paths.get(newFileName));
            for (int i = 0; i < xi.size();i++){
                newFile.write(xi.get(i) + " " + yi.get(i) + "\n");
            }
            newFile.close();
        }catch (IOException e) {}
    }
}
