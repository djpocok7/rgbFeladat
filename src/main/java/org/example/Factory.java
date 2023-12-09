package org.example;

import java.util.List;

public class Factory {

    public static void rgbProfileArrayGenerator(List<String> input, RGBProfile[][] picture){
        //SOR: 2 dimenziós tömbünknek a .length
        //OSZLOP: 2 dimenziós tömbünknek a [0].length
        for (int i = 0; i < picture.length; i++) {
            String[] splitted = input.get(i).split(" ");
            for (int j = 0; j < picture[0].length; j++) {
                Integer red = Integer.parseInt(splitted[j*3+0]);
                Integer green = Integer.parseInt(splitted[j*3+1]);
                Integer blue = Integer.parseInt(splitted[j*3+2]);
                RGBProfile onePixel = new RGBProfile(red, green, blue);
                picture[i][j] = onePixel;
            }
        }
    }

}
