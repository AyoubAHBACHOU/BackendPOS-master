package ma.stibits.pos.model.bo;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Test {
    public static void main(String[] args) {
        Merchant m = new Merchant();
        m.setFirstName("chaimae");
        System.out.println(m.getFirstName());

    }
}
