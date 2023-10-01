public class Aqis {
    public static void main(String[] args) {
        // *
        //
        // *
        // *
        // *
        // *
        // * *
        // * *

        int tinggi = 7; // Tinggi huruf J

        // for (int baris = 1; baris <= tinggi; baris++) {
        // for (int kolom = 1; kolom <= tinggi; kolom++) {
        // if (tinggi > baris) {
        // if (kolom == tinggi) {
        // System.out.print('*');
        // } else {
        // System.out.print(" ");
        // }
        // } else {
        // if (kolom % 2 == 1) {
        // System.out.print('*');
        // } else {
        // System.out.print(" ");
        // }
        // }
        // }
        // System.out.println(); // Pindah ke baris berikutnya setelah satu baris
        // selesai
        // }
        System.out.println(7 / 2);
        for (int baris = 1; baris <= tinggi; baris++) {
            for (int kolom = 1; kolom <= tinggi; kolom++) {
                if (baris == 1) {
                    System.out.print('*');
                } else {
                    if (tinggi % 2 == 0) {
                        if (kolom == (tinggi / 2) || kolom == ((tinggi / 2) + 1)) {
                            System.out.print('*');
                        } else {
                            System.out.print(' ');
                        }
                    } else {
                        if (kolom == ((tinggi / 2) + 1)) {
                            System.out.print('*');
                        } else {
                            System.out.print(' ');
                        }
                    }
                }
            }
            System.out.println(); // Pindah ke baris berikutnya setelah satu baris selesai
        }

    }
}
