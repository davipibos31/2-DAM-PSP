import java.io.BufferedInputStream;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{

        try {
            int[] array = new int[-1];
            array[1] = -3;
            System.out.println("Todo correcto");
        }  catch ( Error e ){
            System.out.println("Excepcion: " + e.getMessage());
        } finally {
            System.out.println("En Acceso a Datos, controlamos nuestro errores");
        }


    }
}