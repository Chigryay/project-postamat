package com.chiga.app;

import com.chiga.app.model.Dimensions;
import com.chiga.app.model.PostCell;
import com.chiga.app.model.Postamat;
import com.chiga.app.model.Shipment;

public class App {
    public static void main(String[] args) {
        PostCell postCell1 = new PostCell(new Dimensions(10, 5, 7));
        PostCell postCell2 = new PostCell(new Dimensions(15, 10, 7));
        PostCell postCell3 = new PostCell(new Dimensions(1, 5, 7));
        PostCell postCell4 = new PostCell(new Dimensions(22, 10, 17));

        PostCell[] postCells = new PostCell[4];
        postCells[0] = postCell1;
        postCells[1] = postCell2;
        postCells[2] = postCell3;
        postCells[3] = postCell4;


        Postamat postamat = new Postamat(postCells);
        postamat.putShipment(new Shipment(new Dimensions(12, 5, 7), 50, "Apple"));
        postamat.putShipment(new Shipment(new Dimensions(13, 5, 7), 50, "Orange"));
        postamat.putShipment(new Shipment(new Dimensions(12, 5, 7), 50, "Banana"));
        postamat.putShipment(new Shipment(new Dimensions(12, 5, 7), 50, "Potato"));

        System.out.println(postamat.weightAllShipments());

        postamat.getShipment(0);
        postamat.getShipment(1);
        postamat.getShipment(2);
        postamat.getShipment(3);
        System.out.println("---------------------------------------------------]\n");
        postamat.extractShipment(1);
        postamat.getShipment(1);
    }

}
