package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblAdhaar")
public class Adhaar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int adhaarId;
    private long adhaarNo;

    @OneToOne
    Person person;

    public int getAdhaarId() {
        return adhaarId;
    }

    public void setAdhaarId(int adhaarId) {
        this.adhaarId = adhaarId;
    }

    public long getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(long adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Adhaar(long adhaarNo, Person person) {
        this.adhaarNo = adhaarNo;
        this.person = person;
    }

    public Adhaar() {
    }

    @Override
    public String toString() {
        return "Adhaar [adhaarId=" + adhaarId + ", adhaarNo=" + adhaarNo + ", person=" + person + "]";
    }

}
