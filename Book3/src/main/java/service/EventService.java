package service;

import java.util.ArrayList;

import model.BookDao;
import model.BookVo;

public class EventService {
	private BookDao dao = BookDao.getDao();

	public EventService() {
	}

	public void insert(BookVo m) {
		this.dao.insert(m);
	}

	public ArrayList<BookVo> list() {
		return this.dao.getAll();
	}

	public BookVo getMember(int num) {
		return this.dao.getMember(num);
	}

	public void edit(BookVo m) {
		this.dao.edit(m);
	}

	public void delete(int num) {
		this.dao.delete(num);
	}
}