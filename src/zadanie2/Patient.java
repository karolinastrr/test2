package zadanie2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private String pesel;
    private LocalDate dateOfBirth;
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(int id, String surname, String name, String pesel, LocalDate dateOfBirth) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public static Patient findPatientsById(List<Patient> patients, int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        throw new IllegalArgumentException("Patient with id " + id +  " can't be found");
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", appointments=" + appointments +
                '}';
    }
}
