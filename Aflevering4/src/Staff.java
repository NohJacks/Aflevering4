public class Staff {
    public static void main(String[] args) {
        Person adam = new Person("Adam");
        Boss bill = new Boss("Bill");
        Programmer carl = new Programmer("Carl");
        JavaProgrammer dean = new JavaProgrammer("Dean", "Java");
        JavaProgrammer eric = new JavaProgrammer("Eric", "C++");

        System.out.println(adam.personMethod());
        System.out.println(bill.chefRolle());
        System.out.println(carl.programmørRolle());
        System.out.println(dean.javaProgrammørRolle());
        System.out.println(eric.javaProgrammørRolle());
    }
}

class Person {
    String navn;

    public Person(String navn) {
        this.navn = navn;
    }

    public String personMethod() {
        return navn + " er en værdifuld medarbejder i dette projekt.";
    }

}

class Boss extends Person {
    public Boss(String navn) {
        super(navn);
    }

    public String chefRolle() {
        return personMethod() + " Han er chefen, som sørger for at delegere opgaver ud til alle medarbejderne, samt at holde øje med at projektet skyder frem og passer med tidsplanen. " + navn + " kan specielt godt lide at sniksnakke med hans yndlingsmedarbejdere så deres humør er i top.";
    }
}

class Programmer extends Person {
    
    public Programmer(String navn) {
        super(navn);
    }
    
    public String programmørRolle() {
        return personMethod () + " Han er en programmør som arbejder på projektet som chefen har givet holdet at arbejde med.";
    }
}

class JavaProgrammer extends Programmer {
    private String code;

    public JavaProgrammer(String navn, String code) {
        super(navn);
        this.code = code;
    }

    public String javaProgrammørRolle() {
        return programmørRolle() + " Han arbejder specifikt med " + code;
    }
    
}

