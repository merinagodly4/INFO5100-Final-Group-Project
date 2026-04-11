/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.SellProductsModel.ProductCatalog;
import Business.SellProductsModel.RetailMasterOrderList;
import Business.SellProductsModel.WholesaleMasterOrderList;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    WholesaleMasterOrderList wholesaleMasterOrderList;
    RetailMasterOrderList retailMasterOrderList;
    ProductCatalog productCatalog;
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
        wholesaleMasterOrderList = new WholesaleMasterOrderList();
        retailMasterOrderList = new RetailMasterOrderList();
        productCatalog = new ProductCatalog();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public WholesaleMasterOrderList getWholesaleMasterOrderList() {
        return wholesaleMasterOrderList;
    }

    public RetailMasterOrderList getRetailMasterOrderList() {
        return retailMasterOrderList;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    
}
