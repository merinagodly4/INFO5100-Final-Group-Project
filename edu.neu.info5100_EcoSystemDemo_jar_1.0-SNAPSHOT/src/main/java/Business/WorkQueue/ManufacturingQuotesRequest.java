/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author raunak
 */
public class ManufacturingQuotesRequest extends WorkRequest{
    
    private String manufacturingQuote;
    private boolean approval = false;
    private UserAccount approvedBy;
    
    

    public String getTestResult() {
        return manufacturingQuote;
    }

    public void setTestResult(String manufacturingQuote) {
        this.manufacturingQuote = manufacturingQuote;
    }
    
    
}
