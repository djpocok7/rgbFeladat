package org.example;

import javax.swing.plaf.metal.MetalIconFactory;

public class Logic {

    public static void coordinatesRGB(RGBProfile[][] picture, Integer[] userInput){
        Integer row = userInput[0];
        Integer column = userInput[1];
        RGBProfile pixel = picture[row][column];
        //System.out.println("RGB("+pixel.getRed()+", "+pixel.getGreen()+", " + pixel.getBlue()+")");
        printfWriteOut(pixel);
    }

    public static Integer brightPixel(RGBProfile[][] picture){
        int cnt = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                Integer sum = sumPixelValues(picture[i][j]);
                if(sum > 600) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void equalWithDarkest(RGBProfile[][] picture){
        Integer darkestValue = darkestPixelsValue(picture);
        System.out.println(darkestValue + "\n");
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                Integer sum = sumPixelValues(picture[i][j]);
                if(sum == darkestValue){
                    printfWriteOut(picture[i][j]);
                }
            }
        }
    }

    public static void firstAndLastCloudRow(RGBProfile[][] picture){
        Integer[] cloudBorder = new Integer[picture.length];
        int n = 0;
        for (int i = 0; i < picture.length; i++) {
            if(hatar(picture,i,10)){
                cloudBorder[n] = i + 1;
                n++;
            }
        }

        int firstRow = cloudBorder[0];
        int lastRow = cloudBorder[n-1];

        System.out.println("A felhő felső határának a sora: " + firstRow);
        System.out.println("A felhő alsó határának a sora: " + lastRow);
    }

    private static Boolean hatar(RGBProfile[][] picture, Integer lineNum, Integer difference){
        for (int i = 0; i < picture[lineNum].length-1; i++) {
            Integer currentPixelsBlueValue = picture[lineNum][i].getBlue();
            Integer nextcellPixelsBlueValue = picture[lineNum][i+1].getBlue();
            if(Math.abs(currentPixelsBlueValue - nextcellPixelsBlueValue) > difference ){
                return true;
            }
        }
        return false;
    }
    private static Integer darkestPixelsValue(RGBProfile[][] picture) {
        int darkestValue = 255 + 255 + 255;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                Integer sum = sumPixelValues(picture[i][j]);
                if(sum < darkestValue) {
                    darkestValue = sum;
                }
            }
        }
        return darkestValue;
    }

    private static void printfWriteOut(RGBProfile onePixel){
        System.out.printf("RGB(%d,%d,%d)\n",onePixel.getRed(), onePixel.getGreen(), onePixel.getBlue());
    }

    private static Integer sumPixelValues(RGBProfile onePixel) {
        return onePixel.getRed() + onePixel.getGreen() + onePixel.getBlue();
    }
}
