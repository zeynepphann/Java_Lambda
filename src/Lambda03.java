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
        // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
        // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
        // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
        // Task : Karakter sayisi en buyuk elemani yazdiriniz.
        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    }
}
