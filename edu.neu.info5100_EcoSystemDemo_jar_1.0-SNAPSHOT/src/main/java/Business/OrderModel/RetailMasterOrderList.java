/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.OrderModel;

import java.util.ArrayList;

/**
 *
 * @author kens2
 */
public class RetailMasterOrderList {
    ArrayList<RetailOrder> orderList;
    

    public RetailMasterOrderList() {
        orderList = new ArrayList<RetailOrder>();
    }

    public ArrayList<RetailOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<RetailOrder> orderList) {
        this.orderList = orderList;
    }
    public void addNewOrder(RetailOrder order){
        this.orderList.add(order); 
    }
}
