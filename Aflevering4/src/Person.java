public class Staff {
    public static void main(String[] args) {
        Person adam = new Person("Adam");
        Boss bill = new Boss("Bill");
        Programmer carl = new Programmer("Carl");
        JavaProgrammer dean = new JavaProgrammer("Dean", "Java");
        JavaProgrammer eric = new JavaProgrammer("Eric", "C++");

        System.out.println(adam.toString());
    }
}

public class Person {
    String navn;

    public PersonMethod(String navn) {
        dette.navn = navn;
    }

    public String personToString() {
        return "Person: " + navn;
    }

}

public class Boss extends Person {
    public String chefRolle() {
        return navn + " sørger for at delegere opgaver ud til alle medarbejderne, samt at holde øje med\nat projektet skyder frem og passer med tidsplanen. " + navn + " kan specielt godt lide at\nsniksnakke med hans yndlingsmedarbejdere så deres humør er i top.";
    }
}

public class Programmer extends Person {
    public String programmørRolle() {
        return navn + " er en programmør som arbejder på projektet som chefen har givet holdet at arbejde med.";
    }
}

public class JavaProgrammer extends Programmer {
    Private String code;
   
    // konstruktør
    public initializeCode (String code) {
        initialize.code = code;
    }
    
    public String getCode () {
        return code;
    }

    public String javaProgrammørRolle1() {
        return navn + " arbejder specifikt med Java, "
    }
    
}

