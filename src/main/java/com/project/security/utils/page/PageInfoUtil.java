package com.project.security.utils.page;

import java.util.List;

import com.github.pagehelper.PageInfo;
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
}
