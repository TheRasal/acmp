import java.io.*;

public class Main {

    private int InputNumber;
    public static void main(String[] args) {
        Main number=new Main();
        System.out.println(number.count());
    }
    public Long count(){
        ReadFromFile();
        boolean num = true;
        Long result = Long.valueOf(0);

        String st = String.valueOf(InputNumber);
        if (st == null || st.isEmpty()) {
            num = false;
        }
        for (int i = 0; i < st.length(); i++) {
            if (!Character.isDigit(st.charAt(i))) {
                num = false;
            }
        }
        if (num) {
            long N =Long.parseLong(st);
            if (N >= 1 && N<= 10000) {
                int temp = 0;

                for (long i = 1;i>0; i++) {
                    char[] str = String.valueOf(i).toCharArray();
                    if (str.length == 1) {
                        temp++;
                    } else {
                        boolean r = true;

                        if (r) {
                            for (int l = 0; l < str.length - 1; l++) {
                                if (r) {


                                    for (int j = str.length - 1; j > l; j--) {
                                        if (str[l] == str[j]) {
                                            r = false;

                                        }
                                    }
                                }
                            }
                        }
                        if (r) {

                            temp++;
                        }
                    }
                    if (temp == N) {
                        String res = String.valueOf(i);
                        try {
                            File file = new File("OUTPUT.TXT");

                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            PrintWriter pw = new PrintWriter(file.getAbsoluteFile());
                            pw.print(res);
                            pw.close();
                        } catch (IOException e) {
                            System.out.println(e);
                        }

                        result=i;
                        return result;
                    }
                }

            }

        } else {
            return null;

        }

        return null;
    }
    public void ReadFromFile() {

        try (FileInputStream fis = new FileInputStream("INPUT.TXT");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis))) {

            InputNumber = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}