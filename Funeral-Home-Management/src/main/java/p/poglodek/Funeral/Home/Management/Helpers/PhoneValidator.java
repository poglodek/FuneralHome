package p.poglodek.Funeral.Home.Management.Helpers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class PhoneValidator {
    private static final Pattern VALID_PHONE_REGEX = Pattern.compile("[0-9]{9}$", Pattern.CASE_INSENSITIVE);

    public boolean isValid(int phone){
        var match = VALID_PHONE_REGEX.matcher(phone + "");
        return match.find();
    }
}
