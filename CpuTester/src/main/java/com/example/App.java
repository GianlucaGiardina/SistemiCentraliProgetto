package com.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        int processPid = 2517; // Inserisci il PID del processo da monitorare
        String command = String.format("top -p %d -b -n1", processPid);
        String outputFilePath = "/home/gianluca/Scrivania/RestaurantReservation/output.txt";

        while (true) {
            try {
                Process process = Runtime.getRuntime().exec(command);

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = reader.readLine();

                while (line != null) {
                    if (line.contains(String.format(" %d ", processPid))) {
                        String[] fields = line.trim().split("\\s+");
                        double cpuUsage = Double.parseDouble(fields[8].replace(",", "."));
                        if(cpuUsage>1){
                    
                        String output = String.format("Utilizzo CPU del processo: %.1f%%\n", cpuUsage);

                        System.out.print(output);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
                            writer.write(output);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        break;
                    }
                    }

                    line = reader.readLine();
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Attendi per un secondo prima di verificare nuovamente l'utilizzo della CPU
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
