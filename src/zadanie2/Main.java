package zadanie2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Doctor> loadedDoctors = loadDoctorsFromFile("lekarze.txt");
        List<Patient> loadedPatients = loadPatientsFromFile("pacjenci.txt");
        List<Appointment> loadedAppointments = loadAppointmentFromFile("wizyty.txt", loadedDoctors, loadedPatients);

        System.out.println(findDoctorWithMostAppointments(loadedDoctors));
        System.out.println(findPatientWithMostAppointments(loadedPatients));
        System.out.println(findMostPopularSpecialisation(loadedDoctors));
        System.out.println(findYearWithMostAppointments(loadedDoctors));
        System.out.println(findTop5DoctorsWithMostAppointments(loadedDoctors));
        System.out.println(findTop5OldestDoctors(loadedDoctors));
        System.out.println(findPatientsWithAtLeastFiveDifferentDoctors(loadedPatients));
        System.out.println(findDoctorsWithOnlyOnePatient(loadedDoctors));

        for (Appointment appointment : loadedAppointments) {
            System.out.println(appointment);
        }
    }

    public static List<Doctor> loadDoctorsFromFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            List<Doctor> doctorsFromFile = new ArrayList<>();
            String line;

            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split("\t");
                doctorsFromFile.add(new Doctor(Integer.parseInt(splittedLine[0]), splittedLine[1], splittedLine[2], splittedLine[3],
                        LocalDate.parse(splittedLine[4]), splittedLine[5], splittedLine[6]));
            }

            return doctorsFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Patient> loadPatientsFromFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            List<Patient> patientsFromFile = new ArrayList<>();
            String line;

            bufferedReader.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split("\t");
                patientsFromFile.add(new Patient(Integer.parseInt(splittedLine[0]), splittedLine[1], splittedLine[2], splittedLine[3],
                        LocalDate.parse(splittedLine[4], formatter)));
            }
            return patientsFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Appointment> loadAppointmentFromFile(String path, List<Doctor> doctors, List<Patient> patients) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            List<Appointment> appointmentsFromFile = new ArrayList<>();
            String line;

            bufferedReader.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");


            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split("\t");
                Doctor foundDoctor = Doctor.fintDoctorById(doctors, Integer.parseInt(splittedLine[0]));
                Patient foundPatient = Patient.findPatientsById(patients, Integer.parseInt(splittedLine[1]));
                Appointment appointment = new Appointment(foundDoctor, foundPatient, LocalDate.parse(splittedLine[2], formatter));

                foundDoctor.addAppointment(appointment);
                foundPatient.addAppointment(appointment);
                appointmentsFromFile.add(appointment);
            }

            return appointmentsFromFile;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Doctor findDoctorWithMostAppointments(List<Doctor> doctors) {
        Doctor doctorWithMostAppointments = doctors.get(0);
        for (Doctor doctor : doctors) {
            if (doctor.getAppointments().size() > doctorWithMostAppointments.getAppointments().size()) {
                doctorWithMostAppointments = doctor;
            }
        }
        return doctorWithMostAppointments;
    }

    public static Patient findPatientWithMostAppointments(List<Patient> patients) {
        Patient patientWithMostAppointments = patients.get(0);
        for (Patient patient : patients) {
            if (patient.getAppointments().size() > patientWithMostAppointments.getAppointments().size()) {
                patientWithMostAppointments = patient;
            }
        }
        return patientWithMostAppointments;
    }

    public static String findMostPopularSpecialisation(List<Doctor> doctors) {
        Map<String, Integer> specialisationCount = new HashMap<>();
        for (Doctor doctor : doctors) {
            String specialisation = doctor.getSpecialisation();
            int currentCount = specialisationCount.getOrDefault(specialisation, 0);
            specialisationCount.put(specialisation, currentCount + doctor.getAppointments().size());
        }
        String mostPopularSpecialisation = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : specialisationCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopularSpecialisation = entry.getKey();
            }
        }
        return mostPopularSpecialisation;
    }

    public static int findYearWithMostAppointments(List<Doctor> doctors) {
        Map<Integer, Integer> appointmentCountByYear = new HashMap<>();
        for (Doctor doctor : doctors) {
            List<Appointment> appointments = doctor.getAppointments();
            for (Appointment appointment : appointments) {
                int year = appointment.getDateOfAppointment().getYear();
                appointmentCountByYear.put(year, appointmentCountByYear.getOrDefault(year, 0) + 1);
            }
        }
        int mostAppointmentsYear = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : appointmentCountByYear.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostAppointmentsYear = entry.getKey();
            }
        }
        return mostAppointmentsYear;
    }

    public static List<Doctor> findTop5OldestDoctors(List<Doctor> doctors) {
        Collections.sort(doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
            }
        });
        return doctors.subList(0, Math.min(5, doctors.size()));
    }

    public static List<Doctor> findTop5DoctorsWithMostAppointments(List<Doctor> doctors) {
        Collections.sort(doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                return Integer.compare(d2.getAppointments().size(), d1.getAppointments().size());
            }
        });
        return doctors.subList(0, Math.min(5, doctors.size()));
    }

    public static List<Patient> findPatientsWithAtLeastFiveDifferentDoctors(List<Patient> patients) {
        List<Patient> patientsWhoVisitedMoreThan5Doctors = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.howManyDoctorsHasVisited() >= 5) {
                patientsWhoVisitedMoreThan5Doctors.add(patient);
            }
        }
        return patientsWhoVisitedMoreThan5Doctors;
    }

    public static List<Doctor> findDoctorsWithOnlyOnePatient(List<Doctor> doctors) {
        List<Doctor> doctorsWithOnlyOnePatient = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.howManyPatientsHasVisited() == 1) {
                doctorsWithOnlyOnePatient.add(doctor);
            }
        }
        return doctorsWithOnlyOnePatient;
    }
}


