package AuctionPriceCalculator;


import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Request> requests = RequestsInput.input();
        ArrayList<Request> buyRequests = new ArrayList<>();
        ArrayList<Request> sellRequests = new ArrayList<>();
        for(Request a : requests){
            if(a.getType()=='B')buyRequests.add(a);
            if(a.getType()=='S')sellRequests.add(a);
        }
        PriceCalc priceCalc = new PriceCalc(requests);
        MaxPriceAndAmount maxPriceAndAmount = priceCalc.maxDeals(buyRequests,sellRequests);
        if(maxPriceAndAmount.getQuantity()==0)
            System.out.print("Auction failed");
        else
            System.out.print(maxPriceAndAmount.getQuantity()+" "+maxPriceAndAmount.getPrice());

    }
}