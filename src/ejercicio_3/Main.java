package ejercicio_3;

/**
 * El grinch quiere robar los regalos de Navidad del almacén. Para ello necesita
 * saber qué regalos no tienen vigilancia.
 * 
 * El almacén se representa como un array de strings (string[]), donde cada
 * regalo (*) está protegido si su posición está junto a una cámara (#). Cada
 * espacio vacío se representa con un punto (.).
 * 
 * Tu tarea es contar cuántos regalos están sin vigilancia, es decir, que no
 * tienen ninguna cámara adyacente (arriba, abajo, izquierda o derecha).
 * 
 * Ten en cuenta: solo se considera como "adyacente" las 4 direcciones
 * cardinales, no en diagonal.
 * 
 * Los regalos en las esquinas o bordes pueden estar sin vigilancia, siempre que
 * no tengan cámaras directamente al lado.
 */

public class Main {

    public static int findUnsafeGifts(String[] warehouse) {

        int counter = 0;
        int rows = warehouse.length;
        int cols = warehouse[0].length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (warehouse[i].charAt(j) != '*')
                    continue;

                Character up = (i - 1 >= 0) ? warehouse[i - 1].charAt(j) : null;
                Character down = (i + 1 < rows) ? warehouse[i + 1].charAt(j) : null;
                Character left = (j - 1 >= 0) ? warehouse[i].charAt(j - 1) : null;
                Character right = (j + 1 < cols) ? warehouse[i].charAt(j + 1) : null;

                if (up != null && up == '#')
                    continue;
                if (down != null && down == '#')
                    continue;
                if (left != null && left == '#')
                    continue;
                if (right != null && right == '#')
                    continue;

                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] args) {
        String[] warehouse1 = {
                ".*.",
                "*#*",
                ".*."
        };

        System.out.println(findUnsafeGifts(warehouse1)); // ➞ 0

        String[] warehouse2 = {
                "...",
                ".*.",
                "..."
        };

        System.out.println(findUnsafeGifts(warehouse2)); // ➞ 1

        String[] warehouse3 = {
                ".....",
                ".*.*.",
                "..#..",
                ".*.*.",
                "....."
        };

        System.out.println(findUnsafeGifts(warehouse3)); // ➞ 4
    }

}
