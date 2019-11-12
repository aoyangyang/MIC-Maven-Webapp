/**
 * chenPeng
 * com.mic.service.question
 * TeacherQuestionDo.java
 * 创建人:chenpeng
 * 时间：2019年2月9日-下午4:56:03 
 * 2019陈鹏-版权所有
 */
package com.mic.service.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.course.CourseNote;
import com.mic.bean.db.Problems;
import com.mic.bean.db.Reply;
import com.mic.bean.student.Student;
import com.mic.bean.teacher.ShowAnsDetails;
import com.mic.dao.question.TeacherQuestionDao;

import net.sf.json.JSONArray;

/**
 * 
 * TeacherQuestionDo
 * 创建人:chenPeng
 * 时间：2019年2月9日-下午4:56:03 
 * @version 1.0.0
 * 
 */
@Service
public class TeacherQuestionDo {
	@Autowired
	private TeacherQuestionDao teacherQuestionDao;
	/**
	 * 查询出课堂信息
	 * 方法名：getCourseNote
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午5:12:20 
	 * 手机:17673111810
	 * @param no
	 * @return CourseNote
	 * @exception 
	 * @since  1.0.0
	*/
	public CourseNote getCourseNote(Integer no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.getCourseNote(no);
	}
	/**
	 * 添加ppt
	 * 方法名：addPPt
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午10:15:45 
	 * 手机:17673111810
	 * @param courseNoteId
	 * @param string void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addPPt(Integer courseNoteId, String string) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("courseNoteId", courseNoteId+"");
		map.put("src", string);
		
		teacherQuestionDao.addPPt(map);
	}
	/**
	 * 得到ppt路径
	 * 方法名：getPptPath
	 * 创建人：chenPeng
	 * 时间：2019年2月10日-下午9:26:04 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String getPptPath(Integer no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.getPptPath(no);
	}
	/**
	 * 删除ppt
	 * 方法名：deletePpt
	 * 创建人：chenPeng
	 * 时间：2019年2月10日-下午10:53:45 
	 * 手机:17673111810
	 * @param no
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer deletePpt(String no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.deletePpt(Integer.parseInt(no));
	}
	/**
	 * 添加一个提问
	 * 方法名：addQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午8:43:26 
	 * 手机:17673111810
	 * @param no
	 * @param quText
	 * @param quAns
	 * @param exampleQu
	 * @param newFilePath void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addQu(Integer no, String quText, String quAns, String exampleQu, String newFilePath) {
		// TODO Auto-generated method stub
		int temp = 0;
		if("true".equals(exampleQu)){
			temp = 1;
		}
		teacherQuestionDao.addQu(new Problems(no, quText, quAns, newFilePath, temp));
	}
	/**
	 * 查询出提问
	 * 方法名：getProList
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午9:19:31 
	 * 手机:17673111810
	 * @param no
	 * @return List<Problems>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Problems> getProList(Integer no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.getProList(no);
	}
	/**
	 * 提问
	 * 方法名：doQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午10:23:11 
	 * 手机:17673111810
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	*/
	public void doQu(Integer no) {
		// TODO Auto-generated method stub
		teacherQuestionDao.doQu(no);
	}
	/**
	 * 得到统计图
	 * （有每个选项的人数，正确答案的人数，错误的人数，总人数，答题人数）
	 * 方法名：getQuStatistics
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午6:49:45 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String getQuStatistics(Integer no) {
		// TODO Auto-generated method stub
		// 获取应该答题人数，也就是选课人数
		List<Student> clsStu = teacherQuestionDao.getQuStatistics(no);
		
		// 获取已答题人数以及答案
		List<Reply> replyList = teacherQuestionDao.getReplyList(no);
		
		// 获取正确答案
		String ans = teacherQuestionDao.getAns(no);
		
		// 对比答案 正确的与错误的 分别计数
		// 分别统计各种答案 以及各种答案 的个数
		int isYes = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Reply reply : replyList) {
			//将结果计入set
			String stuAns = reply.getAnswer();
			Integer ansSum = map.get(stuAns);
			if (ansSum == null) {
				map.put(stuAns, 1);
			}else{
				map.put(stuAns, ansSum+1);
			}
			//对比答案
			if (ans.equals(reply.getAnswer())) {
				isYes++;
			}
		}
		
		//返回数据
		JSONArray json = new JSONArray();
		Map<String, Map<String, Integer>> jsonMap = new HashMap<String, Map<String,Integer>>();
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		
		//应回答人数
		tempMap.put("clsStu", clsStu.size());
		//回答人数
		tempMap.put("replyList", replyList.size());
		//答对人数
		tempMap.put("isYse", isYes);
		//答错人数
		tempMap.put("isNo",replyList.size() - isYes);
		
		jsonMap.put("peopleNub", tempMap);
		jsonMap.put("ansNub", map);
		
		json.add(jsonMap);
		
		return json.toString();
	}
	/**
	 * 得到详细的答题情况
	 * 方法名：getDetailsList
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午11:26:43 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	*/
	public ModelAndView getDetailsList(Integer no) {
		// TODO Auto-generated method stub
		ModelAndView andView = new ModelAndView();
		// 获取应该答题人数，也就是选课人数
		List<Student> clsStu = teacherQuestionDao.getQuStatistics(no);
		
		//答题详情
		List<ShowAnsDetails> detailsList = teacherQuestionDao.getDetailsList(no);
		
		// 获取正确答案
		String ans = teacherQuestionDao.getAns(no);
		
		Set<Integer> stuIdSet = new HashSet<Integer>();
		for (ShowAnsDetails showAnsDetails : detailsList) {
			//判断答案
			String stuAns = showAnsDetails.getAnswer();
			if (ans.equals(stuAns)) {
				showAnsDetails.setCorrect(1);
			}else{
				showAnsDetails.setCorrect(0);
			}
			
			//弄出没有答题的学生
			stuIdSet.add(showAnsDetails.getId());
		}
		
		//弄出没有答题的学生
		ShowAnsDetails sad;
		for (Student stuID : clsStu) {
			if (!stuIdSet.contains(stuID.getId())) {
				sad = new ShowAnsDetails();
				sad.setAnswer("未答题");
				sad.setUsername(stuID.getUsername());
				detailsList.add(sad);
			}
		}
		
		andView.addObject("detailsList", detailsList);
		andView.setViewName("question/teaShowAnsDetails");
		return andView;
	}

}
