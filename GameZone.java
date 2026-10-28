import java.util.Scanner;

public class GameZone {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String transaksi;

        do {
            System.out.println("====================================");
            System.out.println("         GAMEZONE RENTAL PS");
            System.out.println("====================================");

            System.out.print("Nama Pelanggan : ");
            String nama = input.nextLine();

            System.out.println("\nPilihan Konsol:");
            System.out.println("1. PlayStation 4 - Rp8000/jam");
            System.out.println("2. PlayStation 5 - Rp12000/jam");

            int pilihan;
            do {
                System.out.print("Pilihan         : ");
                pilihan = input.nextInt();

                if (pilihan != 1 && pilihan != 2) {
                    System.out.println("Pilihan tidak valid. Pilih 1 atau 2.");
                }
            } while (pilihan != 1 && pilihan != 2);

            String konsol;
            int hargaPerJam;

            if (pilihan == 1) {
                konsol = "PlayStation 4";
                hargaPerJam = 8000;
            } else {
                konsol = "PlayStation 5";
                hargaPerJam = 12000;
            }

            int durasi;
            do {
                System.out.print("Lama Bermain    : ");
                durasi = input.nextInt();

                if (durasi <= 0) {
                    System.out.println("Durasi harus lebih dari 0 jam.");
                }
            } while (durasi <= 0);

            int biayaSewa = hargaPerJam * durasi;
            int diskon = 0;

            if (durasi >= 3) {
                diskon = biayaSewa * 10 / 100;
            }

            input.nextLine();

            String tambahMinuman;
            do {
                System.out.print("Tambah Minuman (Y/T): ");
                tambahMinuman = input.nextLine();

                if (!tambahMinuman.equalsIgnoreCase("Y")
                        && !tambahMinuman.equalsIgnoreCase("T")) {
                    System.out.println("Masukkan Y atau T.");
                }
            } while (!tambahMinuman.equalsIgnoreCase("Y")
                    && !tambahMinuman.equalsIgnoreCase("T"));

            int biayaMinuman = 0;

            if (tambahMinuman.equalsIgnoreCase("Y")) {
                biayaMinuman = 5000;
            }

            int totalBayar = biayaSewa - diskon + biayaMinuman;

            tampilkanStruk(
                nama, konsol, durasi, biayaSewa,
                diskon, biayaMinuman, totalBayar
            );

            do {
                System.out.print("\nTransaksi Baru (Y/T): ");
                transaksi = input.nextLine();

                if (!transaksi.equalsIgnoreCase("Y")
                        && !transaksi.equalsIgnoreCase("T")) {
                    System.out.println("Masukkan Y atau T.");
                }
            } while (!transaksi.equalsIgnoreCase("Y")
                    && !transaksi.equalsIgnoreCase("T"));

            System.out.println();

        } while (transaksi.equalsIgnoreCase("Y"));

        System.out.println("Terima kasih telah menggunakan GameZone!");

        input.close();
    }

    public static void tampilkanStruk(
            String nama,
            String konsol,
            int durasi,
            int biayaSewa,
            int diskon,
            int biayaMinuman,
            int totalBayar) {

        System.out.println("------------------------------------");
        System.out.println("           STRUK GAMEZONE");
        System.out.println("------------------------------------");
        System.out.println("Pelanggan       : " + nama);
        System.out.println("Konsol          : " + konsol);
        System.out.println("Durasi          : " + durasi + " jam");
        System.out.println("Biaya Sewa      : Rp" + biayaSewa);
        System.out.println("Diskon (10%)    : Rp" + diskon);
        System.out.println("Minuman         : Rp" + biayaMinuman);
        System.out.println("TOTAL BAYAR     : Rp" + totalBayar);
        System.out.println("====================================");
    }
}
