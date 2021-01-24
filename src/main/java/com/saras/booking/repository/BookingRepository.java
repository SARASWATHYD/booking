package com.saras.booking.repository;

import com.saras.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, String> {

    @Async
    @Query("SELECT * FROM Booking t where t.roomId = :roomId and t.startTime < :startTime and t.endTime >=endTime and isDeleted =false")
    Future<Optional<List<Booking>>> getIntersectionBooking(String roomId, long startTime, long endTime);
}

