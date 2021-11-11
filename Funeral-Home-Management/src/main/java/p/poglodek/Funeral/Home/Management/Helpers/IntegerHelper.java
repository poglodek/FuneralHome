package p.poglodek.Funeral.Home.Management.Helpers;

import org.springframework.stereotype.Service;

@Service
public class IntegerHelper {
    public boolean tryParseInt(String value) {
        try {
             Integer.parseInt(value);
             return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
