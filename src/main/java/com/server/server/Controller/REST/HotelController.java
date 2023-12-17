package com.server.server.Controller.REST;

import com.server.server.Controller.DTO.HotelDTO;
import com.server.server.Service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/hotel"})
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping({"/create"})
    public HotelDTO create(@RequestBody HotelDTO hotelDTO) {
        return new HotelDTO(hotelService.insert(hotelDTO.getName(), hotelDTO.getPrice(), hotelDTO.getImg(), hotelDTO.getStars(), hotelDTO.getLocation(), hotelDTO.getInfo()));
    }

    @PutMapping("/update/{id}")
    public HotelDTO update(@PathVariable("id") Long id, @RequestBody HotelDTO hotelDTO){
        return new HotelDTO(hotelService.update(id, hotelDTO.getName(), hotelDTO.getPrice(), hotelDTO.getImg(), hotelDTO.getStars(), hotelDTO.getLocation(), hotelDTO.getInfo()));
    }

    @DeleteMapping("/delete/{id}")
    public HotelDTO delete(@PathVariable("id") Long id){
        return new HotelDTO(hotelService.delete(id));
    }

    @GetMapping("/get/{id}")
    public HotelDTO get(@PathVariable("id") Long id){
        return new HotelDTO(hotelService.findHotel(id));
    }

    @GetMapping("/getAll")
    public List<HotelDTO> getAll(@RequestParam("page") int page,
                                   @RequestParam("size") int size) {
        return hotelService.getAllHotelPaged(page, size).stream().map(
                HotelDTO::new
        ).toList();
    }
}