package AuctionPriceCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RequestsInput {
   public static ArrayList<Request> getInput()throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        ArrayList<Request> requests = new ArrayList<>();
        while (true){
            input = reader.readLine();
            if(input.equals("End"))break;
            String[] s =  input.split(" ");
            if(Integer.parseInt(s[1])>1000)s[1]="1000";
            if(Integer.parseInt(s[1])<1)s[1]="1";
            if(Float.parseFloat(s[2])>100)s[2] = "100";
            if(Float.parseFloat(s[2])<1)s[2] = "1";

            requests.add(new Request(s[0].charAt(0),Integer.parseInt(s[1]),Float.parseFloat(s[2])));
            }
        return requests;
        }
    }
