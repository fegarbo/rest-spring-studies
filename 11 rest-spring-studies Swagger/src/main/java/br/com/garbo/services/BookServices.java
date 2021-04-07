package br.com.garbo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.garbo.converter.DozerConverter;
import br.com.garbo.data.model.Book;
import br.com.garbo.data.vo.v1.BookVO;
import br.com.garbo.repository.BookRepository;
import br.com.garbo.exception.ResourceNotFoundException;


@Service
public class BookServices {

	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		return DozerConverter.parseObject(repository.save(entity), BookVO.class);
	}
	
	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());

		return DozerConverter.parseObject(repository.save(entity), BookVO.class);
	}
	
	public BookVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")) ;
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public List<BookVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
