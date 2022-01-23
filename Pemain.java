import java.util.Scanner;
/**
 * Class Pemain adalah 
 * Deskripsi Game: Game ini dimainkan oleh 2 pemain. Setiap pemain menebak angka dadu yang akan muncul. Tebakan benar diberikan 10 poin,
 * sementara jika tebakan salah pemain mendapat poin 0. Jika tebakan salah dan muncul dadu angka 6 maka diberikan bonus 5 poin. Masing-masing
 * pemain mendapat 10 kali kesempatan untuk menebak. Pemain dengan skor tertinggi adalah pemenangnya.
 *
 * @author Desi Mardiani, Nanda Syafitri, Putri Mauliza, Putri Zainidar, Raudhatul Jannah
 * 
 * @version 28 Oktober 2017
 */

public class Pemain 
{
    //nama adalah field yang menampung input nama dari user
    private String nama;
    //nilai adalah perolehan skor pemain
    private int nilai;
    
    /**
     * Method Constructor kelas Pemain
     * menginisialisasi nilai awal variabel
     */
    public void Pemain (String nama)
    {
        this.nama = nama;
        nilai = 0;
    }
    
    /**
     * @Return nama pemain
     */
    public String getNama()
    {
        return nama;
    }

    /**
     * Memanggil parameter nama
     * Assignment nilai dari parameter nama yang dikirim 
     * kepada this.nama kepunyaan object
     */
    public void setNama (String nama)
    {
        //this.nama adalah variabel kepunyaan objek
        //nama adalah variabel kepunyaan parameter
        this.nama = nama;
    }
    
    /**
     * @Return nilai
     */
    public int getNilai ()
    {
        return nilai;
    }
    
    /**
     *Memanggil parameter nilai
     *Menghitung perolehan nilai
     */
    public void setNilai (int nilai)
    {
        //this.nilai adalah variabel kepunyaan objek
        //nilai adalah variabel yang dikirim dari parameter
        this.nilai = this.nilai + nilai;
    }
    
    public static void main (String args[])
    {
        //deklarasi dan inisialisasi nilai variabel lokal
        String back = "";
        String lanjut;
        int play;
        int tebakan1, tebakan2;
        //menciptakan sebuah Objek Dice dengan tipe DiceBattles
        DiceBattles Dice = new DiceBattles();
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n\t\t\t***************************");
        System.out.println("\t\t=====Welcome to the Dice Battles Game======");
        System.out.println("\t\t\t***************************\n");
        
        do {
            //mencetak pemberitahuan beberapa opsi kepada user
            System.out.println("Menu :");
            System.out.println("1. Mulai");
            System.out.println("2. Petunjuk");
            System.out.println("3. Keluar");
            System.out.print("Masukkan angka pilihan anda : ");
            play = input.nextInt();
                   
            //jika user menginput angka 2 maka program akan mengeksekusi bagian if berikut
            if(play==2){
               //Tampilan ketika user menginput angka 2
               System.out.println();
               System.out.println("    *----------------------------------------------------------------*");
               System.out.println("    |Petunjuk:                                                       |");
               System.out.println("    | - Game ini dimainkan oleh 2 pemain                             |");
               System.out.println("    | - Setiap pemain diberikan 10X kesempatan menebak angka dadu    |");
               System.out.println("    | - Tebakan benar, Anda mendapat 10 poin                         |");
               System.out.println("    | - Tebakan salah, Anda mendapat 0 poin                          |");
               System.out.println("    | - Tebakan salah dan muncul angka 6, Anda mendapat bonus 5 poin |");
               System.out.println("    | - Pemain dengan skor tertinggi adalah pemenangnya              |");
               System.out.println("    *----------------------------------------------------------------*");
               System.out.println();
               System.out.print("Kembali ke menu (Y/N) : ");
               //variabel back menampung input dari user
               back = input.next();
               //jika user menginput "n" atau "N" maka program akan exit/keluar
               if(back.equalsIgnoreCase("N")){
                   //perintah keluar 
                   System.exit(0);
               }
            }
        }while(back.equalsIgnoreCase("Y") && play == 2);//perulangan do...while akan dilakukan jika user menginput "N"/"n" dan play = 2.
          
        
        //jika user menginput angka 1 maka program akan mengeksekusi if berikut, body if berisi statement dan perintah untuk memainkan permainan The Dice Battles
         if (play == 1){
			 //menciptakan ojek pemain1 dan pemain2 bertipe Permainan
            Pemain pemain1 = new Pemain();
            Pemain pemain2 = new Pemain();
			do {
				int chance=0;
               //pemberitahuan menginput nama pemain dan ditampung pada masing-masing variabel
               System.out.println("Masukkan nama pemain 1: ");   
               pemain1.setNama(input.next());
               System.out.println("Masukkan nama pemain 2: ");   
               pemain2.setNama(input.next());
                    
               do {
                   int angka = Dice.getSisi();
                   System.out.println(">->->Kesempatan " +(++chance) +"<-<-<");
                   System.out.print(pemain1.getNama() + " : ");
                   tebakan1 = input.nextInt();
                   System.out.print(pemain2.getNama() + " : ");
                   tebakan2 = input.nextInt();
                    
                   if(tebakan1 == angka){
                       pemain1.setNilai(10);
                   }
                   else if ((tebakan1 != angka) && (angka==6)) {
                       pemain1.setNilai(5) ;
                   }
                   if (tebakan2 == angka){
                       pemain2.setNilai(10);
                   }
                   else if ((tebakan2 != angka) && (angka==6)) {
                       pemain2.setNilai(5) ;
                   }
               
                   System.out.println("(!)Skor "+pemain1.getNama() +": " +pemain1.getNilai());
                   System.out.println("(!)Skor "+pemain2.getNama() +": " +pemain2.getNilai());
               
                   if (chance == 10){
                        if (pemain1.getNilai() > pemain2.getNilai()){
                            System.out.println("Selamat " +pemain1.nama +" menang !!");
                        }
                        else if (pemain1.getNilai() < pemain2.getNilai()) {
                            System.out.println("Selamat " +pemain2.nama +" menang !!");
                        }
                        else {
                            System.out.println("Permainan seri, skor anda sama");
                        }
                    }
               }while (chance <10);
			System.out.println();
            System.out.println("Apakah anda ingin melanjutkan permainan (Y/N) ?");
            lanjut = input.next();
			}while(lanjut.equalsIgnoreCase("Y"));
		
        }
        else if (play == 3){
        System.exit(0);
        }    
        else {
            System.out.println("Input yang anda masukkan salah");
        }
           
    }
}        