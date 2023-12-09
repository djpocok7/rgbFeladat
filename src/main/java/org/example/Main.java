package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        RGBProfile[][] picture = new RGBProfile[360][640];

        try{
            File myFile = new File("kep.txt");
            Scanner myScanner = new Scanner(myFile);
            while(myScanner.hasNextLine()){
                String line = myScanner.nextLine();
                input.add(line);
            }
            Factory.rgbProfileArrayGenerator(input,picture);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
            Logic.coordinatesRGB(picture, userInput());
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("A képen ennyi világos képpont van: " + Logic.brightPixel(picture));
        System.out.print("A legsötétebb képpont: ");
        Logic.equalWithDarkest(picture);
        Logic.firstAndLastCloudRow(picture);
    }

    private static Integer[] userInput() throws WrongInputException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Kérlek add meg a sorszámot!");
        Integer row = Integer.parseInt(myScanner.nextLine());
        System.out.println("Kérlek add meg az oszlopszámot!");
        Integer column = Integer.parseInt(myScanner.nextLine());
        if(row > 360 || row < 1){
            throw new WrongInputException("Hibás sorszám (1-360) - kapott: " + row );
        }
        if(column > 640 || column < 1){
            throw new WrongInputException("Hibás oszlopszám (1-640) - kapott: " + column );
        }

        Integer[] userInputArray = new Integer[2];
        userInputArray[0] = row;
        userInputArray[1] = column;
        return userInputArray;
    }

}