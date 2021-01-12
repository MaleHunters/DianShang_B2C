package com.qingcheng.pojo.goods;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/12 13:08
 * @Package: com.qingcheng.pojo.goods
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@Table(name = "tb_brand")
public class Brand implements Serializable {
  @Id
  private Integer id;

  private String name;

  private String image;

  private String letter;

  private String seq;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getLetter() {
    return letter;
  }

  public void setLetter(String letter) {
    this.letter = letter;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }
}
