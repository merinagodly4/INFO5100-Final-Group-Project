/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.SellProductsModel;

import Business.SellProductsModel.WholesaleOrder;
import java.util.ArrayList;

/**
 *
 * @author kens2
 */
public class WholesaleMasterOrderList {
    ArrayList<WholesaleOrder> orderList;
    

    public WholesaleMasterOrderList() {
        orderList = new ArrayList<WholesaleOrder>();
    }

    public ArrayList<WholesaleOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<WholesaleOrder> orderList) {
        this.orderList = orderList;
    }
    public void addNewOrder(WholesaleOrder order){
        this.orderList.add(order); 
    }
}
