package com.server.server.Service;

import com.server.server.Model.Hotel;
import com.server.server.Repository.HotelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public Hotel insert(String name, Double price, Integer img, Integer stars, String location, String info) {
        Hotel hotel = new Hotel(name, price, img, stars, location, info);
        return hotelRepository.save(hotel);
    }

    @Transactional
    public Hotel update(Long id, String name, Double price, Integer img, Integer stars, String location, String info){
        final Hotel hotel = findHotel(id);
        hotel.setName(name);
        hotel.setPrice(price);
        hotel.setImg(img);
        hotel.setPrice(price);
        hotel.setStars(stars);
        hotel.setLocation(location);
        hotel.setInfo(info);
        return hotelRepository.save(hotel);
    }

    @Transactional
    public Hotel delete(Long id){
        final Hotel curHotel = findHotel(id);
        hotelRepository.delete(curHotel);
        return curHotel;
    }

    @Transactional
    public Hotel findHotel(Long id){
        return hotelRepository.getReferenceById(id);
    }

    @Transactional
    public Page<Hotel> getAllHotelPaged(int page, int size){
        return hotelRepository.findAll(PageRequest.of(page - 1, size));
    }
}