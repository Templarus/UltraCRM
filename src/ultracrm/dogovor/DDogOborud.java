/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author EvgenyVart
 */
public class DDogOborud {

    private Integer idDogovor;
    private Integer idOborud;
    private Integer kolvo;
    private Date dtEndArenda;
    private String gorod;
    private String ulica;
    private String dom;
    private String korp;
    private String office;
    private String prim;
    private BigDecimal cenaPoTarif;
    private SUslovieDogovor idUslovie;
    private String adress;
    private String nameOborud;

    public DDogOborud() {
    }

    public DDogOborud(Integer idOborud, String nameOborud, String adress, int kolvo) {
        this.idOborud = idOborud;
        this.kolvo = kolvo;
        this.adress = adress;
        this.nameOborud = nameOborud;
    }

    public DDogOborud(Integer idDogovor, Integer idOborud, int kolvo, Date dtEndArenda, String gorod, String ulica, String dom, String korp, String office, String prim, BigDecimal cenaPoTarif) {
        this.idDogovor = idDogovor;
        this.idOborud = idOborud;
        this.kolvo = kolvo;
        this.dtEndArenda = dtEndArenda;
        this.gorod = gorod;
        this.ulica = ulica;
        this.dom = dom;
        this.korp = korp;
        this.office = office;
        this.prim = prim;
        this.cenaPoTarif = cenaPoTarif;
    }

    public void convertAdress() {
        StringBuilder sb = new StringBuilder();
        sb.append(gorod);
        if (gorod.length() > 0) {
            sb.append(" ");
        }
        sb.append(ulica);
        if (ulica.length() > 0) {
            sb.append(" ");
        }
        if (dom.length() > 0) {
            sb.append("д.");
            sb.append(dom);
            sb.append(" ");
        }
         if (korp.length() > 0) {
            sb.append("корп.");
            sb.append(korp);
            sb.append(" ");
        }
        if (office.length() > 0) {
            sb.append("оф.");
            sb.append(office);
            sb.append(" ");
        }
        adress = sb.toString();
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(Integer kolvo) {
        this.kolvo = kolvo;
    }

    public Date getDtEndArenda() {
        return dtEndArenda;
    }

    public void setDtEndArenda(Date dtEndArenda) {
        this.dtEndArenda = dtEndArenda;
    }

    public String getGorod() {
        return gorod;
    }

    public void setGorod(String gorod) {
        this.gorod = gorod;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getKorp() {
        return korp;
    }

    public void setKorp(String korp) {
        this.korp = korp;
    }

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
    }

    public BigDecimal getCenaPoTarif() {
        return cenaPoTarif;
    }

    public void setCenaPoTarif(BigDecimal cenaPoTarif) {
        this.cenaPoTarif = cenaPoTarif;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getIdDogovor() {
        return idDogovor;
    }

    public void setIdDogovor(Integer idDogovor) {
        this.idDogovor = idDogovor;
    }

    public Integer getIdOborud() {
        return idOborud;
    }

    public void setIdOborud(Integer idOborud) {
        this.idOborud = idOborud;
    }

    public SUslovieDogovor getIdUslovie() {
        return idUslovie;
    }

    public void setIdUslovie(SUslovieDogovor idUslovie) {
        this.idUslovie = idUslovie;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNameOborud() {
        return nameOborud;
    }

    public void setNameOborud(String nameOborud) {
        this.nameOborud = nameOborud;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idDogovor);
        hash = 67 * hash + Objects.hashCode(this.idOborud);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DDogOborud other = (DDogOborud) obj;
        if (!Objects.equals(this.idDogovor, other.idDogovor)) {
            return false;
        }
        if (!Objects.equals(this.idOborud, other.idOborud)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameOborud;
    }

}
