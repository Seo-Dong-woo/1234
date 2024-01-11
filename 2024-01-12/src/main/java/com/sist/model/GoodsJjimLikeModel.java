package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class GoodsJjimLikeModel {
   @RequestMapping("jjim/jjim_insert.do")
   public String jjim_insert(HttpServletRequest request, HttpServletResponse response)
   {
      String cno=request.getParameter("cno");
      String gno=request.getParameter("gno");
      HttpSession session=request.getSession();
      String id=(String)session.getAttribute("id");
      
      GoodsJjimVO vo=new GoodsJjimVO();
      vo.setId(id);
      vo.setGno(Integer.parseInt(gno));
      vo.setCno(Integer.parseInt(cno));
      
      GoodsJjimLikeDAO dao=GoodsJjimLikeDAO.newInstance();
      dao.goodsJjimInsert(vo);
      
      System.out.println("반갑습니다");
      
      return "redirect:../store/store_detail.do?cno=" + cno + "&gno=" + gno;
   }
   
   @RequestMapping("jjim/jjim_cancel.do")
   public String jjim_cancel(HttpServletRequest request, HttpServletResponse response)
   {
      String no=request.getParameter("no");
      GoodsJjimLikeDAO dao=GoodsJjimLikeDAO.newInstance();
      dao.goodsJjimCancel(Integer.parseInt(no));
      
      return "redirect:../mypage/mypage_jjim_list.do";
   }
}