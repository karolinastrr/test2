package zadanie2;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Doctor {
    private int id;
    private String surname;
    private String name;
    private String specialisation;
    private LocalDate dateOfBirth;
    private String nip;
    private String pesel;
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(int id, String surname, String name, String specialisation, LocalDate dateOfBirth, String nip, String pesel) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.specialisation = specialisation;
        this.dateOfBirth = dateOfBirth;
        this.nip = nip;
        this.pesel = pesel;
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

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public static Doctor fintDoctorById(List<Doctor> doctors, int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        throw new IllegalArgumentException("Doctor with id " + id + " can't be found");
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public int howManyPatientsHasVisited() {
        Set<Patient> patientsVisited = new HashSet<>();
        for (Appointment appointment : appointments) {
            patientsVisited.add(appointment.getPatient());
        }
        return patientsVisited.size();
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
