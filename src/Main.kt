/**
 * Dieses Projekt dient der Seminararbeit 1 zu Kotlin für die Technsiche Hochschule Mittelhessen
 * Es enthält Funktionen von Kotlin zu den enstprechenden Kapiteln der Seminararbeit 
 *
 * Tobias Walter
 * Technische Hochschule Mittelhessen
 */

abstract class BeispielKlasse(){
    abstract var nachricht: String
    abstract fun printNachricht()
}

class BeispielKlasseErbe(text: String, zahl: Int): BeispielKlasse(){
    val text: String = text
    override var nachricht: String = "Keine Nachricht"

    /** lateinit
     * so nicht in Java vorhanden, aber durchaus machbar
     * allerdings leidet dadurch die Null-Sicherheit **/

    lateinit var ausgabe: Integer

    /** Getter und Setter
     * Nicht in dieser Form in Java verfügbar
     * public String getText(){ return text; }
     * public void setText(){ this.text = text; }**/

    var zahl: Int = zahl
        get() = field - 1
        set(value){
            zahl = value + 1
        }

    /** Sekundäre Konstruktoren
     * Nicht in Java verfügbar **/

    constructor(text: String, zahl: Int, nachricht: String): this(text, zahl){
        this.nachricht = nachricht
        println(nachricht)
    }

    override fun printNachricht() {
        println(nachricht)
        ausgabe = Integer(ausgabe.toInt() + 1)
    }


    /** Init-Blöcke
     * Nicht in Java verfügbar
     * Machen Code-Logik noch expliziter
     * trennen Intialisierung von anderer Logik**/

    init {
        println("Diese Klasse kann eine Nachricht ausgeben.")
        ausgabe = Integer(1)
    }
}


/** Data Classes
 * Nicht in Java verfügbar
 * Codersparnis für Daten-Klassen **/

data class Hund(val name: String, var alter: Int)

fun main() {
    /** String Templates
     * In Java nur über Bibliotheken verfügbar (Apache Common Text),
     * Java mit "text" + string **/

    var text: String = "World"

    println("Hello $text")

    /** Einzeilige Funktionen
     * Nicht in Java verfügbar **/

    fun einzeiligeFunktion(a: Int, b: Int): Int = a+b

    println(einzeiligeFunktion(2, 3))

    /** TypeCasts
     * In Java über instanceOf möglich, aber es ist ein zusätzlicher Cast notwendig
     * um Funktionen der geprüften Klasse zu verwenden
     * BeispielKlasse klasseCasted = (BeispielKlasseErbe) klasse; **/

    var klasse: BeispielKlasse = BeispielKlasseErbe("text", 1)

    if (klasse is BeispielKlasseErbe){
        klasse.printNachricht()
    }

    /** Maybe-Typen
     * Bietet Null-Sicherheit durch keinen Zugriff auf
     * nicht initialisierte Werte über Maybe-Typen
     * In Java nur über eine if-Abfrage zu realisieren
     * if(maybeVar != null){
     *      System.out.prinln(maybevar);
     * } **/

    var maybeVar: String? = null

    // wird nicht ausgegeben
    println(maybeVar?.length)

    maybeVar = "Text"

    // wird ausgegeben
    println(maybeVar?.length)

    /** if not null
     * stellt eine alternative Logik bereit falls ein Wert null ist
     * In Java nur über eine if-Abfrage zu realiseren mit else-Block
     * if(maybevar != null)
     *  System.out.println(maybeVar);
     * } else {
     *  System.out.println("Der Wert war Null!);
     * } **/

    maybeVar = null

    // gibt den alternativen Wert "Der Wert war Null!" aus, da maybeVar null ist
    println(maybeVar ?: "Der Wert war Null!")

    /** Zuweisungen mit if-Abfragen
     * In Java möglich aber nicht so explizit
     * maybeVar = (maybeVar == null) ? "Nicht Null" : "Null" **/

    maybeVar = if(maybeVar == null) "Nicht Null" else "Null"

    /** for-schleife mit Indizes
     * In Java nur über zusätzliche Zählvariable
     * Int i = 0;
     * for ( Int i : testArray){
     *  i++;
     *  System.out.println("Der Wert " + testArray[i] + " mit dem Index " + i);
     * }**/

    val testArray = intArrayOf(1, 2, 3)

    for (i in testArray.indices){
        println("Der Wert ${testArray[i]} mit dem Index $i")
    }

    /** When
     * In Java über switch verfügbar, erlaubt aber weder Lambda-Funktionen noch die Prüfung auf Range o.a
     * switch(x){
     *  case 1: println() break;
     *  case 2: println() break;
     *  case 3: println() break;
     *  case 4: println() break;
     *  case 5: println() break;
     *  case 100: println() break;
     *  case mit Range nicht möglich: println() break;
     *  default: println() break;
     * }
     * **/
    var x: Int = 100

    when(x){
        1 -> println("$x ist 1")
        2, 3, 4, 5 -> println("$x ist 2, 3, 4 odr 5")
        100 -> println("$x ist 100")
        in 101..1000 -> println("$x ist zwischen 101 und 1000")
        else -> println("$x")
    }

    /** Destructuring
     * Nicht in Java verfügbar **/

    val hund = Hund("Lucky", 6)

    var (name, alter) = hund

    println("$name ist $alter Jahre alt.")

   /** Getter und Setter - Aufruf
    * In Java nicht implizit sondern über Methoden die vorher definiert werden müssen
    * klasse.setNachricht("Eine neue Nachricht");
    * System.out.println(klasse.getNachricht()); **/

    // setter
    klasse.nachricht = "Eine neue Nachricht."

    // getter
    println(klasse.nachricht)

}











