package MakhlukHidup;

import java.util.ArrayList;

public class Hewan extends MakhlukHidup {
    public int jumlahKaki = 0;

    public ArrayList<String> getCiriCiri() {
        return ciriCiri;
    }

    public void addCiriCiri(String ciriCiri) {
        this.ciriCiri.add(ciriCiri);
    }
}
