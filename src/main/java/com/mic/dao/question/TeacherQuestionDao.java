/**
 * chenPeng
 * com.mic.dao.question
 * TeacherQuestionDao.java
 * 创建人:chenpeng
 * 时间：2019年2月9日-下午4:56:59 
 * 2019陈鹏-版权所有
 */
package com.mic.dao.question;

import java.util.List;
import java.util.Map;

import com.mic.bean.course.CourseNote;
import com.mic.bean.db.Problems;
import com.mic.bean.db.Reply;
import com.mic.bean.student.Student;
import com.mic.bean.teacher.ShowAnsDetails;

/**
 * 
 * TeacherQuestionDao
 * 创建人:chenPeng
 * 时间：2019年2月9日-下午4:56:59 
 * @version 1.0.0
 * 
 */
public interface TeacherQuestionDao {

	/**
	 * 查询出课堂信息
	 * 方法名：getCourseNote
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午5:13:30 
	 * 手机:17673111810
	 * @param no
	 * @return CourseNote
	 * @exception 
	 * @since  1.0.0
	*/
	CourseNote getCourseNote(Integer no);

	/**
	 * 添加ppt
	 * 方法名：addPPt
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午10:20:12 
	 * 手机:17673111810
	 * @param map void
	 * @exception 
	 * @since  1.0.0
	*/
	void addPPt(Map<String, String> map);

	/**
	 * 查询ppt
	 * 方法名：getPptPath
	 * 创建人：chenPeng
	 * 时间：2019年2月10日-下午9:26:22 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	String getPptPath(Integer no);

	/**
	 * 删除ppt
	 * 方法名：deletePpt
	 * 创建人：chenPeng
	 * 时间：2019年2月10日-下午10:54:04 
	 * 手机:17673111810
	 * @param no
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer deletePpt(Integer no);

	/**
	 * 添加一个问题
	 * 方法名：addQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午8:52:42 
	 * 手机:17673111810
	 * @param problems void
	 * @exception 
	 * @since  1.0.0
	*/
	void addQu(Problems problems);

	/**
	 * 得到页面的全部提问
	 * 方法名：getProList
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午9:19:57 
	 * 手机:17673111810
	 * @param no
	 * @return List<Problems>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Problems> getProList(Integer no);

	/**
	 * 问题
	 * 方法名：doQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午10:23:32 
	 * 手机:17673111810
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	*/
	void doQu(Integer no);

	/**
	 *  获取全部应该答题人
	 * 方法名：getQuStatistics
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午6:58:06 
	 * 手机:17673111810
	 * @param no
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Student> getQuStatistics(Integer no);

	/**
	 * 获取已答题人数以及答案
	 * 方法名：getReplyList
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午7:03:40 
	 * 手机:17673111810
	 * @param no
	 * @return List<Reply>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Reply> getReplyList(Integer no);

	/**
	 * 获取答案
	 * 方法名：getAns
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午7:05:58 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	String getAns(Integer no);

	/**
	 * 获取详情答题
	 * 方法名：getDetailsList
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午11:29:57 
	 * 手机:17673111810
	 * @param no
	 * @return List<ShowAnsDetails>
	 * @exception 
	 * @since  1.0.0
	*/
	List<ShowAnsDetails> getDetailsList(Integer no);

}
