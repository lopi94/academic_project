
package pl.polsl.java.lab.project.numbersconversion.Calculations;

import java.util.Vector;

/**
 * Class responsible for conversion number
 * @author Julia Kubieniec
 * @version 1.1
 */
public class Conversion {
    
    /** result variable will store the Roman number */
    private String result;
    /** vectorResult variable will store intermediate result of conversion*/
    private Vector<String> vectorResult = new Vector<String>();
    /** Roman numerals board */
    private final String[] roman = {"M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    /** Roman numerals collection */
    private Vector<String> vectorRoman = new Vector<String>();
    /** Arabic numerals board */
    private final Integer[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    /** Arabic numerals collection */
    private Vector<Integer> vectorArabic = new Vector<Integer>();
    
    /** method converts Arabic number to Roman
     * @param number - Arabic number
     * @return result - Roman number */
    public String arabicToRoman(int number) {

        result = "";
        for(String tmpRoman : roman) {
            vectorRoman.add(tmpRoman);
        }
        
        for(Integer tmpArabic : arabic){
            vectorArabic.add(tmpArabic);
        }

        for (int i = 0; i < vectorArabic.size(); i++) {
            while (number >= vectorArabic.get(i)) {
                vectorResult.add(vectorRoman.get(i));
                number -= vectorArabic.get(i);
            }
        }

        vectorResult.forEach(x -> result += x);

        return result;
   }
   
}