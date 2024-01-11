package com.sist.vo;
/*
 * CREATE TABLE goods1_jjim(
         no NUMBER,
         id VARCHAR2(20),
         gno NUMBER,
         CONSTRAINT gj_no_pk PRIMARY KEY(no),
         CONSTRAINT gi_id_fk FOREIGN KEY(id)
         REFERENCES camp_member(id),
         CONSTRAINT gi_fno_fk FOREIGN KEY(gno)
         REFERENCES goods1(gno)
   );
 */
public class GoodsJjimVO {
   private int no, gno, cno, selling_price;
   private String id;
   private String title, poster;
   
   public int getCno() {
      return cno;
   }
   public void setCno(int cno) {
      this.cno = cno;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public int getSelling_price() {
      return selling_price;
   }
   public void setSelling_price(int selling_price) {
      this.selling_price = selling_price;
   }
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }
   public int getGno() {
      return gno;
   }
   public void setGno(int gno) {
      this.gno = gno;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPoster() {
      return poster;
   }
   public void setPoster(String poster) {
      this.poster = poster;
   }
}