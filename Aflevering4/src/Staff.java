public class Staff {
    public static void main(String[] args) {
        Person adam = new Person("Adam");
        Boss bill = new Boss("Bill");
        Programmer carl = new Programmer("Carl");
        JavaProgrammer dean = new JavaProgrammer("Dean", "at programmere de små stykker koder indenfor algoritmerne som skal få udført arbejdet");
        JavaProgrammer eric = new JavaProgrammer("Eric", "algoritmer, som sørger for at eliminere redundant kode");

        System.out.println(adam.personMetode() + "\n");
        System.out.println(bill.chefRolle() + "\n");
        System.out.println(carl.programmørRolle() + "\n");
        System.out.println(dean.javaProgrammørRolle() + "\n");
        System.out.println(eric.javaProgrammørRolle() + "\n");
    }
}

class Person {
    String navn;

    public Person(String navn) {
        this.navn = navn;
    }

    public String personMetode() {
        return navn + " er en værdifuld medarbejder i dette projekt.";
    }

}

class Boss extends Person {
    public Boss(String navn) {
        super(navn);
    }

    public String chefRolle() {
        return personMetode() + " Han er chefen, som sørger for at delegere opgaver ud til alle medarbejderne, samt at holde øje med at projektet skyder frem og passer med tidsplanen. " + navn + " kan specielt godt lide at sniksnakke med hans yndlingsmedarbejdere så deres humør er i top.";
    }
}

class Programmer extends Person {
    
    public Programmer(String navn) {
        super(navn);
    }
    
    public String programmørRolle() {
        return personMetode () + " Han er en programmør som arbejder på projektet som chefen har givet holdet at arbejde med.";
    }
}

class JavaProgrammer extends Programmer {
    private String code;

    public JavaProgrammer(String navn, String code) {
        super(navn);
        this.code = code;
    }

    public String javaProgrammørRolle() {
        return programmørRolle() + " Han arbejder specifikt med " + code + ".";
    }
    
}