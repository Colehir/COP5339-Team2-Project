package AddProduct;
import ProductList.ProductList;
public class AddProductModel {
    /**
     * validates entered information, makes sure everything is valid
     * @param s
     * @param d
     * @param i
     * @param pl
     * @return 
     */
    public String validateInfo(String s, Double d, Integer i) {
        if(d >= 0)
        {
            if(i >= 0)
            {
                System.out.println("All good");
                return "All Good";
            }
            else
            {
                System.out.println("Error detected");
                return "Error";
            }
        }
        else
        {
            System.out.println("Error detected");
            return "Error";
        }
    }
    String checkTypes(String name, String price, String stock) {
        int pricevalue = 0;
        int stockvalue = 0;
        try { 
                 Double.parseDouble(price); 
                  pricevalue = 1;
            } catch(NumberFormatException e) {
               pricevalue = 0;
                 
             
             } catch(NullPointerException e) {
                 pricevalue = 0;
                 
             }
        try { 
                 Integer.parseInt(stock); 
                  stockvalue = 1;
            } catch(NumberFormatException e) {
                stockvalue = 0;
                 
             } catch(NullPointerException e) {
                 stockvalue = 0;
                 
             }
        if(pricevalue == 1 && stockvalue == 1)
        {
            System.out.println("value success");
            return "yes";
        }
        else
        {
            System.out.println("value error");
            return "no";
        } 
    }  
}
 