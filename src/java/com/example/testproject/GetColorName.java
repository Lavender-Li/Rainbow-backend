package com.example.testproject;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class GetColorName {
    private static boolean flag = false;

    /** Initialize color list */
    /** data from: https://xkcd.com/color/rgb.txt */

    public static HashMap<String, String> ColorName = new HashMap<String, String>();
    static {
        ColorName.put("F0F8FF", "AliceBlue");
        ColorName.put("FAEBD7", "AntiqueWhite");
//        ColorName.put("00FFFF", "Aqua");
        ColorName.put("7FFFD4", "Aquamarine");
        ColorName.put("F0FFFF", "Azure");
        ColorName.put("F5F5DC", "Beige");
        ColorName.put("FFE4C4", "Bisque");
        ColorName.put("000000", "Black");
        ColorName.put("FFEBCD", "BlanchedAlmond");
        ColorName.put("0000FF", "Blue");
        ColorName.put("8A2BE2", "BlueViolet");
        ColorName.put("A52A2A", "Brown");
        ColorName.put("DEB887", "BurlyWood");
        ColorName.put("CA9BF7", "BabyPurple");
        ColorName.put("5F9EA0", "CadetBlue");
        ColorName.put("7FFF00", "Chartreuse");
        ColorName.put("D2691E", "Chocolate");
        ColorName.put("FF7F50", "Coral");
        ColorName.put("6495ED", "CornflowerBlue");
        ColorName.put("FFF8DC", "Cornsilk");
        ColorName.put("DC143C", "Crimson");
        ColorName.put("00FFFF", "Cyan");
        ColorName.put("00008B", "DarkBlue");
        ColorName.put("008B8B", "DarkCyan");
        ColorName.put("B8860B", "DarkGoldenRod");
        ColorName.put("A9A9A9", "DarkGray");
        ColorName.put("006400", "DarkGreen");
        ColorName.put("BDB76B", "DarkKhaki");
        ColorName.put("8B008B", "DarkMagenta");
        ColorName.put("556B2F", "DarkOliveGreen");
        ColorName.put("FF8C00", "DarkOrange");
        ColorName.put("9932CC", "DarkOrchid");
        ColorName.put("8B0000", "DarkRed");
        ColorName.put("E9967A", "DarkSalmon");
        ColorName.put("8FBC8F", "DarkSeaGreen");
        ColorName.put("483D8B", "DarkSlateBlue");
        ColorName.put("2F4F4F", "DarkSlateGray");
        ColorName.put("00CED1", "DarkTurquoise");
        ColorName.put("9400D3", "DarkViolet");
        ColorName.put("FF1493", "DeepPink");
        ColorName.put("00BFFF", "DeepSkyBlue");
        ColorName.put("696969", "DimGray");
        ColorName.put("1E90FF", "DodgerBlue");
        ColorName.put("B22222", "FireBrick");
        ColorName.put("FFFAF0", "FloralWhite");
        ColorName.put("228B22", "ForestGreen");
//        ColorName.put("FF00FF", "Fuchsia");
        ColorName.put("DCDCDC", "Gainsboro");
        ColorName.put("F8F8FF", "GhostWhite");
        ColorName.put("FFD700", "Gold");
        ColorName.put("DAA520", "GoldenRod");
        ColorName.put("808080", "Gray");
        ColorName.put("008000", "Green");
        ColorName.put("ADFF2F", "GreenYellow");
        ColorName.put("F0FFF0", "HoneyDew");
        ColorName.put("FF69B4", "HotPink");
        ColorName.put("CD5C5C", "IndianRed");
        ColorName.put("4B0082", "Indigo");
        ColorName.put("FFFFF0", "Ivory");
        ColorName.put("F0E68C", "Khaki");
        ColorName.put("E6E6FA", "Lavender");
        ColorName.put("FFF0F5", "LavenderBlush");
        ColorName.put("7CFC00", "LawnGreen");
        ColorName.put("FFFACD", "LemonChiffon");
        ColorName.put("ADD8E6", "LightBlue");
        ColorName.put("F08080", "LightCoral");
        ColorName.put("E0FFFF", "LightCyan");
        ColorName.put("FAFAD2", "LightGoldenRodYellow");
        ColorName.put("D3D3D3", "LightGray");
        ColorName.put("90EE90", "LightGreen");
        ColorName.put("FFB6C1", "LightPink");
        ColorName.put("BF77F6", "LightPurple");
        ColorName.put("F6CEFC", "LightPurpleyPink");
        ColorName.put("FFA07A", "LightSalmon");
        ColorName.put("20B2AA", "LightSeaGreen");
        ColorName.put("87CEFA", "LightSkyBlue");
        ColorName.put("778899", "LightSlateGray");
        ColorName.put("B0C4DE", "LightSteelBlue");
        ColorName.put("FFFFE0", "LightYellow");
        ColorName.put("00FF00", "Lime");
        ColorName.put("32CD32", "LimeGreen");
        ColorName.put("FAF0E6", "Linen");
        ColorName.put("FF00FF", "Magenta");
        ColorName.put("800000", "Maroon");
        ColorName.put("66CDAA", "MediumAquaMarine");
        ColorName.put("0000CD", "MediumBlue");
        ColorName.put("BA55D3", "MediumOrchid");
        ColorName.put("9370DB", "MediumPurple");
        ColorName.put("3CB371", "MediumSeaGreen");
        ColorName.put("7B68EE", "MediumSlateBlue");
        ColorName.put("00FA9A", "MediumSpringGreen");
        ColorName.put("48D1CC", "MediumTurquoise");
        ColorName.put("C71585", "MediumVioletRed");
        ColorName.put("191970", "MidnightBlue");
        ColorName.put("F5FFFA", "MintCream");
        ColorName.put("FFE4E1", "MistyRose");
        ColorName.put("FFE4B5", "Moccasin");
        ColorName.put("FFDEAD", "NavajoWhite");
        ColorName.put("000080", "Navy");
        ColorName.put("FDF5E6", "OldLace");
        ColorName.put("808000", "Olive");
        ColorName.put("6B8E23", "OliveDrab");
        ColorName.put("FFA500", "Orange");
        ColorName.put("FF4500", "OrangeRed");
        ColorName.put("DA70D6", "Orchid");
        ColorName.put("EEE8AA", "PaleGoldenRod");
        ColorName.put("98FB98", "PaleGreen");
        ColorName.put("AFEEEE", "PaleTurquoise");
        ColorName.put("DB7093", "PaleVioletRed");
        ColorName.put("FFEFD5", "PapayaWhip");
        ColorName.put("CAA0FF", "PastelPurple");
        ColorName.put("FFDAB9", "PeachPuff");
        ColorName.put("CD853F", "Peru");
        ColorName.put("FFC0CB", "Pink");
        ColorName.put("DDA0DD", "Plum");
        ColorName.put("B0E0E6", "PowderBlue");
        ColorName.put("800080", "Purple");
        ColorName.put("8756E4", "Purpley");
        ColorName.put("947E94", "PurpleyGrey");
        ColorName.put("FF0000", "Red");
        ColorName.put("BC8F8F", "RosyBrown");
        ColorName.put("4169E1", "RoyalBlue");
        ColorName.put("8B4513", "SaddleBrown");
        ColorName.put("FA8072", "Salmon");
        ColorName.put("F4A460", "SandyBrown");
        ColorName.put("2E8B57", "SeaGreen");
        ColorName.put("FFF5EE", "SeaShell");
        ColorName.put("A0522D", "Sienna");
        ColorName.put("C0C0C0", "Silver");
        ColorName.put("87CEEB", "SkyBlue");
        ColorName.put("6A5ACD", "SlateBlue");
        ColorName.put("708090", "SlateGray");
        ColorName.put("FFFAFA", "Snow");
        ColorName.put("00FF7F", "SpringGreen");
        ColorName.put("4682B4", "SteelBlue");
        ColorName.put("D2B48C", "Tan");
        ColorName.put("008080", "Teal");
        ColorName.put("D8BFD8", "Thistle");
        ColorName.put("FF6347", "Tomato");
        ColorName.put("40E0D0", "Turquoise");
        ColorName.put("EE82EE", "VioletPink");
        ColorName.put("9900FA", "VividPurple");
        ColorName.put("F5DEB3", "Wheat");
        ColorName.put("FFFFFF", "White");
        ColorName.put("F5F5F5", "WhiteSmoke");
        ColorName.put("FFFF00", "Yellow");
        ColorName.put("9ACD32", "YellowGreen");
    }

    public static String getColorFromRGB(int r, int g, int b) {
        String RGBHex = Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        RGBHex = RGBHex.toUpperCase(Locale.ROOT);
        if (ColorName.containsKey(RGBHex)) {
            return ColorName.get(RGBHex);
        } else {
            return getNearestColor(r, g, b);
        }
    }

    public static String getNearestColor(int r, int g, int b) {
        String chosenKey = null;
        double minDistance = 0.0;
        boolean flag = false;
        for (String getKey: ColorName.keySet()) {
            int key_r = convertUpperHextoInt(getKey.substring(0,2));
            int key_g = convertUpperHextoInt(getKey.substring(2,4));
            int key_b = convertUpperHextoInt(getKey.substring(4,6));
            double distance = ColorDistance(r, g, b, key_r, key_g, key_b);
            if (!flag) { // the first distance calculated
                minDistance = distance;
                chosenKey = getKey;
                flag = true;
            } else {
                if (distance < minDistance) {
                    minDistance = distance;
                    chosenKey = getKey;
                }
            }
        }
        return ColorName.get(chosenKey);
    }

    /** Reference: http://www.easyrgb.com/en/math.php */
    public static double ColorDistance(int R1, int G1, int B1, int R2, int G2, int B2) {
        // convert sRGB to XYZ
        double var_R1 = R1 / 255.0;
        double var_G1 = G1 / 255.0;
        double var_B1 = B1 / 255.0;
        double var_R2 = R2 / 255.0;
        double var_G2 = G2 / 255.0;
        double var_B2 = B2 / 255.0;
        if (var_R1 > 0.04045) var_R1 = Math.pow((var_R1 + 0.055) / 1.055, 2.4);
        else                  var_R1 = var_R1 / 12.92;
        if (var_G1 > 0.04045) var_G1 = Math.pow(( var_G1 + 0.055) / 1.055, 2.4);
        else                  var_G1 = var_G1 / 12.92;
        if (var_B1 > 0.04045) var_B1 = Math.pow((var_B1 + 0.055) / 1.055, 2.4);
        else                  var_B1 = var_B1 / 12.92;
        if (var_R2 > 0.04045) var_R2 = Math.pow((var_R2 + 0.055) / 1.055, 2.4);
        else                  var_R2 = var_R2 / 12.92;
        if (var_G2 > 0.04045) var_G2 = Math.pow(( var_G2 + 0.055) / 1.055, 2.4);
        else                  var_G2 = var_G2 / 12.92;
        if (var_B2 > 0.04045) var_B2 = Math.pow((var_B2 + 0.055) / 1.055, 2.4);
        else                  var_B2 = var_B2 / 12.92;
        var_R1 = var_R1 * 100;
        var_G1 = var_G1 * 100;
        var_B1 = var_B1 * 100;
        var_R2 = var_R2 * 100;
        var_G2 = var_G2 * 100;
        var_B2 = var_B2 * 100;
        double X1 = var_R1 * 0.4124 + var_G1 * 0.3576 + var_B1 * 0.1805;
        double Y1 = var_R1 * 0.2126 + var_G1 * 0.7152 + var_B1 * 0.0722;
        double Z1 = var_R1 * 0.0193 + var_G1 * 0.1192 + var_B1 * 0.9505;
        double X2 = var_R2 * 0.4124 + var_G2 * 0.3576 + var_B2 * 0.1805;
        double Y2 = var_R2 * 0.2126 + var_G2 * 0.7152 + var_B2 * 0.0722;
        double Z2 = var_R2 * 0.0193 + var_G2 * 0.1192 + var_B2 * 0.9505;
        if (!flag) {
            Log.i("Camera", "X: " + String.valueOf(X1) + ", Y: " + String.valueOf(Y1)
                    + ", Z: " + String.valueOf(Z1));
        }
        // convert XYZ to LAB
        double referenceX = 94.791;
        double referenceY = 100.0;
        double referenceZ = 103.191;
        double var_X1 = X1 / referenceX;
        double var_Y1 = Y1 / referenceY;
        double var_Z1 = Z1 / referenceZ;
        double var_X2 = X2 / referenceX;
        double var_Y2 = Y2 / referenceY;
        double var_Z2 = Z2 / referenceZ;
        if (var_X1 > 0.008856) var_X1 = Math.pow(var_X1, 1.0 / 3);
        else                   var_X1 = 7.787 * var_X1 + 16.0 / 116;
        if (var_Y1 > 0.008856) var_Y1 = Math.pow(var_Y1, 1.0 / 3);
        else                   var_Y1 = 7.787 * var_Y1 + 16.0 / 116;
        if (var_Z1 > 0.008856) var_Z1 = Math.pow(var_Z1, 1.0 / 3);
        else                   var_Z1 = 7.787 * var_Z1 + 16.0 / 116;
        if (var_X2 > 0.008856) var_X2 = Math.pow(var_X2, 1.0 / 3);
        else                   var_X2 = 7.787 * var_X2 + 16.0 / 116;
        if (var_Y2 > 0.008856) var_Y2 = Math.pow(var_Y2, 1.0 / 3);
        else                   var_Y2 = 7.787 * var_Y2 + 16.0 / 116;
        if (var_Z2 > 0.008856) var_Z2 = Math.pow(var_Z2, 1.0 / 3);
        else                   var_Z2 = 7.787 * var_Z2 + 16.0 / 116;
        double L1 = 116 * var_Y1 - 16;
        double a1 = 500 * (var_X1 - var_Y1);
        double b1 = 200 * (var_Y1 - var_Z1);
        double L2 = 116 * var_Y2 - 16;
        double a2 = 500 * (var_X2 - var_Y2);
        double b2 = 200 * (var_Y2 - var_Z2);
        if (!flag) {
            Log.i("Camera", "L: " + String.valueOf(L1) + ", a: " + String.valueOf(a1)
                    + ", b: " + String.valueOf(b1));
            flag = true;
        }
        // Calculate distance between two Lab colors
        // reference: https://en.wikipedia.org/wiki/Color_difference#CIE94
        double WhtL = 1.0;
        double WhtC = 1.0;
        double WhtH = 1.0;
        double xDL = L1 - L2;
        double xC1 = Math.pow(a1 * a1 + b1 * b1 , 0.5);
        double xC2 = Math.pow(a2 * a2 + b2 * b2 , 0.5);
        double xDC = xC1 - xC2;
//        double xDE = Math.pow(Math.pow(L1 - L2, 2) + Math.pow(a1 - a2, 2) + Math.pow(b1 - b2, 2) , 0.5);
//        double xDH = xDE * xDE - xDL * xDL - xDC * xDC;
        double xDH = Math.pow(Math.pow(a1 - a2, 2) + Math.pow(b1 - b2, 2) - Math.pow(xDC, 2), 0.5);
//        if ( xDH > 0 ) {
//            xDH = Math.pow(xDH, 0.5);
//        } else {
//            xDH = 0;
//        }
        double xSC = 1 + 0.045 * xC1;
        double xSH = 1 + 0.015 * xC1;
        xDL /= WhtL;
        xDC /= WhtC * xSC;
        xDH /= WhtH * xSH;
        double distance = Math.pow(xDL * xDL + xDC * xDC + xDH * xDH, 0.5);
        return distance;
    }

    /** In the hashmap database, the color is provided in form like "FFFFFF".
     * Thus, we need to divide the String into 3 parts and convert them like: FF -> ff -> 255*/
    private static int convertUpperHextoInt(String x) {
        x = x.toLowerCase(Locale.ROOT);
        return Integer.parseInt(x,16);
    }
}
