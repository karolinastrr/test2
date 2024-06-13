package zadanie2;

import java.time.LocalDate;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalDate dateOfAppointment;

    public Appointment(Doctor doctor, Patient patient, LocalDate dateOfAppointment) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfAppointment = dateOfAppointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    @Override
    public String toString() {
        return "Appointment{" + doctor.getName() + " " + patient.getName() + " " +
                ", dateOfAppointment=" + dateOfAppointment +
                '}';
    }
}
