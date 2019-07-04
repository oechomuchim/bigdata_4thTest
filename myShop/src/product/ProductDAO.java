package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import product.ProductDTO;

public class ProductDAO {
	DBConnectionMgr mgr;
	
	public ProductDAO(){
		mgr = DBConnectionMgr.getInstance();
	}
	
	// 제너릭 프로그래밍(객체 생성시 타입을 결정 가능)
	// 형변환 필요 없어서 내부적인 처리 속도 더 빠름
	
	public ProductDTO select(ProductDTO dto) throws Exception {
		
		//1,2단계를 해주는 DBConnectinMgr객체 필요
		Connection con = mgr.getConnection();
		
		//3단계 sql문 결정
		String sql = "select * from product where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		
		//4단계 sql문 전달 요청
		ResultSet rs =  ps.executeQuery();
		ProductDTO dto2 = null;
		
		while(rs.next()) {
			dto2 = new ProductDTO();
			String id = rs.getString(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String price = rs.getString(4);
			dto2.setId(id);
			dto2.setTitle(title);
			dto2.setContent(content);
			dto2.setPrice(price);
		}
		return dto2;
	}
	
	public void update(ProductDTO dto) throws Exception {
		
		//1,2단계를 해주는 DBConnectinMgr객체 필요
		Connection con = mgr.getConnection();
		
		//3단계 sql문 결정
		String sql = "update product set id = ?, title =?, content = ?, price = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getPrice());
		ps.setString(5, dto.getId());
		//4단계 sql문 전달 요청
		ps.executeUpdate();
	}
	
	public void delete(ProductDTO dto) throws Exception {
		//1,2단계를 해주는 DBConnectinMgr객체 필요
		Connection con = mgr.getConnection();
		
		//3단계 sql문 결정
		String sql = "delete from product where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		//4단계 sql문 전달 요청
		ps.executeUpdate();
		mgr.freeConnection(con, ps);
	}
	
	public void insert(ProductDTO dto) throws Exception {
		
		//1,2단계를 해주는 DBConnectinMgr객체 필요
		Connection con = mgr.getConnection();
		
		//3단계 sql문 결정
		String sql = "insert into product values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getPrice());
		//4단계 sql문 전달 요청
		ps.executeUpdate();
		mgr.freeConnection(con, ps);
	}
	
	public ArrayList<ProductDAO> selectAll() throws Exception {
		  ArrayList list = new ArrayList();
	      Connection con = mgr.getConnection();
	      ProductDTO dto = null; //변수의 생존범위 = 선언의 위치
	      
	         //3. SQL문 결정(객체화)
	         String sql = "select * from product";
	         PreparedStatement ps = con.prepareStatement(sql);
	         System.out.println("SQL문 객체화 OK");
	         //4. SQL문 전송
	         ResultSet rs = ps.executeQuery();
	         
	         while(rs.next()) {
	            dto = new ProductDTO();
	            String id = rs.getString(1);
	            String title = rs.getString(2);
	            String content = rs.getString(3);
	            String price = rs.getString(4);
	            
	            dto.setId(id);
	            dto.setTitle(title);
	            dto.setContent(content);
	            dto.setPrice(price);
	            
	            list.add(dto);
	         }
	         System.out.println("SQL문 전송 OK");
	         
	         try {
	            rs.close();
	            ps.close();
	            con.close();
	         } catch (SQLException e) {
	            //e.printStackTrace();
	            System.out.println("자원 해제 중 에러 발생!!");
	         }
	     return list;
		} 
	}