package library.controller;

import library.dto.PublisherDto;
import library.entity.Publisher;
import library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@RequestBody PublisherDto publisherDto) {
        Publisher publisher;
        try {
            publisher =  publisherService.save(publisherDto);
        }
        catch (Exception e) {
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
