package library.service;

import library.dao.AuthorDao;
import library.dto.write.AuthorDto;
import library.entity.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private ModelMapper modelMapper;

    public Author save(AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto, Author.class);
        authorDao.save(author);
        return author;
    }

    public List<Author> findByIds(List<Integer> authorsIds) {
        return authorDao.findByIds(authorsIds);
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }

}
