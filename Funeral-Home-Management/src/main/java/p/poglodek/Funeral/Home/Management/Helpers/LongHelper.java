package p.poglodek.Funeral.Home.Management.Helpers;

import org.springframework.stereotype.Service;

@Service
public class LongHelper {
    public boolean tryParseLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
