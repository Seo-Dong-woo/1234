package com.sist.dao;

import java.util.*;
import java.sql.*;

import com.sist.dbcp.CreateDBCPConnection;
import com.sist.vo.*;

public class GoodsJjimLikeDAO {
   private Connection conn;
   private PreparedStatement ps;
   private CreateDBCPConnection dbconn=new CreateDBCPConnection();
   private static GoodsJjimLikeDAO dao;
   
   public static GoodsJjimLikeDAO newInstance()
   {
      if(dao==null)
         dao=new GoodsJjimLikeDAO();
      return dao;
   }
   
   // Jjim저장
   public void goodsJjimInsert(GoodsJjimVO vo)
   {
      try
      {
         conn=dbconn.getConnection();
         String sql="INSERT INTO goods1_jjim VALUES("
                + "gj1_no_seq.nextval, ?, ?, ?)";
         ps=conn.prepareStatement(sql);
         ps.setString(1, vo.getId());
         ps.setInt(2, vo.getCno());
         ps.setInt(3, vo.getGno());
         ps.executeUpdate();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         dbconn.disConnection(conn, ps);
      }
   }
   
   // Jjim확인
   public int goodsJjimCount(String id, int cno, int gno)
   {
      int count=0;
      try
      {
         conn=dbconn.getConnection();
         String sql="SELECT COUNT(*) "
                + "FROM goods1_jjim "
                + "WHERE id=? AND cno=? AND gno=?";
         ps=conn.prepareStatement(sql);
         ps.setString(1, id);
         ps.setInt(2, cno);
         ps.setInt(3, gno);
         ResultSet rs=ps.executeQuery();
         rs.next();
         count=rs.getInt(1);
         rs.close();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         dbconn.disConnection(conn, ps);
      }
      return count;
   }
   
   // Jjim취소
   public void goodsJjimCancel(int no)
   {
      try
      {
         conn=dbconn.getConnection();
         String sql="DELETE FROM goods1_jjim "
                + "WHERE no=?";
         ps=conn.prepareStatement(sql);
         ps.setInt(1, no);
         ps.executeUpdate();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         dbconn.disConnection(conn, ps);
      }
   }
   
   // Jjim목록 => 마이페이지(찜관리)
   public List<GoodsJjimVO> goodsJjimListData(String id)
   {
      List<GoodsJjimVO> list=new ArrayList<GoodsJjimVO>();
      try
      {
         conn=dbconn.getConnection();
         String sql="SELECT no,cno,gno"
                + "(SELECT poster FROM goods1 WHERE cno=goods1_jjim.cno AND gno=goods1_jjim.gno),"
                + "(SELECT title FROM goods1 WHERE cno=goods1_jjim.cno AND gno=goods1_jjim.gno),"
                + "(SELECT selling_price FROM goods1 WHERE cno=goods1_jjim.cno AND gno=goods1_jjim.gno) "
                + "FROM goods1_jjim "
                + "WHERE id=? "
                + "ORDER BY no DESC";
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         dbconn.disConnection(conn, ps);
      }
      return list;
   }
}