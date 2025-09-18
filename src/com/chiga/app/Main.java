package com.chiga.app;

import com.chiga.app.model.Dimensions;
import com.chiga.app.model.PostCell;
import com.chiga.app.model.Postamat;
import com.chiga.app.model.Shipment;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PostCell[] postCells = new PostCell[4];
        postCells[0] =  new PostCell(new Dimensions(12.5, 10, 7));
        postCells[1] =  new PostCell(new Dimensions(12.5, 10, 7));
        postCells[2] =  new PostCell(new Dimensions(12.5, 10, 7));
        postCells[3] =  new PostCell(new Dimensions(12.5, 13, 7));
        Postamat postamat = new Postamat(postCells);

        postamat.putShipment(new Shipment(new Dimensions(10, 3, 6), 40, "Apple"));
        postamat.putShipment(new Shipment(new Dimensions(33, 3, 6), 40, "Banana"));
        postamat.putShipment(new Shipment(new Dimensions(1, 3, 6), 40, "Orange"));
        postamat.putShipment(new Shipment(new Dimensions(13, 3, 6), 40, "Potato"));;


    }
}
