

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    private static String FirstDnk;
    private static String SecondDnk;
    private static int i;

    public static void main(String[] args) {
        String inputPath = "INPUT.TXT";
        String outputPath = "OUTPUT.TXT";

        Main task = new Main();

        task.checkDnk(inputPath, outputPath);
    }


    public void checkDnk(String inputPath, String outputPath) {

        String result;

        readDataFromFile(inputPath);

        if (EvolutionDnk(FirstDnk, SecondDnk)) {
            result = "YES";
        } else {
            result = "NO";
        }

        writeDataInFile(outputPath, result);

    }

    public boolean EvolutionDnk(String SecondDnk, String FirstDnk) {

        boolean result = false;

        String[] dnkFirst = SecondDnk.split("");
        String[] dnkSecond = FirstDnk.split("");
        int yes=0;

//

        for (int j = 0; j < dnkSecond.length; j++) {


            if (dnkFirst[i].equals(dnkSecond[j])) {

                i++;
                yes++;
                if (yes==dnkFirst.length) {

                    return true;
                }


            }
        }



        return result;
    }

    public void readDataFromFile(String inputPath) {

        try (FileInputStream fis = new FileInputStream(inputPath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis))) {

            FirstDnk = bufferedReader.readLine();
            SecondDnk = bufferedReader.readLine();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void writeDataInFile(String outputPath, String text) {

        try (FileOutputStream fos = new FileOutputStream(outputPath);
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos))) {

            bufferedWriter.write(text + "\r");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}