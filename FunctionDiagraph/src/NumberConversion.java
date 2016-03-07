/**
 * Created by WangGuanyu on 16/3/1.
 */
//NumberConversion.java class for Numbering system conversion
import java.lang.*;
import javax.swing.JOptionPane;

public class NumberConversion {
    //private int FormFirst;
    //private int FormFinal;
    public String Conversion(String Origin, int FormFirst, int FormFinal) {
        String Result = new String();
        try {
            switch(FormFirst) {
                case 2 :
                    switch(FormFinal) {
                        case 2 :
                            Result = Origin;
                            break;
                        case 8 :
                            Result = Integer.toOctalString(Integer.parseInt(Origin, FormFirst));
                            break;
                        case 10 :
                            Result = Integer.valueOf(Origin, FormFirst).toString();
                            break;
                        case 16 :
                            Result = Integer.toHexString(Integer.parseInt(Origin, FormFirst));
                            break;
                    }
                    break;
                case 8 :
                    switch(FormFinal) {
                        case 2 :
                            Result = Integer.toBinaryString(Integer.valueOf(Origin, FormFirst));
                            break;
                        case 8 :
                            Result = Origin;
                            break;
                        case 10 :
                            Result = Integer.valueOf(Origin, FormFirst).toString();
                            break;
                        case 16 :
                            Result = Integer.toHexString(Integer.valueOf(Origin, FormFirst));
                            break;
                    }
                    break;
                case 10 :
                    switch(FormFinal) {
                        case 2 :
                            Result = Integer.toBinaryString(Integer.parseInt(Origin));
                            break;
                        case 8 :
                            Result =  Integer.toOctalString(Integer.parseInt(Origin));
                            break;
                        case 10 :
                            Result = Origin;
                            break;
                        case 16 :
                            Result = Integer.toHexString(Integer.parseInt(Origin));
                            break;
                    }
                    break;
                case 16 :
                    switch(FormFinal) {
                        case 2 :
                            Result = Integer.toBinaryString(Integer.valueOf(Origin,FormFirst));
                            break;
                        case 8 :
                            Result = Integer.toOctalString(Integer.valueOf(Origin,FormFirst));
                            break;
                        case 10 :
                            Result = Integer.valueOf(Origin,FormFirst).toString();
                            break;
                        case 16 :
                            Result = Origin;
                            break;
                    }
                    break;
            }
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong Input! Please enter again!");
        }

        return Result;
    }
}
