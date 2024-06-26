import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.*;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
class House implements Serializable {
    private String cadastralNumber;
    private String address;
    private Person elder;
    private List<Flat> flats;

    public House(){}

    public House(String cadastralNumber, String address, Person elder, List<Flat> flats) {
        if (cadastralNumber.isEmpty() || address.isEmpty()) throw new NullPointerException("cadastralNumber или address не должны быть пустыми");
        if (elder==null) throw new NullPointerException("Надо назначить ответственного за дом");
        if (flats.isEmpty()) throw new NullPointerException("В доме обязаны быть квартиры");
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.elder = elder;
        this.flats = flats;
    }

    @JsonProperty("cadastralNumber")
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("elder")
    public Person getElder() {
        return elder;
    }

    public void setElder(Person elder) {
        this.elder = elder;
    }

    @JsonProperty("flats")
    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    public void saveToCSV() throws IOException {
        String fileName = "house_" + this.cadastralNumber + ".csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Записываем данные о доме
            writer.write("Данные о доме\n");
            writer.write("Кадастровый номер: " + this.cadastralNumber + "\n");
            writer.write("Адрес: " + this.address + "\n");
            writer.write("Старший по дому: " + this.elder.getFullName() + "\n\n");

            // Записываем данные о квартирах
            writer.write("Данные о квартирах\n");
            writer.write("№;Площадь, кв. м;Владельцы\n");
            for (Flat flat : this.flats) {
                writer.write(flat.getNumber() + ";" + flat.getArea() + ";");
                for (Person owner : flat.getOwners()) {
                    writer.write(owner.getFio() + ",");
                }
                writer.write("\n");
            }
        }
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
