package org.javarushModule1;
public class cryptService {
    private String uaModifiedSmallLetter = "";
    private String uaModifiedCapitalLetter = "";
    private String usModifiedSmallLetter = "";
    private String usModifiedCapitalLetter = "";
    private String modifiedSymbols = "";
    final private String uaSmallLetter = "абвгґдеєжзиїйклмнопрстуфхцчшщюя";
    final private String uaCapitalLetter = "АБВГҐДЕЄЖЗИЇЙКЛМНОПРСТУФХЦЧШЩЮЯ";
    final private String usSmallLetter = "abcdefghijklmnopqrstuvwxyz";
    final private String usCapitalLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final private String symbols = "@#$%^&*()_+={}[]|\\:;\"'<>,.?/~`";
    public void modifiedStringWithSmallLetter(int key) {
        //Ukraine modified str
        int lengthUA = uaSmallLetter.length();
        int realKeyUA = key % lengthUA;
        StringBuilder modifiedStringUA = new StringBuilder(lengthUA);
        for (int i = 0; i < lengthUA; i++) {
            int newIndexUA = (i + realKeyUA) % lengthUA;
            modifiedStringUA.append(uaSmallLetter.charAt(newIndexUA));
        }
        uaModifiedSmallLetter = modifiedStringUA.toString();
        int lengthUS = usSmallLetter.length();
        int realKeyUS = key % lengthUS;
        StringBuilder modifiedStringUS = new StringBuilder(lengthUS);
        for (int i = 0; i < lengthUS; i++) {
            int newIndexUS = (i + realKeyUS) % lengthUS;
            modifiedStringUS.append(usSmallLetter.charAt(newIndexUS));
        }
        usModifiedSmallLetter = modifiedStringUS.toString();
    }
    public void modifiedStringWithCapitalLetter(int key) {
        int lengthUA = uaCapitalLetter.length();
        int realKeyUA = key % lengthUA;
        StringBuilder modifiedStringUA = new StringBuilder(lengthUA);
        for (int i = 0; i < lengthUA; i++) {
            int newIndex = (i + realKeyUA) % lengthUA;
            modifiedStringUA.append(uaCapitalLetter.charAt(newIndex));
        }
        uaModifiedCapitalLetter = modifiedStringUA.toString();

        int lengthUS = usCapitalLetter.length();
        int realKeyUS = key % lengthUS;
        StringBuilder modifiedStringUS = new StringBuilder(lengthUS);
        for (int i = 0; i < lengthUS; i++) {
            int newIndexUS = (i + realKeyUS) % lengthUS;
            modifiedStringUS.append(usCapitalLetter.charAt(newIndexUS));
        }
        usModifiedCapitalLetter = modifiedStringUS.toString();
    }
    public void modifiedSymbol(int key) {
        int length = symbols.length();
        int realKey = key % length;
        StringBuilder modified_symbols = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int newIndex = (i + realKey) % length;
            modified_symbols.append(symbols.charAt(newIndex));
        }
        modifiedSymbols = modified_symbols.toString();

    }
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (uaSmallLetter.indexOf(text.charAt(i)) != -1) {
                result.append(uaModifiedSmallLetter.charAt(uaSmallLetter.indexOf(text.charAt(i))));
            } else if (uaCapitalLetter.indexOf(text.charAt(i)) != -1) {
                result.append(uaModifiedCapitalLetter.charAt(uaCapitalLetter.indexOf(text.charAt(i))));
            } else if (usSmallLetter.indexOf(text.charAt(i)) != -1) {
                result.append(usModifiedSmallLetter.charAt(usSmallLetter.indexOf(text.charAt(i))));
            } else if (usCapitalLetter.indexOf(text.charAt(i)) != -1) {
                result.append(usModifiedCapitalLetter.charAt(usCapitalLetter.indexOf(text.charAt(i))));
            } else if (modifiedSymbols.indexOf(text.charAt(i)) != -1) {
                result.append(modifiedSymbols.charAt(symbols.indexOf(text.charAt(i))));
            } else {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (uaModifiedSmallLetter.indexOf(text.charAt(i)) != -1) {
                result.append(uaSmallLetter.charAt(uaModifiedSmallLetter.indexOf(text.charAt(i))));
            } else if (uaModifiedCapitalLetter.indexOf(text.charAt(i)) != -1) {
                result.append(uaCapitalLetter.charAt(uaModifiedCapitalLetter.indexOf(text.charAt(i))));
            } else if (usModifiedSmallLetter.indexOf(text.charAt(i)) != -1) {
                result.append(usSmallLetter.charAt(usModifiedSmallLetter.indexOf(text.charAt(i))));
            } else if (usCapitalLetter.indexOf(text.charAt(i)) != -1) {
                result.append(usCapitalLetter.charAt(usModifiedCapitalLetter.indexOf(text.charAt(i))));
            } else if (modifiedSymbols.indexOf(text.charAt(i)) != -1) {
                result.append(symbols.charAt(modifiedSymbols.indexOf(text.charAt(i))));
            } else {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

}



