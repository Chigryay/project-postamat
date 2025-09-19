package com.chiga.app.model;

import com.chiga.app.utils.FormaterStringToEnum;

public class PostCell {
    private final Dimensions dimensions;
    private Shipment shipment;
    private CellStatus cellStatus;

    public PostCell(Dimensions dimensions) {
        this.dimensions = dimensions;
        shipment = null;
        cellStatus = CellStatus.WORK;
    }

    boolean hasShipment() {
        return shipment != null;
    }

    boolean canAcceptShipment(Shipment shipment) {
        return !hasShipment()
                && dimensions.compareTo(shipment.dimensions())
                && cellStatus == CellStatus.WORK;
    }

    boolean putShipment(Shipment shipment) {
        if (canAcceptShipment(shipment)) {
            this.shipment = shipment;
            return true;
        } else {
            return false;
        }
    }

     Shipment extractShipment() {
        if (hasShipment()) {
            Shipment shipment = cloneShipment();
            this.shipment = null;
            return shipment;
        } else {
            return null;
        }
    }

    void turnMaintenanceMode() {
        if (!hasShipment()) {
            cellStatus = CellStatus.AT_MAINTENANCE;
        } else {
            System.out.println("ошибка! в ячейке есть посылка");
        }
    }

    void turnWorkingMode() {
        if (FormaterStringToEnum.returnCellStatus("AT_MAINTENANCE").equals(CellStatus.AT_MAINTENANCE)) {
            cellStatus = CellStatus.WORK;
        }
    }

    private Shipment cloneShipment() {
        return new Shipment(this.shipment.dimensions(), this.shipment.weight(), this.shipment.description());
    }

    public Shipment getShipment() {
        return shipment;
    }
}

