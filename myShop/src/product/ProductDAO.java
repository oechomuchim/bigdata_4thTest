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
	
	// ���ʸ� ���α׷���(��ü ������ Ÿ���� ���� ����)
	// ����ȯ �ʿ� ��� �������� ó�� �ӵ� �� ����
	
	public ProductDTO select(ProductDTO dto) throws Exception {
		
		//1,2�ܰ踦 ���ִ� DBConnectinMgr��ü �ʿ�
		Connection con = mgr.getConnection();
		
		//3�ܰ� sql�� ����
		String sql = "select * from product where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		
		//4�ܰ� sql�� ���� ��û
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
		
		//1,2�ܰ踦 ���ִ� DBConnectinMgr��ü �ʿ�
		Connection con = mgr.getConnection();
		
		//3�ܰ� sql�� ����
		String sql = "update product set id = ?, title =?, content = ?, price = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getPrice());
		ps.setString(5, dto.getId());
		//4�ܰ� sql�� ���� ��û
		ps.executeUpdate();
	}
	
	public void delete(ProductDTO dto) throws Exception {
		//1,2�ܰ踦 ���ִ� DBConnectinMgr��ü �ʿ�
		Connection con = mgr.getConnection();
		
		//3�ܰ� sql�� ����
		String sql = "delete from product where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		//4�ܰ� sql�� ���� ��û
		ps.executeUpdate();
		mgr.freeConnection(con, ps);
	}
	
	public void insert(ProductDTO dto) throws Exception {
		
		//1,2�ܰ踦 ���ִ� DBConnectinMgr��ü �ʿ�
		Connection con = mgr.getConnection();
		
		//3�ܰ� sql�� ����
		String sql = "insert into product values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getPrice());
		//4�ܰ� sql�� ���� ��û
		ps.executeUpdate();
		mgr.freeConnection(con, ps);
	}
	
	public ArrayList<ProductDAO> selectAll() throws Exception {
		  ArrayList list = new ArrayList();
	      Connection con = mgr.getConnection();
	      ProductDTO dto = null; //������ �������� = ������ ��ġ
	      
	         //3. SQL�� ����(��üȭ)
	         String sql = "select * from product";
	         PreparedStatement ps = con.prepareStatement(sql);
	         System.out.println("SQL�� ��üȭ OK");
	         //4. SQL�� ����
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
	         System.out.println("SQL�� ���� OK");
	         
	         try {
	            rs.close();
	            ps.close();
	            con.close();
	         } catch (SQLException e) {
	            //e.printStackTrace();
	            System.out.println("�ڿ� ���� �� ���� �߻�!!");
	         }
	     return list;
		} 
	}