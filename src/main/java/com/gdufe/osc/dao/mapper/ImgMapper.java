package com.gdufe.osc.dao.mapper;

import com.gdufe.osc.entity.Img;
import com.gdufe.osc.entity.ImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ImgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table img
     *
     * @mbg.generated
     */
    long countByExample(ImgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table img
     *
     * @mbg.generated
     */
    int deleteByExample(ImgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table img
     *
     * @mbg.generated
     */
    int insert(Img record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table img
     *
     * @mbg.generated
     */
    int insertSelective(Img record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table img
     *
     * @mbg.generated
     */
    List<Img> selectByExample(ImgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table img
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Img record, @Param("example") ImgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table img
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Img record, @Param("example") ImgExample example);
}