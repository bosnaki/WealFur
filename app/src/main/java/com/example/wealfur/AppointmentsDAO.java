package com.example.wealfur;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface AppointmentsDAO {

    @Query("SELECT * FROM Appointments")
    List<Appointments> getAllAppointments();

    @Delete
    void deleteAppointment(Appointments appointment);

    @Insert
    void insertAppointment(Appointments appointment);

    @Query("SELECT date FROM Appointments WHERE appointmentId LIKE :id")
    String getAppointmentDatesFromId(int id);

    @Query("SELECT * FROM Appointments WHERE appointmentId LIKE :id")
    Appointments getAllInfoAppointmentsFromId(int id);
}
