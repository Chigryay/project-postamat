package com.chiga.app.utils;

import com.chiga.app.model.CellStatus;

public class FormaterStringToEnum {
    public static Enum<CellStatus> returnCellStatus(String cellStatus) {
        return CellStatus.valueOf(cellStatus.toUpperCase());
    }
}
