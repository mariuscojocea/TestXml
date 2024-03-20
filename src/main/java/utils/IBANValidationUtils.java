package utils;

import nl.garvelink.iban.IBAN;

public class IBANValidationUtils {


    public static boolean validateIban(String iban) {
        IBAN ibn = IBAN.parse(iban);
        return ibn.isSEPA();
    }
}
