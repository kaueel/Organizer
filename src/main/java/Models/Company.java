package Models;

import java.util.ArrayList;

public class Company implements ClientType {
    ArrayList<Representative> representatives = new ArrayList<>();
    String clientDocument;

    @Override
    public String getClientDocument() {
        return null;
    }
}
