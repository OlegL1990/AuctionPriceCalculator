package AuctionPriceCalculator;

import java.util.ArrayList;

public class PriceCalc {

    ArrayList<Request> requests;

    PriceCalc(ArrayList<Request> requests){
        this.requests = requests;
    }
    ArrayList<Float> prices = new ArrayList<>();

    public ArrayList<Float> getPrices(ArrayList<Request> requests){
        for(Request r:requests)
            prices.add(r.getPrice());
        return prices;
    }

    public MaxPriceAndAmount maxDeals(ArrayList<Request> buyRequests, ArrayList<Request> sellRequests){
       prices = getPrices(requests) ;
       int max = 0;
       ArrayList<Float> goodPrices = new ArrayList<>();
       MaxPriceAndAmount maxPriceAndAmount = new MaxPriceAndAmount();
       for(Float price:prices){
           int buyAmount=0;
           int sellAmount=0;
           for(Request b:buyRequests){
               if(b.getPrice()>=price)buyAmount =buyAmount+b.getQuantity();
           }
           for(Request s:sellRequests){
               if(s.getPrice()<=price)sellAmount =sellAmount+s.getQuantity();
           }
           int numberOfDeals = Math.min(buyAmount,sellAmount);
           if(numberOfDeals>max){
               max=numberOfDeals;
               maxPriceAndAmount.setQuantity(max);
               goodPrices.clear();
               goodPrices.add(price);
           }
           else if(numberOfDeals==max){
               goodPrices.add(price);
           }
           float averagePrice=0;
           for(int i = 0;i<goodPrices.size();i++)
           {
               averagePrice +=goodPrices.get(i);
           }
           averagePrice /=goodPrices.size();
           maxPriceAndAmount.setPrice(averagePrice);


       }
       return maxPriceAndAmount;
    }



}
