package com.saras.booking.repository;

import com.saras.booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository  extends JpaRepository<Room, String> {

}
