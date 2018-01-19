package library.controller;

import library.dto.read.PublisherReadDto;
import library.dto.write.PublisherDto;
import library.entity.Publisher;
import library.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/{publisherId}", method = RequestMethod.GET)
    @ResponseBody
    public PublisherReadDto get(@PathVariable String publisherId) {
        Publisher publisher = publisherService.findOne(Integer.valueOf(publisherId));
        return modelMapper.map(publisher, PublisherReadDto.class);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@RequestBody PublisherDto publisherDto) {
        Publisher publisher;
        try {
            publisher = publisherService.save(modelMapper.map(publisherDto, Publisher.class));
        } catch (Exception e) {
            return "Error creating the publisher: " + e.toString();
        }
        return "Publisher succesfully created! (id = " + publisher.getId() + ")";
    }

    @RequestMapping(value = "/{publisherId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable String publisherId) {
        Publisher publisher;
        try {
            publisherService.delete(publisherId);
        } catch (Exception e) {
            return "Error deleting the publisher: " + e.toString();
        }
        return "Publisher succesfully deleted! (id = " + publisherId + ")";
    }

}
