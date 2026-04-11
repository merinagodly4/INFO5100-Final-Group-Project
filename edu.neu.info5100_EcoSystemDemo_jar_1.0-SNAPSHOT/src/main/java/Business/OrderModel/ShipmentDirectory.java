/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.OrderModel;
import java.util.ArrayList;

/**
 *
 * @author hannahchiou
 */
public class ShipmentDirectory {
        private ArrayList<Shipment> shipmentList;

    public ShipmentDirectory() {
        shipmentList = new ArrayList<>();
    }

    public Shipment createShipment() {
        Shipment s = new Shipment();
        shipmentList.add(s);
        return s;
    }

    public ArrayList<Shipment> getShipmentList() {
        return shipmentList;
    }

    public Shipment findByID(int id) {
        for (Shipment s : shipmentList) {
            if (s.getShipmentID() == id) {
                return s;
            }
        }
        return null;
    }
}
 