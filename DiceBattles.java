/**
 * Write a description of class DiceBattles here.
 *
 * @author Desi Mardiani, Nanda Syafitri, Putri Mauliza, Putri Zainidar, Raudhatul Jannah
 * 
 * @version 28 Oktober 2017
 */
public class DiceBattles
{
   private int sisi;
   
   public void Dadu(){
      lemparDadu();
   }
   
   public int getSisi(){
       lemparDadu();
       return sisi; 
   }
   
   private void lemparDadu(){
       sisi = (int) (1+Math.random()*6);
   }
}
