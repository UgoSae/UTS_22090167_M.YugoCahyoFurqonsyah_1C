import java.util.Random;
import java.util.Scanner;

public class KopiKenanganJiwa {
    int jummenu = 4;
    static int totalJumlahStokKopi = 1250;
    public static String[] kopilattedontbelate = new String[400];
    public static String[] kopigoncangjiwa = new String[300];
    public static String[] kopijalankenangan = new String[300];
    public static String[] kopipahittanparasa = new String[250];

    public static void Printpelanggan() {
        int jumlahkopi = 0;
        int jumlahPembeli = 0;
        int totalkopilattedontbelate = 0;
        for (int index = 0; index < kopilattedontbelate.length; index++) {
            if (kopilattedontbelate[index] != null) {
                totalkopilattedontbelate++;
            }
        }
        int totalkopigoncangjiwa = 0;
        for (int index = 0; index < kopigoncangjiwa.length; index++) {
            if (kopigoncangjiwa[index] != null) {
                totalkopigoncangjiwa++;
            }
        }
        int totalkopijalankenangan = 0;
        for (int index = 0; index < kopijalankenangan.length; index++) {
            if (kopijalankenangan[index] != null) {
                totalkopijalankenangan++;
            }
        }
        int totalkopipahittanparasa = 0;
        for (int index = 0; index < kopipahittanparasa.length; index++) {
            if (kopipahittanparasa[index] != null) {
                totalkopipahittanparasa++;
            }
        }

        jumlahkopi = totalJumlahStokKopi - totalkopilattedontbelate - totalkopigoncangjiwa - totalkopijalankenangan - totalkopipahittanparasa;
        jumlahPembeli = totalJumlahStokKopi - jumlahkopi;
        System.out.println("Total pembeli kopilattedontbelate: " + totalkopilattedontbelate + " | Total pembeli kopigoncangjiwa: " + totalkopigoncangjiwa + " | Total Pembeli kopijalankenangan: " + totalkopijalankenangan + " | Total Pembeli kopipahittanparasa: " + totalkopipahittanparasa );
        System.out.println("Jumlah Stok Limit Kopi Hari ini : " + totalJumlahStokKopi + " | Total Sisa Kopi: " + jumlahkopi);
        System.out.println("jumlah Seluruh Pembeli: " + jumlahPembeli);
        System.out.println();
        System.out.print("=============== Kopi Kenangan Jiwa ===============");
        System.out.print("");
        System.out.println("");
    }

    public static void CheckIndexArray(String[] myArray, String pasien) {
        int indexNow = 0;
        for (int index = 0; index < myArray.length; index++) {
            if (myArray[index] != null) {
                indexNow = index + 1;
            }
        }
        if (indexNow < myArray.length) {
            myArray[indexNow] = pasien;
        }
    }

    public static void simpankopi(int angkaRandom, String Kopi) {
        switch (angkaRandom) {
            case 1:
                System.out.println("**************");
                CheckIndexArray(kopilattedontbelate, Kopi);
                System.out.println("Anda Mendapat Kopi Latte Don't Be Late");
                Printpelanggan();
                System.out.println("**************");
                break;
            case 2:
                CheckIndexArray(kopigoncangjiwa, Kopi);
                System.out.println("Anda Mendapat Kopi Goncang Jiwa");
                Printpelanggan();
                break;
            case 3:
                CheckIndexArray(kopipahittanparasa, Kopi);
                System.out.println("Anda Mendapat Kopi Pahit Tanpa Rasa");
                Printpelanggan();
                break;
            case 4:
                CheckIndexArray(kopijalankenangan, Kopi);
                System.out.println("Anda Mendapat Kopi Jalan kenangan");
                Printpelanggan();
                break;
        }
    }

    public static void inputpembeli() {
        Scanner inputData = new Scanner(System.in);
        while (true) {
            System.out.print("Nama Pembeli = ");
            String namaPasien = inputData.nextLine();
            if (namaPasien.isBlank()) {
                System.out.println("Nama Pembeli Wajib diisi ");
                inputpembeli();
            } else {
                Random hasilRandom = new Random();
                int jenisRandom = hasilRandom.nextInt(3) + 1;
                simpankopi(jenisRandom, namaPasien);
            }
        }
    }
    static int stok = kopilattedontbelate.length + kopigoncangjiwa.length + kopijalankenangan.length + kopipahittanparasa.length;
    static int sisa = stok;

    public static void main(String[] args) {
        inputpembeli();
    }
}
