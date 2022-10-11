package com.example.raycaster.Model.Resources.Map;

public final class Map {
    public static byte[][] floorH = new byte[128][128];
    public static byte[][] halfup = new byte[128][128];
    public static boolean[][] upperbuilding = new boolean[128][128];
    public static byte[][] map = new byte[128][128];
    public static byte[][] ceiling = new byte[128][128];
    public static byte[][] uppershape = new byte[128][128];

    public static boolean isNeighbourhood(int posX, int posY, int lposX, int lposY){

        boolean up = (posX == lposX - 1) && (posY == lposY);
        boolean center = (posX == lposX) && (posY == lposY-1 || posY == lposY || posY == lposY+1);
        boolean down = (posX == lposX + 1) && (posY == lposY);

        return !up && !center && !down;
    }

    public static void map(){
        for(int x=55;x<=75;x++){
            for(int y=55;y<75;y++){
                map[x][y] = 1;
                ceiling[x][y]=1;
            }
        }
        for(int x=56;x<=74;x++){
            for(int y=56;y<74;y++){
                map[x][y] = 0;

                ceiling[x][y]=0;
            }
        }


        for(int x=60;x<=66;x++){
            for(int y=60;y<67;y++){
                ceiling[x][y] = 1;

                if(y>63 && x<65) upperbuilding[x][y] = true;
            }
        }
        for(int x=61;x<=64;x++){
            for(int y=62;y<66;y++){
                ceiling[x][y] = 2;
            }
        }


        ceiling[64][67] = 1;
        halfup[64][67] = 1;
        map[64][67] = 5;

        floorH[66][68] = -1;
        floorH[65][68] = -1;
        floorH[64][68] = -1;
        floorH[63][68] = -1;
        floorH[62][68] = -1;
        floorH[61][68] = -1;
        floorH[59][68] = 1;

        map[59][67] = 4;
        ceiling[64][68] = 1;
        halfup[64][68] = 1;


        ceiling[64][69] = 1;
        halfup[64][69] = 1;
        map[64][69] = 11;


        ceiling[58][68] = 1;
        halfup[58][68] = 1;
        map[58][68] = 5;

        ceiling[58][69] = 1;
        halfup[58][69] = 1;
        map[58][69] = 1;

        upperbuilding[64][72] = true;
        ceiling[64][72] = 1;

        upperbuilding[65][72] = true;
        ceiling[65][72] = 1;

        upperbuilding[66][72] = true;
        ceiling[66][72] = 1;

        upperbuilding[66][71] = true;
        ceiling[66][71]=2;
        upperbuilding[66][70] = true;
        ceiling[66][70]=2;
        upperbuilding[66][69] = true;
        ceiling[66][69]=2;
        uppershape[66][69] = 1;
        map[66][69] = 11;

        upperbuilding[66][68] = true;
        ceiling[66][68]=2;

        halfup[64][70] = 1;
        ceiling[64][70] = 1;
        map[66][66] = 1;
        map[64][66] = 11;
        map[62][66] = 11;
        map[60][66] = 1;

        ceiling[63][62] = 1;
        map[63][62] = 1;
        map[65][64] = 3;
        map[65][61] = 3;

        map[67][62] = 3;

        map[66][65] = 1;
        map[66][64] = 1;
        map[66][62] = 1;
        map[66][61] = 2;
        map[66][60] = 1;

        map[63][64] = 1;

        map[64][60] = 1;
        map[62][60] = 1;
        map[61][60] = 1;
        map[60][60] = 1;

        map[60][65] = 1;
        map[60][64] = 1;
        map[60][63] = 1;
        map[60][62] = 1;
        map[60][61] = 1;

        map[63][63] = 4;
        map[62][62] = 8;
        map[61][62] = 9;
        map[61][63] = 10;
        map[60][67] = 10;

        map[62][70] = 1;
        map[61][70] = 4;
        map[63][70] = 4;
        map[64][70] = 4;

        map[60][68] = 12;
    }
}
