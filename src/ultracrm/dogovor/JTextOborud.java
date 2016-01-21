/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;

import ultracrm.oborud.DOborud;

/**
 *
 * @author Asus
 */
public class JTextOborud extends javax.swing.JTextField{
    private DOborud oborud;

    public JTextOborud() {
        super();
    }

    public DOborud getOborud() {
        return oborud;
    }

    public void setOborud(DOborud oborud) {
        this.oborud = oborud;
        this.setText(oborud.getNameOborud());
    }

    @Override
    public String toString() {
        return oborud.getNameOborud();
    }
    
    
    
}
