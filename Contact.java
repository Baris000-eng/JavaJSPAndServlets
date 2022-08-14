package tr.com.obss.jip22.demo3.Model;

public class Contact {
    private String name;
    private String gsm;

    public Contact(String name, String gsm) {
        this.name = name;
        this.gsm = gsm;
    }

    public String getName() {
        return name;
    }


    public String getGsm() {
        return gsm;
    }
}
