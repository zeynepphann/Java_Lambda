import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilice", "havucDilim", "burma", "yaglama", "kokorec", "arabasi", "guvec"));

        alfBykTekrrsz(menu);
        System.out.print("\n **** ");
        chrSayisiTersSirala(menu);
        System.out.print("\n **** ");
        harfSayisi7denAzKontrol(menu);
        System.out.print("\n **** ");
        wIleBaslayanElKontrol(menu);
        System.out.print("\n **** ");

    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek) {
        yemek.
                stream().//akisa girdi
                map(t -> t.toUpperCase()).// buyuk harf
                sorted().// dogal siralama
                distinct().//benzersiz hale getirdi tekrarsiz ozel bir method
                forEach(t -> System.out.println(t + " "));

    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirala(List<String> menu) {
        menu.stream().
                map(t -> t.length()).//elemanlar karakter sayisina update edildi
                sorted(Comparator.reverseOrder()). //ters sire
                distinct().
                //forEach(t-> System.out.println(t+" ")); bu da olur
                        forEach(Lambda01::yazdir);
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBykSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t -> System.out.println(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).reversed()).
                forEach(t -> System.out.println(t + " "));

         }
    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void charKaresiCiftElSiralama(List<String> menu){
        menu.
                stream().
                map(t->t.length()*t.length()).
                filter(Lambda01::cftBul).
                distinct().//benzersiz
                sorted(Comparator.reverseOrder()).//ters buyukten kucuge
                forEach(Lambda01::yazdir);
    }
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
     public static void harfSayisi7denAzKontrol(List<String> menu){
     boolean kontrol =  menu.
                stream().allMatch(t->t.length()<=7);
        if (kontrol){
            System.out.println("List elemanlari 7 harften kucuk");
        }else
            System.out.println("List elemanlari 7 harften buyuk" );

         System.out.println("kontrol = " + kontrol);
         //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
         //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
         //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
     }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> menu){
        System.out.println(menu.stream().noneMatch(t->t.startsWith("w"))?" w ile baslayan yemegin menude var":"w ile baslayan yemegin menude yok");
    //Yanlis sonuc

    }
    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

}
