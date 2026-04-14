/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.OrderModel.RetailerProductCatalog;
import Business.OrderModel.RetailMasterOrderList;
import Business.OrderModel.ShipmentDirectory;
import Business.OrderModel.SupplierProductCatalog;
import Business.OrderModel.WholesaleMasterOrderList;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    WholesaleMasterOrderList wholesaleMasterOrderList;
    RetailMasterOrderList retailMasterOrderList;
    RetailerProductCatalog retailerProductCatalog;
    SupplierProductCatalog supplierProductCatalog;
    private ShipmentDirectory shipmentDirectory;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<Network>();
        wholesaleMasterOrderList = new WholesaleMasterOrderList();
        retailMasterOrderList = new RetailMasterOrderList();
        retailerProductCatalog = new RetailerProductCatalog();
        supplierProductCatalog = new SupplierProductCatalog();
        shipmentDirectory = new ShipmentDirectory();

    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public boolean checkIfUserIsUnique(String userName) {
        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            return false;
        }
        for (Network network : networkList) {

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

    public RetailerProductCatalog getRetailerProductCatalog() {
        return retailerProductCatalog;
    }

    public SupplierProductCatalog getSupplierProductCatalog() {
        return supplierProductCatalog;
    }

    public void setWholesaleMasterOrderList(WholesaleMasterOrderList wholesaleMasterOrderList) {
        this.wholesaleMasterOrderList = wholesaleMasterOrderList;
    }

    public void setRetailMasterOrderList(RetailMasterOrderList retailMasterOrderList) {
        this.retailMasterOrderList = retailMasterOrderList;
    }

    public void setRetailerProductCatalog(RetailerProductCatalog retailerProductCatalog) {
        this.retailerProductCatalog = retailerProductCatalog;
    }

    public void setSupplierProductCatalog(SupplierProductCatalog supplierProductCatalog) {
        this.supplierProductCatalog = supplierProductCatalog;
    }

    public ShipmentDirectory getShipmentDirectory() {
        return shipmentDirectory;
    }

    public void setShipmentDirectory(ShipmentDirectory shipmentDirectory) {
        this.shipmentDirectory = shipmentDirectory;
    }

    @Override
    public Organization.Type getType() {
        return null; // EcoSystem is not a typed organization
    }
}
