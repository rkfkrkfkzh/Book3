package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDao {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	public String jdbc_url = "jdbc:oracle:thin:@db202110262237_high?TNS_ADMIN=/Users/imhyojin/Wallet_DB202110262237";
	ResultSet rs = null;

	private static BookDao sd = new BookDao();

	private BookDao() {
	}

	public static BookDao getDao() {
		return sd;
	}

	public boolean con() {
		// TODO Auto-generated method stub
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "ADMIN", "Dkfdktek36270113");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public void discon() {
		// TODO Auto-generated method stub
		try {
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insert(BookVo p) {
		this.con();
		String sql = "insert into book values(Book_seq.nextval,?,?,?,?)";

		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, p.getTitle());
			this.pstmt.setString(2, p.getAuthor());
			this.pstmt.setString(3, p.getPublisher());
			this.pstmt.setString(4, p.getContent());
			this.pstmt.executeUpdate();
		} catch (Exception var7) { 
			System.out.println(var7);
		} finally {
			this.discon();
		}

	}

	public ArrayList<BookVo> getAll() {
		this.con();
		ArrayList<BookVo> list = new ArrayList<BookVo>(); //연결
		String sql = "select * from book order by num"; // SQL 문장 만들고

		try {
			this.stmt = this.conn.createStatement(); // 위에서 만든 SQL문장이 오라클로 넘어갔다
			this.rs = this.stmt.executeQuery(sql);

			while (this.rs.next()) {
				int num = this.rs.getInt(1);
				String title = this.rs.getString(2);
				String Author = this.rs.getString(3);
				String Publisher = this.rs.getString(4);
				String contents = this.rs.getString(5);
				BookVo m = new BookVo(num, title, Author, Publisher, contents);
				list.add(m);
			}

			return list;
		} catch (Exception var12) {
			System.out.println(var12);
		} finally {
			this.discon();
		}

		return null;
	}

	public BookVo getMember(int num) {
		this.con();
		String sql = "select * from book where num=?";

		BookVo var10;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, num);
			this.rs = this.pstmt.executeQuery();
			if (!this.rs.next()) {
				return null;
			}

			int bno = this.rs.getInt(1);
			String title = this.rs.getString(2);
			String Author = this.rs.getString(3);
			String Publisher = this.rs.getString(4);
			String contents = this.rs.getString(5);
			BookVo m = new BookVo(bno, title, Author, Publisher, contents);
			var10 = m;
		} catch (Exception var13) {
			System.out.println(var13);
			return null;
		} finally {
			this.discon();
		}

		return var10;
	}

	public void edit(BookVo p) {
		this.con();
		System.out.println(p);
		String sql = "update book set title=?, Author=?, Publisher=?,content=? where num=?";

		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, p.getTitle());
			this.pstmt.setString(2, p.getAuthor());
			this.pstmt.setString(3, p.getPublisher());
			this.pstmt.setString(4, p.getContent());
			this.pstmt.setInt(5, p.getNum());
			this.pstmt.executeUpdate();
		} catch (Exception var7) {
			System.out.println(var7);
		} finally {
			this.discon();
		}

	}

	public void delete(int num) {
		this.con();
		String sql = "delete book where num=?";

		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, num);
			this.pstmt.executeUpdate();
		} catch (Exception var7) {
			System.out.println(var7);
		} finally {
			this.discon();
		}

	}
}