package com.example.rayx.View;

public class ByteMatrix {

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;

    public static final int pixelWidth = 4;
    public static final int shiftPixelWidth = 2;
    public static final int maxLen = 960000 << shiftPixelWidth>>1;

    public static int lenScreen = (SCREEN_WIDTH*SCREEN_HEIGHT) << shiftPixelWidth;
    public static byte[] pixels = new byte[lenScreen];
    public static byte[] pixelss = new byte[lenScreen];

    private static byte fullByte = (byte) 255;
    protected ByteMatrix(){

    }

    public static void init(){

    }
    public static void clearMatrix(){
        pixels = new byte[lenScreen];

    }
    public static void setPixel(int pos, int rgb){


            pixels[pos] = (byte)((rgb & 0xFF));
            pixels[pos + 1] = (byte)((rgb & 0x00FF00) >> 8);
            pixels[pos + 2] = (byte)((rgb & 0xFF0000) >> 16);
            pixels[pos + 3] = fullByte;
    }

    public static int getPixel(int pos){
        if(pos>0 && pos < maxLen) {

            return  ((pixels[pos]) << 16) | ((pixels[pos + 1]) << 8) | (pixels[pos+2]);
        }else{
            return 0;
        }
    }


    public static boolean isEmpty(int pos){
        return pixels[pos+2]==0 && pixels[pos+1]==0 && pixels[pos] == 0;
    }



}
