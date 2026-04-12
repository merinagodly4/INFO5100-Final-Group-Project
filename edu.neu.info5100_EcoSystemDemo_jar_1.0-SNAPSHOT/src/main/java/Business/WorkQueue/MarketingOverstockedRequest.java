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
public class MarketingOverstockedRequest extends WorkRequest {
   private String marketingOverstocked;
    private boolean approval = false;
    private UserAccount approvedBy;
    
    

    public String getTestResult() {
        return marketingOverstocked;
    }

    public void setTestResult(String marketingOverstocked) {
        this.marketingOverstocked = marketingOverstocked;
    }  
    
    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public UserAccount getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(UserAccount approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String toString() {
        return marketingOverstocked;
    }
}
