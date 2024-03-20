package Entity;

import Interface.IArea;

public abstract class AArea implements IArea {

    private Double area;

    public Double getArea(){
        return this.area;
    }

    public void setArea(Double area){
        this.area = area;
    }


}
