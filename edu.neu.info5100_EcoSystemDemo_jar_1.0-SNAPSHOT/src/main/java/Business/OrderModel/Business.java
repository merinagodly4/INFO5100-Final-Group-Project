/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.OrderModel;

/**
 *
 * @author kens2
 */
public class Business {
    WholesaleMasterOrderList wholesaleMasterOrderList;
    RetailMasterOrderList retailMasterOrderList;
    SupplierDirectory supplierDirectory;
    
    public Business(){
        wholesaleMasterOrderList = new WholesaleMasterOrderList();
        retailMasterOrderList = new RetailMasterOrderList();
        supplierDirectory = new SupplierDirectory();
    }

    public WholesaleMasterOrderList getWholesaleMasterOrderList() {
        return wholesaleMasterOrderList;
    }

    public RetailMasterOrderList getRetailMasterOrderList() {
        return retailMasterOrderList;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    
    
}
