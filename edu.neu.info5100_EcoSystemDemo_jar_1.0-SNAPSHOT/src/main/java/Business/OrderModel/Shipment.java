/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.OrderModel;

import java.util.Date;

/**
 *
 * @author hannahchiou
 */
public class Shipment {

    private String origin;
    private String destination;
    private Date departureDate;
    private Date estimatedArrival;
    private WholesaleOrder order;
    private int shipmentID;
    private static int counter = 0;

    public Shipment() {
        this.order = new WholesaleOrder();
        this.shipmentID = ++counter;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(Date estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }

    public WholesaleOrder getOrder() {
        return order;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    @Override
    public String toString() {
        return "Shipment #" + shipmentID + " | " + origin + " -> " + destination;
    }
}
 