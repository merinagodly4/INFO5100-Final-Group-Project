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
public class StoreManagerToStoreARestockRequest extends WorkRequest {
    
  private String restockItemsToStoreAssistants;
    private boolean approval = false;
    private UserAccount approvedBy;
    
    

    public String getTestResult() {
        return restockItemsToStoreAssistants;
    }

    public void setTestResult(String restockItemsToStoreAssistants) {
        this.restockItemsToStoreAssistants = restockItemsToStoreAssistants;
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
        return restockItemsToStoreAssistants;
    }
}


