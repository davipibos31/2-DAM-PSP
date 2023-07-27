import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;


public class Main {
    public static ArrayList<String> list;
    public static void main(String[] args) {
        //noinspection Convert2Diamond
        list = new ArrayList<String>();

        File file = new File("archivo.txt");
        //noinspection UnusedAssignment
        FileReader fileR = null;
        BufferedReader file2 = null;

        try {
            fileR = new FileReader(file);
            file2 = new BufferedReader(fileR);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo " + file.getName());
        }

        try {
            //noinspection UnusedAssignment
            String lines = "";
            int cont = 0;
            while(true) {
                assert file2 != null;
                if ((lines = file2.readLine()) == null) break;
                System.out.println(lines);
                list.add(lines);
                cont++;
                Search v = new Search(list, "java", 0, list.size());
                ForkJoinPool pool = new ForkJoinPool();
                pool.execute(v);
                try {
                    ArrayList<String> results = v.get();
                    for (String result : results) System.out.println(result);
                } catch (Exception e) {
                    System.out.println("Exception occurred: " + e.getMessage());
                }
                if (cont > 9)
                    break;
            }
            System.out.println("------------------------------");

            while( ( lines = file2.readLine()) != null ) {
                if (cont > 9) {
                    System.out.println(lines);
                    list.add(lines);
                    Search v = new Search(list, "java", 9, list.size());
                    ForkJoinPool pool = new ForkJoinPool();
                    pool.execute(v);
                    try {
                        ArrayList<String> results = v.get();
                        for (String result : results) System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    }
                }
                cont++;
                if(cont > 19)
                    break;
            }
            System.out.println("------------------------------");

            while( ( lines = file2.readLine()) != null ) {
                if (cont > 19){
                    System.out.println(lines);
                    list.add(lines);
                    Search v = new Search(list, "java", 19, list.size());
                    ForkJoinPool pool = new ForkJoinPool();
                    pool.execute(v);
                    try {
                        ArrayList<String> results = v.get();
                        for (String result : results) System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    }
                }
                cont++;
                if(cont > 29)
                    break;
            }
            System.out.println("------------------------------");

            while( ( lines = file2.readLine()) != null ) {
                if (cont > 29) {
                    System.out.println(lines);
                    list.add(lines);
                    Search v = new Search(list, "java", 29, list.size());
                    ForkJoinPool pool = new ForkJoinPool();
                    pool.execute(v);
                    try {
                        ArrayList<String> results = v.get();
                        for (String result : results) System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    }
                }
                cont++;
                if(cont > 39)
                    break;
            }
            System.out.println("------------------------------");

            while( ( lines = file2.readLine()) != null ) {
                if (cont > 39) {
                    System.out.println(lines);
                    list.add(lines);
                    Search v = new Search(list, "java", 39, list.size());
                    ForkJoinPool pool = new ForkJoinPool();
                    pool.execute(v);
                    try {
                        ArrayList<String> results = v.get();
                        for (String result : results) System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    }
                }
                cont++;
                if(cont > 49)
                    break;
            }
            System.out.println("------------------------------");

            while( ( lines = file2.readLine()) != null ) {
                if (cont > 49) {
                    System.out.println(lines);
                    list.add(lines);
                    Search v = new Search(list, "java", 49, list.size());
                    ForkJoinPool pool = new ForkJoinPool();
                    pool.execute(v);
                    try {
                        ArrayList<String> results = v.get();
                        for (String result : results) System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    }
                }
                cont++;
                if(cont > 59)
                    break;
            }

            System.out.println("------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileRoute = new FileWriter("newFile.txt");
            for (String s : list) {
                fileRoute.write(s.replace("java", "Java") + "\n");
            }
            fileRoute.close();
        } catch (IOException ex) {
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(ex);
        }
    }
}