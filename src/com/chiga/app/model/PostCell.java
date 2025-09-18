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
                || shipment.dimensions().compareTo(dimensions)
                || cellStatus != CellStatus.WORK;
    }

    boolean putShipment(Shipment shipment) {
        if (canAcceptShipment(shipment)) {
            this.shipment = shipment;
            System.out.println("Посылка успешно загружена");
            return true;
        } else {
            System.out.println("Посылка не загружена");
            return false;
        }
    }

    Shipment extractShipment() {
        Shipment shipment = cloneShipment();
        if (hasShipment()) {
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
}
