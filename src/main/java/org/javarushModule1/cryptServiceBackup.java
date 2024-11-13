package org.javarushModule1;

import java.util.HashMap;
import java.util.Map;

public class cryptServiceBackup {
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
    private String lang = "";
    public int langCheck(String text) {
        for (int i = 0; i < uaSmallLetter.length(); i++) {
            if (text.contains("" + uaSmallLetter.charAt(i))) {
                this.lang = "ua";
                return 0;
            }
        }
        for (int i = 0; i < uaCapitalLetter.length(); i++) {
            if (text.contains("" + uaCapitalLetter.charAt(i))) {
                this.lang = "ua";
                return 0;
            }
        }
        for (int i = 0; i < usSmallLetter.length(); i++) {
            if (text.contains("" + usSmallLetter.charAt(i))) {
                this.lang = "us";
                return 0;
            }
        }
        for (int i = 0; i < usCapitalLetter.length(); i++) {
            if (text.contains("" + usCapitalLetter.charAt(i))) {
                this.lang = "us";
                return 0;
            }
        }
        return -1;
    }
    public void modifiedStringWithSmallLetter(int key) {
        if (this.lang.equals("ua")) {
            int length = uaSmallLetter.length();
            int realKey = key % length;
            StringBuilder modifiedString = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int newIndex = (i + realKey) % length;
                modifiedString.append(uaSmallLetter.charAt(newIndex));
            }
            uaModifiedSmallLetter = modifiedString.toString();
        } else if (this.lang.equals("us")) {
            int length = usSmallLetter.length();
            int realKey = key % length;
            StringBuilder modifiedString = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int newIndex = (i + realKey) % length;
                modifiedString.append(usSmallLetter.charAt(newIndex));
            }
            usModifiedSmallLetter = modifiedString.toString();
        }
    }

    public void modifiedStringWithCapitalLetter(int key) {
        if (this.lang.equals("ua")) {
            int length = uaCapitalLetter.length();
            int realKey = key % length;
            StringBuilder modifiedString = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int newIndex = (i + realKey) % length;
                modifiedString.append(uaCapitalLetter.charAt(newIndex));
            }
            uaModifiedCapitalLetter = modifiedString.toString();
        } else if (this.lang.equals("us")) {
            int length = usCapitalLetter.length();
            int realKey = key % length;
            StringBuilder modifiedString = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int newIndex = (i + realKey) % length;
                modifiedString.append(usCapitalLetter.charAt(newIndex));
            }
            usModifiedCapitalLetter = modifiedString.toString();
        }
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
        if (this.lang.equals("ua")) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.isLetter(text.charAt(i))){
                    if(Character.isUpperCase(text.charAt(i))){
                        int index = uaCapitalLetter.indexOf(text.charAt(i));
                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(uaModifiedCapitalLetter.charAt(index));
                        }
                    }
                    else if (Character.isLowerCase(text.charAt(i))){
                        int index = uaSmallLetter.indexOf(text.charAt(i));
                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(uaModifiedSmallLetter.charAt(index));
                        }
                    }
                } else {
                    int index = symbols.indexOf(text.charAt(i));
                    if (index == -1){
                        result.append(text.charAt(i));
                    }
                    else {
                        result.append(modifiedSymbols.charAt(index));
                    }
                }
            }
        }
        else if (this.lang.equals("us")) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.isAlphabetic(text.charAt(i))){
                    if(Character.isUpperCase(text.charAt(i))){
                        int index = usCapitalLetter.indexOf(text.charAt(i));

                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(usModifiedCapitalLetter.charAt(index));
                        }
                    }
                    else if (Character.isLowerCase(text.charAt(i))){
                        int index = usSmallLetter.indexOf(text.charAt(i));
                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(usModifiedSmallLetter.charAt(index));
                        }

                    }
                }
                else {
                    int indexSymbol = symbols.indexOf(text.charAt(i));
                    if (indexSymbol == -1){
                        result.append(text.charAt(i));
                    }
                    else {
                        result.append(modifiedSymbols.charAt(indexSymbol));
                    }
                }
            }
        }
        else {

        }

        return result.toString();
    }
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        if (this.lang.equals("ua")) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.isAlphabetic(text.charAt(i))){
                    if(Character.isUpperCase(text.charAt(i))){
                        int index = uaModifiedCapitalLetter.indexOf(text.charAt(i));
                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(uaCapitalLetter.charAt(index));
                        }
                    }
                    else if (Character.isLowerCase(text.charAt(i))){
                        int index = uaModifiedSmallLetter.indexOf(text.charAt(i));
                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(uaSmallLetter.charAt(index));
                        }
                    }
                }
                else {
                    int index = modifiedSymbols.indexOf(text.charAt(i));
                    if(index == -1){
                        result.append(text.charAt(i));
                    }
                    else {
                        result.append(symbols.charAt(index));
                    }
                }
            }
        }
        else if (this.lang.equals("us")) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.isAlphabetic(text.charAt(i))){
                    if(Character.isUpperCase(text.charAt(i))){
                        int index = usModifiedCapitalLetter.indexOf(text.charAt(i));

                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(usCapitalLetter.charAt(index));
                        }
                    }
                    else if (Character.isLowerCase(text.charAt(i))){
                        int index = usModifiedSmallLetter.indexOf(text.charAt(i));
                        if(index == -1){
                            result.append(text.charAt(i));
                        }
                        else {
                            result.append(usSmallLetter.charAt(index));
                        }

                    }
                }
                else {
                    int index = modifiedSymbols.indexOf(text.charAt(i));
                    if(index == -1){
                        result.append(text.charAt(i));
                    }
                    else {
                        result.append(symbols.charAt(index));
                    }
                }
            }
        }
        else {

        }
        return result.toString();
    }

    public Map<Integer,String> brute_force(String text) {
        Map<Integer,String> result = new HashMap<>();

        return result;
    }
}



