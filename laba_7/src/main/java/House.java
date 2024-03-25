import java.io.*;
import java.util.List;
import java.util.Objects;

class House implements Serializable {
    private String cadastralNumber;
    private String address;
    private Person elder;
    private List<Flat> flats;

    public House(){};

    public House(String cadastralNumber, String address, Person elder, List<Flat> flats) {
        if (cadastralNumber.isEmpty() || address.isEmpty()) throw new NullPointerException("cadastralNumber или address не должны быть пустыми");
        if (elder==null) throw new NullPointerException("Надо назначить ответственного за дом");
        if (flats.isEmpty()) throw new NullPointerException("В доме обязаны быть квартиры");
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.elder = elder;
        this.flats = flats;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getElder() {
        return elder;
    }

    public void setElder(Person elder) {
        this.elder = elder;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return cadastralNumber.equals(house.cadastralNumber) && address.equals(house.address) && elder.equals(house.elder) && flats.equals(house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, address, elder, flats);
    }
}
