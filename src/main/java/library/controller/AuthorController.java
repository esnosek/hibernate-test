package library.controller;

import library.dto.read.AuthorReadDto;
import library.dto.write.AuthorDto;
import library.entity.Author;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@RequestBody AuthorDto authorDto) {
        Author author;
        try {
            author = authorService.save(authorDto);
        } catch (Exception e) {
            return "Error creating the author: " + e.toString();
        }
        return "Author succesfully created! (id = " + author.getId() + ")";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<AuthorReadDto> getAll() {
        List<Author> authors = authorService.findAll();
        return modelMapper.map(authors, new TypeToken<List<AuthorReadDto>>() {
        }.getType());
    }
}
