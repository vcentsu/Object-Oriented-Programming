/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.pkgcase.pkg1;
import java.util.*;
import java.time.LocalDate;

/**
 *
 * @author vince
 */
class pel{
    private String namaPelanggar;
    private String alamatPelanggar;
    private long NIK;
    private String kendaraan;
    private String tipe;
    ArrayList<Integer> jenisPelanggaran = new ArrayList<>();
    private int jumlahPelanggaran;
    private long noTlp;
    private String email;
    private int denda=0;
    
    public pel(String nama, String alamat, long nik, String kendaraan, String tipe, 
            int jumlahPelanggaran, ArrayList jp, long noTlp, String email){
            this.namaPelanggar = nama;
            this.alamatPelanggar = alamat;
            this.NIK = nik;
            this.kendaraan = kendaraan;
            this.tipe = tipe;
            this.jumlahPelanggaran = jumlahPelanggaran;
            this.jenisPelanggaran = jp;
            this.noTlp = noTlp;
            this.email = email;
    }
    
    public String getNama() {
        return namaPelanggar;
    }
    
    public String getAlamat() {
        return alamatPelanggar;
    }

    public long getNik() {
        return NIK;
    }
    
    public String getKendaraan() {
        return kendaraan;
    }
    
    public void getTipeKendaraan() {
        if (tipe.equals("r4") || tipe.equals("R4")){
            System.out.println("Roda 4");
        }else{
            System.out.println("Roda 2");
        }
    }
    
    public long getNoTlp() {
        return noTlp;
    }

    public String getEmail() {
        return email;
    }
    
    public int getDenda(){
        for (int i=0;i<jumlahPelanggaran;i++){
            if (tipe.equals("r4") || tipe.equals("R4")){
                switch (jenisPelanggaran.get(i)){
                    case 1 : denda = denda + 750000;break;
                    case 3 : denda = denda + 250000;break;
                    case 4 : denda = denda + 500000;break;
                    case 5 : denda = denda + 500000;break;
                }
            } else {
                switch (jenisPelanggaran.get(i)){
                    case 1 : denda = denda + 750000;break;
                    case 2 : denda = denda + 250000;break;
                    case 4 : denda = denda + 500000;break;
                    case 5 : denda = denda + 500000;break;
                }
            }
        }
        return denda;
    }
    
    public int showDenda(){
        return denda;
    }
    
    public void getJenisPelanggaran(){
        System.out.println("Jenis Pelanggaran Tertilang : ");
        
        for (int i=0;i<jumlahPelanggaran;i++){
            if (tipe.equals("r4") || tipe.equals("R4")){
                switch (jenisPelanggaran.get(i)){
                    case 1 : System.out.println(" - Menggunakan Gawai / Handphone saat berkendara");break;
                    case 3 : System.out.println(" - Tidak memakai sabuk pengaman");break;
                    case 4 : System.out.println(" - Melanggar rambu lalu lintas dan marka jalan");break;
                    case 5 : System.out.println(" - Memakai plat nomer palsu");break;
                }
            } else {
                switch (jenisPelanggaran.get(i)){
                    case 1 : System.out.println(" - Menggunakan Gawai / Handphone saat berkendara");break;
                    case 2 : System.out.println(" - Tidak memakai helm");break;
                    case 4 : System.out.println(" - Melanggar rambu lalu lintas dan marka jalan");break;
                    case 5 : System.out.println(" - Memakai plat nomer palsu");break;
                }
            }
        }
    }
    
    public void printSurat (LocalDate tgl, String namaPetugas){
        System.out.println("______________________________________________\n");
        System.out.println("SURAT WARNA-WARNI E-TILANG ");
        System.out.println("Tanggal : " + tgl);
        System.out.println("==============================================");
        System.out.println("Surat ini dicatat kedalam system oleh " + namaPetugas);
        System.out.println("==============================================");
        System.out.println("DATA PELANGGAR");
        System.out.println("  Nama : " + namaPelanggar);
        System.out.println("  Alamat : " + alamatPelanggar);
        System.out.println("  NIK : " +NIK);
        System.out.println("  Nomor Telepon : " + noTlp);
        System.out.println("  Email : " + email);
        System.out.println("==============================================");
        System.out.println("DATA KENDARAAN");
        System.out.println("  Jenis Kendaraan : " + kendaraan);
        System.out.print("  Tipe Kendaraan : "); 
        getTipeKendaraan();
        System.out.println("==============================================");
        System.out.println("DATA PELANGGARAN");
        System.out.println("  Jumlah Pelanggaran : " + jumlahPelanggaran);
        getJenisPelanggaran();
        System.out.println("  Denda Pelanggaran : " + showDenda());
        System.out.println("______________________________________________");
    }
}

