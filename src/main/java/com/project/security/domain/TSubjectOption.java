package com.project.security.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 题库选项关系表 t_subject_option
 * 
 * @author rbf
 * @date 2019-04-16
 */
public class TSubjectOption implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 题库ID */
	private String subjectId;
	/** 选项 */
	private String optionValue;
	/** 内容 */
	private String content;
	/** 是否是答案1是0否 */
	private String isAnswer;
	/** 顺序 */
	private Integer optionSort;

	public void setSubjectId(String subjectId) 
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
	}
	public void setOptionValue(String optionValue) 
	{
		this.optionValue = optionValue;
	}

	public String getOptionValue() 
	{
		return optionValue;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setIsAnswer(String isAnswer) 
	{
		this.isAnswer = isAnswer;
	}

	public String getIsAnswer() 
	{
		return isAnswer;
	}
	public void setOptionSort(Integer optionSort) 
	{
		this.optionSort = optionSort;
	}

	public Integer getOptionSort() 
	{
		return optionSort;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subjectId", getSubjectId())
            .append("optionValue", getOptionValue())
            .append("content", getContent())
            .append("isAnswer", getIsAnswer())
            .append("optionSort", getOptionSort())
            .toString();
    }
}
