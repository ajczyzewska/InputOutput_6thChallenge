package inputoutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		  int numberOfLines = 0;
	   // Wczytanie ścieżki wejściowej od użytkownika:
	   	String inputPath = "/Users/agnieszkawolska/eclipse-workspace/InputOutput_6thChallenge/src/test.txt"; //alternatywna ścieżka do pliku
	   	String outputPath = "/Users/agnieszkawolska/eclipse-workspace/InputOutput_6thChallenge/src/test.txt"; //alternatywna ścieżka do pliku
	    System.out.println("Proszę podaj ścieżkę do pliku, który ma być użyty. Ścieżka od katalogu /eclipse-workspace/Test/src :)");
		Scanner scanner = new Scanner(System.in);
		inputPath = scanner.next();
		inputPath = "/Users/agnieszkawolska/eclipse-workspace/InputOutput_6thChallenge/src/" + inputPath; 
		System.out.println("Cała ścieżka: " + inputPath);
		
		// Wczytanie ścieżki wyjściowej od użytkownika
		System.out.println("Proszę podaj ścieżkę do pliku, w którym ma być zapisany wynik. Ścieżka od katalogu /eclipse-workspace/Test/src :)");
		outputPath = scanner.next();
		outputPath = "/Users/agnieszkawolska/eclipse-workspace/InputOutput_6thChallenge/src/" + outputPath; 
		System.out.println("Cała ścieżka: " + outputPath);
		
		// Wczytanie pliku ze ścieżki wejściowej: 
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath))) {
            String line = bufferedReader.readLine();
          
            System.out.println("Liczba linii przed wczytaniem: " +numberOfLines);
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
                numberOfLines= numberOfLines+1;
            }
            System.out.println("Liczba linii w pliku "+ numberOfLines);
        
        } catch (IOException io) {
            System.out.println("Problem z odczytem pliku");
            io.printStackTrace();
        }
		// Zapis do pliku: 
		try {
			PrintWriter Output = new PrintWriter(outputPath);
			Output.println("Nazwa pliku: " + inputPath);
			System.out.println("drukowanie do pliku....");
			Output.println("Liczba Linii w pliku: " + numberOfLines);
			Output.close();

			
		} catch (FileNotFoundException e) {
			System.out.println("Problem z odczytem pliku");
            e.printStackTrace();
		}
	}

}