public class UTSCase1 {

    public static void beginning(){
        System.out.println(" _______            _______    ___    ___       _______    _______    ________  ");
        System.out.println("|       |          |       |  |   |  |   |     |   _   |  |       |  |        | ");
        System.out.println("|    ___|   ____   |_     _|  |   |  |   |     |  |_|  |  |   _   |  |   ___  | ");
        System.out.println("|   |___   |____|    |   |    |   |  |   |     |       |  |  | |  |  |  |   |_| ");
        System.out.println("|    ___|            |   |    |   |  |   |__   |       |  |  | |  |  |  | ____  ");
        System.out.println("|   |___             |   |    |   |  |      |  |   _   |  |  | |  |  |  |__|  | ");
        System.out.println("|_______|            |___|    |___|  |______|  |__| |__|  |__| |__|  |________| \n");
        
        System.out.println("                *Created By Vincentius Sutanto (2301879583)");
        System.out.println("===============================================================================\n");
    }
    
    public static void menu(){
        System.out.println();
        System.out.println("+=============================+");
        System.out.println("+     Warna Warni E-Tilang    +");
        System.out.println("+=============================+");
        System.out.println("+ 1. Pendataan Pelanggaran    +");
        System.out.println("+ 2. Melihat Pelanggaran      +");
        System.out.println("+ 3. Menampilkan Surat Tilang +");
        System.out.println("+ 4. Close                    +");
        System.out.println("+=============================+");
        System.out.print("Choice [1-4] >> ");
    }
    
    public static void listPelanggaran(){
        System.out.println(" ________________________________________________________________");
        System.out.println("|No | Jenis Pelanggaran            | Roda Dua | Roda Empat/Lebih |");
        System.out.println("|___|______________________________|__________|__________________|");
        System.out.println("| 1 | Menggunakan Gawai /          | 750.000  | 750.000          |");
        System.out.println("|   | Handphone saat berkendara    |          |                  |");
        System.out.println("| 2 | Tidak memakai helm           | 250.000  | -                |");
        System.out.println("| 3 | Tidak memakai sabuk pengaman | -        | 250.000          |");
        System.out.println("| 4 | Melanggar rambu lalu lintas  | 500.000  | 500.000          |");
        System.out.println("|   | dan marka jalan              |          |                  |");
        System.out.println("| 5 | Memakai plat nomer palsu     | 500.000  | 500.000          |");
        System.out.println("|___|______________________________|__________|__________________|");
    }
    
