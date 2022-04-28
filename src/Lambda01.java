import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        //Structured Programming kullanarak list elemanlarını aralarında bosluk olacak sekilde print ediniz.
        printElStructured(sayi);
        System.out.println("\n***");
        printElFurctional(sayi);
        System.out.println("\n***");
        printElFurctional1(sayi);
        System.out.println("\n***");
        printElFurctional2(sayi);
        System.out.println("\n***");
        printCiftElFunctional(sayi);
        System.out.println("\n***");
        printCiftElFunctional1(sayi);
        System.out.println("\n***");
        printCiftotzKckFunctional(sayi);
        System.out.println("\n***");
        printCifveyatotzKckFunctional(sayi);

    }

    public static void printElStructured(List<Integer> sayi) {
        for (Integer m : sayi) {
            System.out.print(m + " ");
        }
    }

    public static void printElFurctional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " ")); // stream =listeyi dikey akisa goturur t=m
    }
    /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };

        FELSEFESI:NASIL YOKTUR NE VARDIR NE YAPSIN
  Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
 */

    public static void printElFurctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print); // method reference --> System.out yapisinda print methodu refere et
        //bu action task'deki ayni satira ve bosluk ile yazmayi karsilamaz bunun icin seed (tohum) method create edildi
    }

    public static void printElFurctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir); // method reference --> System.out yapisinda print methodu refere et
        // sol taraf kaynak :  sag taraf method
        //lambda classindan yazdir methodunu cagirdik
    }

    public static void yazdir(int a) {// verilen int degeri ayni satirda bosluk birakarak yazdirma actionu yapan  seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    //Task : structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz


    public static void printCiftElSturtured(List<Integer> sayi) {
        for (Integer each : sayi
        ) {
            if (each % 2 == 0 ) {
                System.out.print(each + " ");
            }

        }
    }

    //Functured structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.stream().filter(t->t%2==0 ).forEach(Lambda01::yazdir);

    }
    public static boolean cftBul(int a ){

        return a%2==0;
    }
    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.
                stream().// list elemanlari akisa alindi
                filter(Lambda01::cftBul).// cift bul method refere edilerek akisdaki elemanlar filtrelendi
                forEach(Lambda01::yazdir); // filtreden gelen elemanlar yazdir methodu refere edilerek print edildi

    }
    //Task : structured Programming ile list elemanlarinin  34den kucuk olanalrini ayni satirda aralarina bosluk birakarak print ediniz
   public static void printCiftotzKckFunctional(List<Integer> sayi){
       sayi.
               stream().
               //filter(t->t%2==0 && t<34).
               filter(t->t%2==0).  //filter(Lambda01::cftBul).
               filter(t->t<34). //lambda exp.
               forEach(Lambda01::yazdir);

   }
   //Task : structured Programming ile list elemanlarinin  34den kucuk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
   public static void printCifveyatotzKckFunctional(List<Integer> sayi){
       //sayi.
       //        stream().
       //        filter(Lambda01::cftBul).
       //        filter(t-> t>34).
       //        forEach(Lambda01::yazdir); // 34 den buyuk cift

       sayi.
               stream().
               filter(t->t%2==0 || t>34).
               forEach(Lambda01::yazdir); // 34 veya cift
   }


}
