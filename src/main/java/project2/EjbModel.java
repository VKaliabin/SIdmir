package project2;

import java.util.List;

public class EjbModel {

    private List<TariffModel> tariffs;

    public List<TariffModel> getTariffs() {
        return tariffs;
    }

    public void setTariffs(List<TariffModel> tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public String toString() {
        return "EjbModel{" +
                "tariffs=" + tariffs +
                '}';
    }
}
