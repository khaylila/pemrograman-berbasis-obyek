package MakhlukHidup;

public class Tumbuhan extends MakhlukHidup {
    private String bentukDaun;
    protected String bentukBiji;

    public Tumbuhan() {
        System.out.println("Ini adalah konstruktor kelas Tumbuhan tanpa parameter");
    }

    public Tumbuhan(String bentukDaun) {
        System.out
                .println("Ini adalah konstruktor kelas Tumbuhan dengan satu parameter, yakni bentukDaun " + bentukDaun);
        this.bentukDaun = bentukDaun;
    }

    public Tumbuhan(String bentukDaun, String warnaDaun) {
        System.out.println("Ini adalah konstruktor kelas Tumbuhan dengan dua parameter, yakni bentukDaun " + bentukDaun
                + " dan warnaDaun " + warnaDaun);
    }

    public void setBentukDaun(String bentukDaun) {
        this.bentukDaun = bentukDaun;
    }

    public String getBentukDaun() {
        return bentukDaun;
    }
}
