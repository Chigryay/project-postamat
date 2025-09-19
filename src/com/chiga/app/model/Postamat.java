package com.chiga.app.model;

import java.math.BigDecimal;

public class Postamat {
    private final PostCell[] postCells;

    public Postamat(PostCell[] postCells) {
        this.postCells = postCells;
    }

    public Integer putShipment(Shipment shipment) {
        int indexPostCell = -1;

        for (int i = 0; i < postCells.length; i++) {
            PostCell postCell = postCells[i];
            if (postCell.putShipment(shipment)) {
                indexPostCell = i;
                System.out.println("Посылка загружена в ячейку " + indexPostCell + "\n" + shipment);
                break;
            }
        }
        return indexPostCell;
    }

    public Shipment getShipment(int numberOfCell) {
        if (numberOfCell >=0 && numberOfCell < postCells.length) {
            PostCell postCell = postCells[numberOfCell];
            Shipment shipment = postCell.getShipment();
            if (shipment == null) {
                System.out.println("Ячейка пуста");
                return shipment;
            } else {
                System.out.println("Посылка " + shipment);
                return shipment;
            }
        } else {
            System.out.println("Нет такой ячейки");
            return null;
        }
    }

    public BigDecimal weightAllShipments() {
        BigDecimal sumAllWeightShipment = new BigDecimal("0.00");
        Shipment shipment;
        for (PostCell postCell : postCells) {
           shipment = postCell.getShipment();
            if (shipment != null) {
                sumAllWeightShipment = sumAllWeightShipment.add(BigDecimal.valueOf(shipment.weight()));
            }
        }
        return sumAllWeightShipment;
    }

    public void extractShipment(int indexCell) {
        Shipment shipment;
        if (indexCell >= 0 && indexCell < postCells.length) {
            PostCell postCell = postCells[indexCell];
            if (postCell.getShipment() != null) {
                shipment = postCell.extractShipment();
                System.out.println("Ивзлечена посылка " + shipment);
            }
        }
    }

    public PostCell[] getPostCells() {
        return postCells;
    }
}
