package com.collect.api.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collect.api.bean.ComContent;
import com.collect.api.service.IndexService;
import com.collect.common.annotation.Access;
import com.collect.common.base.BaseController;
import com.google.common.collect.Maps;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

@RestController
@RequestMapping("/index")
public class IndexController extends BaseController {
	
	@Autowired
	private IndexService indexService;
	
	@Access
	@GetMapping("list")
	public Object list(@RequestParam Map<String, Object> params) {
		return success(indexService.selectList(params));
	}
	
	@GetMapping("sort")
	public Object sort(@RequestParam Map<String, Object> params) {
		return success();
	}
	
	@GetMapping("other")
	public Object other() {
		return success(indexService.other());
	}
	
	@GetMapping("export")
	public void export(HttpServletResponse response) {
		Map<String, Object> params = Maps.newHashMap();
		List<ComContent> list = indexService.exportList(params);
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), ComContent.class, list);
		response.setHeader("content-Type", "application/vnd.ms-excel");
		response.setCharacterEncoding("UTF-8");
		try {
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("云收藏.xls", "UTF-8"));
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
