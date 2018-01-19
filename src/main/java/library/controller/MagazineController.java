package library.controller;

import library.dto.read.MagazineReadDto;
import library.dto.write.MagazineDto;
import library.entity.Magazine;
import library.service.MagazineService;
import library.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("magazines")
public class MagazineController {

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MagazineService magazineService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@RequestBody MagazineDto magazineDto) {
        Magazine magazine;
        try {
            magazine = magazineService.save(magazineDto);
        } catch (Exception e) {
            return "Error creating the magazine: " + e.toString();
        }
        return "Magazine succesfully created! (id = " + magazine.getId() + ")";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<MagazineReadDto> getAll() {
        List<Magazine> magazines = magazineService.findAll();
        return modelMapper.map(magazines, new TypeToken<List<MagazineReadDto>>() {
        }.getType());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public MagazineReadDto modify(@RequestBody MagazineDto magazineDto, @PathVariable Integer id) {
        return modelMapper.map(magazineService.update(id, magazineDto), MagazineReadDto.class);
    }


}

