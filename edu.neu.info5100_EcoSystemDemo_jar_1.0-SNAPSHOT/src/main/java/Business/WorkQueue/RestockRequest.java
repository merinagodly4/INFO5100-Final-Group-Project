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
public class RestockRequest {
  private String restockItems;
    private boolean approval = false;
    private UserAccount approvedBy;
    
    

    public String getTestResult() {
        return restockItems;
    }

    public void setTestResult(String restockItems) {
        this.restockItems = restockItems;
    }        
}
