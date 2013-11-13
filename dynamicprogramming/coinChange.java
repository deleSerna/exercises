/**
 Given a value N, if we want to make change for N cents,
 and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 What will be the min no of coins required and which are those coins
*/
public class coinChange{

        static String makeChange(int amount, int v[]){
                int min = 0;
                int cost[] = new int [amount + 1] ;
                String coins= "";
                java.util.HashMap<String,String> coinMap = new java.util.HashMap<String,String>();
                for(int i = 0;i < cost.length;i++)
                        cost[i] = Integer.MAX_VALUE - 1;
                cost[0] = 0;
                coinMap.put("0",""); // 0 is not possible using any of the denomination set
                for(int i = 1; i<= amount;i++){
                        for(int j = 0;j< v.length;j++){
                                if( (i >= v[j]) && (cost[i] > (cost[i - v[j]] + 1)) ){
                                        cost[i] = cost[i- v[j]] + 1;
                                        coins = coinMap.get(String.valueOf(i- v[j]));
                                        if(coins == null){
                                                coins = "";
                                        }
                                        coins = coins+","+v[j];
                                        coinMap.put(String.valueOf(i),coins);
                                       
                                }
                        }        
                }
                String retStmt = "" + cost[amount];
                if(coinMap.get(String.valueOf(amount)) == null)
                        retStmt = retStmt;
                else
                        retStmt = retStmt + ":" + coinMap.get(String.valueOf(amount));        
                return retStmt;
        }

        public static void main(String[] args){
                int v[] = {5,10,20,25};
                java.util.Scanner inp = new java.util.Scanner(System.in);
                System.out.println("Enter the amount");
                int amount = inp.nextInt();
                 String min = makeChange(amount,v);
                String [] minVal = min.split(":");
                System.out.println("MIn is" +min);
                if ( Integer.parseInt(minVal[0]) == Integer.MAX_VALUE - 1)
                        System.out.println("Min coin need for "+ amount+" is not possible using this denomimantion set");
                else
                        System.out.println("Min coin need for "+ amount+" is "+minVal[0] + " and coins are" + minVal[1]);

        }
}

