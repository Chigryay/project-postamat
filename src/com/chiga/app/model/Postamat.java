package com.chiga.app.model;

public class Postamat {
    private final PostCell[] postCells;

    public Postamat(PostCell[] postCells) {
        this.postCells = postCells;
    }

    public int putShipment(Shipment shipment) {
        int index = -1;
        for (int i = 0; i < postCells.length; i++) {
            if (postCells[i].canAcceptShipment(shipment)) {
                if (postCells[i].putShipment(shipment)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public Shipment getShipment(int numberOfCell) {
        if (postCells[numberOfCell].extractShipment() == null) {
            System.out.println("Ячейка пуста");
            return null;
        }
        return postCells[numberOfCell].extractShipment();
    }

    public double weightAllShipments() {
        double weightAllShipment = 0;
        for (int i = 0; i < postCells.length; i++) {
            Shipment shipment = postCells[i].extractShipment();
            if (shipment != null) {
                weightAllShipment += shipment.weight();
            }
        }
        return weightAllShipment;
    }
}
