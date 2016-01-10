/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;



public class SVidOplat {

 

    private Integer idVidOplat;
    private String nameVidOplat;

    public SVidOplat() {
    }

    public SVidOplat(Integer idVidOplat) {
        this.idVidOplat = idVidOplat;
    }

    public SVidOplat(Integer idVidOplat, String nameVidOplat) {
        this.idVidOplat = idVidOplat;
        this.nameVidOplat = nameVidOplat;
    }

    public Integer getIdVidOplat() {
        return idVidOplat;
    }

    public void setIdVidOplat(Integer idVidOplat) {
        this.idVidOplat = idVidOplat;
    }

    public String getNameVidOplat() {
        return nameVidOplat;
    }

    public void setNameVidOplat(String nameVidOplat) {
        this.nameVidOplat = nameVidOplat;
    }


    @Override
    public String toString() {
        return nameVidOplat;
    }
    
}
