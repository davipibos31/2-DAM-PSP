import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        //String result1 = ServiceUtils.getResponse("http://127.0.0.1:8080/services/sum/9/8", null, "GET");
        //System.out.println(result1);

        Gson gson = new Gson();

        String request = gson.toJson(new LoginRequest("Javier","admin"));

        String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/login", request, "POST");
        System.out.println(result2);
        LoginResponse response = gson.fromJson(result2, LoginResponse.class);
        System.out.println(response);
        System.out.println(response.token);

        ServiceUtils.setToken(response.token); // Para que todas las llamadas usen el token
        //String result3 = ServiceUtils.getResponse("http://127.0.0.1:8080/students", null, "GET");
       // System.out.println(result3);


        //Student[] list = gson.fromJson(result3, Student[].class);
       // System.out.println(list);

       // for (int i = 0; i< list.length; i++){
       //     System.out.println(list[i].get_id() + " " + list[i].getName() + " " + list[i].getTelephone() + " " + list[i].getAge());
       // }

//        BufferedReader bufferedReader = null;
//        try {
//            URL url = new URL("http://127.0.0.1:8080/test");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setInstanceFollowRedirects(true);
//
//            System.out.println(conn.getResponseCode());
//            System.out.println(conn.getResponseMessage());
//            System.out.println(conn.getHeaderFields());
//
//            String charset = getCharset(conn.getHeaderField("Content-Type"));
//            bufferedReader = new BufferedReader(new InputStreamReader( conn.getInputStream()));
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            do {
//                conn = (HttpURLConnection) url.openConnection();
//                if (conn.getResponseCode() == 301) {
//                    url = new URL(conn.getHeaderField("Location"));
//                }
//            } while (conn.getResponseCode() == 301);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bufferedReader != null) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        String result = getSumFromService(3, 5);
//        System.out.println(result);
//        System.out.println(getSumFromService(3, 5));
    }

    public static String getCharset(String contentType) {
        for (String param : contentType.replace(" ", "").split(";")) {
            if (param.startsWith("charset=")) {
                return param.split("=", 2)[1];
            }
        }
        return null; // Probably binary content
    }

    private static String getSumFromService(int n1, int n2) {
        BufferedReader bufferedReader = null;
        String result;
        try {
            URL google = new URL("http://127.0.0.1:8080/services/sum/" + n1 + "/" + n2);
            URLConnection conn = google.openConnection();
            bufferedReader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            result = bufferedReader.readLine();
        } catch (IOException e) {
            return "Error";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    return "Error";
                }
            }
        }
        return result == null ? "Error" : result;
    }
}