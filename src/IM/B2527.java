package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2527 {
    private static class Rectangle{
        int leftX, leftY;
        int rightX, rightY;

        public Rectangle(int leftX, int leftY, int rightX, int rightY) {
            this.leftX = leftX;
            this.leftY = leftY;
            this.rightX = rightX;
            this.rightY = rightY;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int t = 0; t < 4; t++){
            st = new StringTokenizer(br.readLine());
            Rectangle r1 = new Rectangle(Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken()));
            Rectangle r2 = new Rectangle(Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken()));


        }
    }
}
