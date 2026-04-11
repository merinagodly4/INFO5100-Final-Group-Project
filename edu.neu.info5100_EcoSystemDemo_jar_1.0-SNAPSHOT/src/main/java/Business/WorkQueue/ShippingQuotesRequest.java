/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;
import Business.UserAccount.UserAccount;
/**
 *
 * @author lajon
 */
public class ShippingQuotesRequest {
  private String shippingQuotes;
    private boolean approval = false;
    private UserAccount approvedBy;
    
    

    public String getTestResult() {
        return shippingQuotes;
    }

    public void setTestResult(String shippingQuotes) {
        this.shippingQuotes = shippingQuotes;
    }  
}