    private static void showPelanggaran (ArrayList <pel> pelanggaran){
        for (int i=0; i<pelanggaran.size(); i++){
            System.out.println("\nPelanggaran ke-" + (i+1));
            System.out.println("Nama : " + pelanggaran.get(i).getNama());
            pelanggaran.get(i).getJenisPelanggaran();
            System.out.println("Total Denda : " + pelanggaran.get(i).getDenda());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner centsu = new Scanner(System.in);
        ArrayList <pel> pelanggaran = new ArrayList<>();
        String namaPetugas, password;
        int choice;
        String nama, alamat, kendaraan, tipe, email;
        int  jumlahPelanggaran=0, jenisPelanggaran=0, size=0;
        long nik=0,noTlp=0;
        Character simpan;
        
        beginning();
        System.out.println("LOGIN");
        System.out.print("Nama Petugas : ");
        namaPetugas = centsu.nextLine();
        do{
            System.out.print("Password : ");
            password = centsu.next();  //Input password MUST BE "admin" or "Admin"
            if(!password.equals("admin") && !password.equals("Admin"))
                System.out.println("Password SALAH");
        }while(!password.equals("admin") && !password.equals("Admin"));
        centsu.nextLine();
        
        do{
            menu();
            choice = centsu.nextInt();
            centsu.nextLine();
            
            System.out.println();
            switch(choice){
                case 1: {
                    System.out.println("INPUT TO SYSTEM");
                    System.out.println("===============");
                    
                    System.out.print("Nama Pelanggar : ");
                    nama = centsu.nextLine();
                    
                    System.out.print("Alamat Pelanggar : ");
                    alamat = centsu.nextLine();
                    
                    do{
                        System.out.print("NIK : ");
                        try{
                            nik = centsu.nextLong();
                        }catch(Exception e){
                            System.out.println("Input must be numeric");
                            centsu.nextLine();
                        }
                    }while(nik<=0);
                    
                    System.out.print("Jenis Kendaraan Pelanggar : ");
                    kendaraan = centsu.next();
                    
                    do{
                        System.out.print("Tipe Kendaraan Pelanggar [R2|R4]: ");
                        tipe = centsu.next();
                    }while(!tipe.equals("R2") && !tipe.equals("r2") && !tipe.equals("R4") && !tipe.equals("r4"));
                    centsu.nextLine();
                    
                    ArrayList jp = new ArrayList();   // jp = jenis pelanggaran
                    listPelanggaran();
                    do{
                        System.out.print("Jumlah Pelanggaran Tertilang : "); //memasukkan jumlah pelanggaran tertilang
                        jumlahPelanggaran = centsu.nextInt();
                    }while(jumlahPelanggaran>5 || jumlahPelanggaran<=0);
                    
                    for (int i=0;i<jumlahPelanggaran;i++){
                        do{
                            System.out.print("Jenis Pelanggaran ke-" + (i+1) + " : ");
                            try{
                                jenisPelanggaran = centsu.nextInt();
                            }catch (Exception e){
                                System.out.println("Input must be numeric");
                                centsu.nextLine();
                            }
                        }while(jenisPelanggaran>5 || jenisPelanggaran<1);
                        jp.add(jenisPelanggaran);
                    } 
                    
                    do{
                        System.out.print("Nomor Telephone Pelanggar: ");
                        try{
                            noTlp = centsu.nextLong();
                        }catch(Exception e){
                            System.out.println("Input must be numeric");
                            centsu.nextLine();
                        }
                    }while(noTlp<=0);
                    
                    System.out.print("Email Pelanggar : ");
                    email = centsu.next();
                    
                    do{
                        System.out.print("\nApakah anda sudah yakin untuk menyimpan [Y/T]: ");
                        simpan = centsu.next().charAt(0);
                    }while (!simpan.equals('Y') && !simpan.equals('y') && !simpan.equals('T') && !simpan.equals('t'));
                    
                    if (simpan.equals('Y') || simpan.equals('y')){
                        if(pelanggaran.isEmpty()){
                            size = 1;
                        }else{
                            size = pelanggaran.size() + 1;
                        }
                        
                        pel tilang = new pel(nama, alamat, nik, kendaraan, tipe, jumlahPelanggaran, jp, noTlp, email);
                        pelanggaran.add(tilang);  
                        
                        System.out.println(" >> DATA TERSIMPAN << ");
                        
                    }
                    
                    System.out.print("\nPress ENTER to continue . . .");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 2: {
                    LocalDate tgl = LocalDate.now();

                    System.out.println("DATA E-TILANG");
                    System.out.println("Tanggal : " + tgl);
                    System.out.println("================================");
                    
                    if (pelanggaran.isEmpty()==true){
                        System.out.println("Belum ada pelanggaran yang tercatat");
                    }else{
                        showPelanggaran(pelanggaran);
                    }
                    
                    System.out.print("\nPress ENTER to continue . . .");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 3: {
                    LocalDate tgl = LocalDate.now();
                    int pilih;
                    
                    if (pelanggaran.isEmpty()==true){
                        System.out.println("Belum ada pelanggaran yang tercatat, tidak ada yang dapat dicetak");
                    }else{
                        System.out.println("DAFTAR PELANGGARAN TERCATAT");
                        showPelanggaran(pelanggaran);
                        System.out.println();
                        
                        do{
                            System.out.print("Pilih Pelanggaran [1.." + size+"]: ");
                            pilih = centsu.nextInt();
                        }while(pilih<1 || pilih>size);
                         
                        System.out.println();
                        pelanggaran.get(pilih-1).printSurat(tgl, namaPetugas);
                        
                        do{
                            System.out.print("\nApakah anda sudah yakin untuk mencetak surat [Y/T]: ");
                            simpan = centsu.next().charAt(0);
                        }while (!simpan.equals('Y') && !simpan.equals('y') && !simpan.equals('T') && !simpan.equals('t'));
                        
                        if (simpan.equals('Y') || simpan.equals('y')){
                            System.out.println(" >> SURAT TERCETAK << ");
                        }
                    }
                    
                    System.out.print("\nPress ENTER to continue . . .");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
            }
        }while(choice!=4);
     
    }
    
}
