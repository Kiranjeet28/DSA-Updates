// 1. Password Validator
// Determine if a given String is a valid password based on its length.Dictionaries & Encyclopedias

// Input: A String
// Output: "Valid" if length is between 20 and 40 characters, else "Invalid"
import java.util.Scanner;
class Solution{
    public static void checkString(String s){
        if(s.length() >=20 && s.length() <= 40){
            System.out.println("Valid");
        }else System.out.println("Invalid");
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String st = s.nextLine();
        checkString(st);
    }
}