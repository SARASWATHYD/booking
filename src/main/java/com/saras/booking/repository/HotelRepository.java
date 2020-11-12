package com.saras.booking.repository;

import com.saras.booking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface HotelRepository  extends JpaRepository<Hotel, Long> {

}
