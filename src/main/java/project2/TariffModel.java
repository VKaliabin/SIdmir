package project2;

import java.util.List;

public class TariffModel {

    private int idTariff;
    private String nameTariff;
    private int priceTariff;
    private List<OptionModel> optionModels;

    public int getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(int idTariff) {
        this.idTariff = idTariff;
    }

    public String getNameTariff() {
        return nameTariff;
    }

    public void setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
    }

    public int getPriceTariff() {
        return priceTariff;
    }

    public void setPriceTariff(int priceTariff) {
        this.priceTariff = priceTariff;
    }

    public List<OptionModel> getOptionModels() {
        return optionModels;
    }

    public void setOptionModels(List<OptionModel> optionModels) {
        this.optionModels = optionModels;
    }

    @Override
    public String toString() {
        return "TariffModel{" +
                "idTariff=" + idTariff +
                ", nameTariff='" + nameTariff + '\'' +
                ", priceTariff=" + priceTariff +
                ", optionModels=" + optionModels +
                '}';
    }
}
