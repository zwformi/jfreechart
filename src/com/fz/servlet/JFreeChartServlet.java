package com.fz.servlet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class JFreeChartServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		dataSet.addValue(20, "全勤人数", "技术研发部");
		dataSet.addValue(5, "缺勤人数", "技术研发部");
		dataSet.addValue(10, "迟到人数", "技术研发部");
		dataSet.addValue(6, "早退人数", "技术研发部");

		dataSet.addValue(10, "全勤人数", "财务部");
		dataSet.addValue(2, "缺勤人数", "财务部");
		dataSet.addValue(3, "迟到人数", "财务部");

		JFreeChart chart = ChartFactory.createBarChart(
				"员工出勤报表",//报表的标题
				"部门",//x轴的标题
				"人数",//y轴的标题
				dataSet,//设置产生报表的数据集
				PlotOrientation.VERTICAL,
				true,
				false,
				false);

		TextTitle title = chart.getTitle();//获取报表的标题
		title.setFont(new Font("隶书",Font.BOLD,30));

		CategoryPlot cp = chart.getCategoryPlot();
		CategoryAxis ca = cp.getDomainAxis();
		ca.setLabelFont(new Font("宋体",Font.PLAIN,20));//设置x轴轴标题
		ca.setTickLabelFont(new Font("宋体",Font.PLAIN,15	));//设置x轴轴标签

		ValueAxis va = cp.getRangeAxis();
		va.setLabelFont(new Font("宋体",Font.PLAIN,15));

		LegendTitle lt = chart.getLegend();
		if(lt!=null){
			lt.setItemFont(new Font("宋体",Font.BOLD,15));
		}


		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), chart, 400, 400);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
