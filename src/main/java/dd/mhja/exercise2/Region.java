package dd.mhja.exercise2;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "RegionEx2")
@Table(name = "REGIONS")
public class Region {
    @Id
    @Column(name = "region_id")
    private int id;

    @Column(name = "region_name")
    private String name;

    @OneToMany(mappedBy = "region")
    private Set<Country> countries;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Region [id=" + id + ", name=" + name + ", countries=" + countries + "]";
    }
}
