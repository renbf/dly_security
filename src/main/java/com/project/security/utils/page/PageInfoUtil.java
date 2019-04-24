package com.project.security.utils.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.constant.Constants;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.common.utils.StringUtils;
/**
 * 封装分页结果
 * @author rbf
 *
 * @param <T>
 */
public class PageInfoUtil<T> {

	public static <T> TableDataView<T> addPageInfo(List<T> list) {
		try {
			PageInfo<T> pageInfo = new PageInfo<T>(list);
			TableDataView<T> TableDataView = new TableDataView<T>();
			TableDataView.setPageNumber(pageInfo.getPageNum());
			TableDataView.setTotal(pageInfo.getTotal());
			TableDataView.setRows(list);
			return TableDataView;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static DataResult startPage(Integer pageNumber,Long total,String orderBy) {
		DataResult result = new DataResult();
		try {
			Integer pageNum = Objects.isNull(pageNumber) ? 1 : pageNumber;
			Integer pageSize = Constants.PAGE_SIZE_NUMBER;
			if (pageNum.intValue() < 1 || (pageNum.intValue() > 1 && total == null)) {
				List list = new ArrayList();
				TableDataView tableDataView = new TableDataView();
				tableDataView.setPageNumber(pageNumber);
				tableDataView.setTotal(0);
				tableDataView.setRows(list);
				result.setResult(tableDataView);
				result.setMessage("分页查询页数不能小于1");
				result.setStatus(Result.SUCCESS);
				return result;
			}
			if (total != null) {
				Integer pages = (total.intValue() + pageSize - 1) / pageSize;
				if (pageNum.intValue() > pages.intValue()) {
					List list = new ArrayList();
					TableDataView tableDataView = new TableDataView();
					tableDataView.setPageNumber(pageNumber);
					tableDataView.setTotal(total);
					tableDataView.setRows(list);
					result.setResult(tableDataView);
					result.setMessage("分页查询超过总页数");
					result.setStatus(Result.SUCCESS);
					return result;
				}
			}
			if (StringUtils.isNotNull(pageNum)) {
				if (StringUtils.isNotEmpty(orderBy)) {
					PageHelper.startPage(pageNum, pageSize, orderBy);
				} else {
					PageHelper.startPage(pageNum, pageSize);
				}
			}
			result.setStatus(Result.FAILED);
			return result;
		} catch (Exception e) {
			result.setStatus(Result.FAILED);
			return result;
		}
	}
}
