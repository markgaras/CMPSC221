// This is unused, but was kept for future convenience!

package cartMethods;

/*
 * CMPSCI 221 MVC Lab
 * shoppingCart.java
 * Purpose: To get shopping cart inputs, and display cost and user information.
 *  
 * @author Mark Garas  
 * @version 1.0 4/10/2021
 */ 

public class shoppingCart {
    String fname = "";
    String lname = "";
    String street = "";
    String county = "";
    String state = "";
    String zip = "";
    String credit = "";
    String month = "";
    String day = "";
    String year = "";
    String code = "";
    double totalBeforeTax;
    final double TAX_PERCENT = .06;
    final double SHIPPING_AND_HANDLING = .1;
    
    public void getUserInfo(String fnm, String lnm, String strt, String cnty, 
            String stt, String zp, String crdt, String mnth, String dy, 
            String yr, String cd){
        fname = fnm;
        lname = lnm;
        street = strt;
        county = cnty;
        state = stt;
        zip = zp;
        credit = crdt;
        month = mnth;
        day = dy;
        year = yr;
        code = cd;
    }
    
    public void getUserCart(Boolean id1, Boolean id2, Boolean id3) {
        
    }
}

// See line 1