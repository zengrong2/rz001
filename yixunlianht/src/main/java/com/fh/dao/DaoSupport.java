package com.fh.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.fh.entity.Page;
import com.fh.entity.system.User;
import com.fh.lw.pojo.company.Application;
import com.fh.lw.pojo.company.Company;
import com.fh.lw.pojo.company.Position;
import com.fh.lw.pojo.course.Chapter;
import com.fh.lw.pojo.course.Curriculum;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.pojo.obtainemployment.Prejob;
import com.fh.lw.pojo.school.School;
import com.fh.lw.pojo.school.SchoolMajor;
import com.fh.lw.pojo.student.Student;
import com.fh.lw.pojo.user.Teacher;
import com.fh.util.PageData;
/**
 * @author FH Q728971035
 * 修改时间：2015、12、11
 */
@Repository("daoSupport")
public class DaoSupport implements DAO {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object save(String str, Object obj) throws Exception {
		return sqlSessionTemplate.insert(str, obj);
	}
	
	/**
	 * 批量更新
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object batchSave(String str, List objs )throws Exception{
		return sqlSessionTemplate.insert(str, objs);
	}
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object update(String str, Object obj) throws Exception {
		return sqlSessionTemplate.update(str, obj);
	}

	/**
	 * 批量更新
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public void batchUpdate(String str, List objs )throws Exception{
		SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
		//批量执行器
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
		try{
			if(objs!=null){
				for(int i=0,size=objs.size();i<size;i++){
					sqlSession.update(str, objs.get(i));
				}
				sqlSession.flushStatements();
				sqlSession.commit();
				sqlSession.clearCache();
			}
		}finally{
			sqlSession.close();
		}
	}
	
	/**
	 * 批量更新
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object batchDelete(String str, List objs )throws Exception{
		return sqlSessionTemplate.delete(str, objs);
	}
	
	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object delete(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}
	 
	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForObject(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str, obj);
	}

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForList(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}
	
	public Object findForMap(String str, Object obj, String key, String value) throws Exception {
		return sqlSessionTemplate.selectMap(str, obj, key);
	}

	public List<Student> findForListByTid(String string, Long tid) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(string,tid);
	}

	public SchoolMajor soloStuMoney(String string, PageData pd) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(string, pd);
	}

	public List<Teacher> firIdFindSecondTeacher(String string, Long pid) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(string,pid);
	}
//2018/8/4
	public List<Teacher> firstFindSecondTeacherList(String string, Long tid) {
		// TODO Auto-generated method stub
		 return sqlSessionTemplate.selectList(string,tid);
	}
//2018/8/4
	public Object comfireStudy(String string, PageData pd) {
		// TODO Auto-generated method stub
		 return sqlSessionTemplate.update(string, pd);
	}
//2018/8/4
	public User findUserForObject(String string, PageData pd) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(string, pd);
	}

	//2018/8/8

	public List<PageData> findFirstTeaGetStu(String string, PageData pd) {
		return sqlSessionTemplate.selectList(string, pd);
	}
//2018/8/8
	public List<PageData> findSecondTeaByFirstTeaTid(String string, PageData pd) {
		// TODO Auto-generated method stub
		 return sqlSessionTemplate.selectList(string,pd);
	}

	public Object addIntegeral(String string, PageData pd) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(string, pd);
	}

	public List<PageData> listTeacherBypId(String string, PageData pd) {
		// TODO Auto-generated method stub
		 return sqlSessionTemplate.selectList(string,pd);
	}

	public Teacher findForTeacher(String string, Long long1) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(string, long1);
	}

	
	public Object findListWorks(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}

	
	public Object listCompany(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}

	
	public Object findListTrain(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}

	
	public Object listPreJobType(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}

	
	public Object listLabourWordType(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}

	
	public Object listSchoolCurriculum(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}
	public Object listPromotionSchool(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}
	public Object listStudentResume(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}

	
	public Object deleteCompanyByCid(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}

	
	public Object editCompanyByCid(String str, Object obj) throws Exception {
		return sqlSessionTemplate.update(str, obj);
	}

	public Object getCompanyByCid(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str, obj);
	}

	
	public Object saveCompanyInfo(String str, Object obj) throws Exception {
		return sqlSessionTemplate.insert(str, obj);
	}

	
	public Object deletePositionByPid(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}

		public Object findPositionByPid(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str, obj);
	}

		
		public Object editPositionByPid(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

		
		public Object savePositionInfo(String str, Object obj) throws Exception {
			return sqlSessionTemplate.insert(str, obj);
		}

		
		public Object deleteLabourTypeBylid(String str, Object obj) throws Exception {
			return sqlSessionTemplate.delete(str, obj);
		}

		
		public Object getLabourTypeById(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

		
		public Object editLabourType(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

		
		public Object saveLabourTypeInfo(String str, Object obj) throws Exception {
			return sqlSessionTemplate.insert(str, obj);
		}

	
		public Object deleteSchoolCurriculumByCid(String str, Object obj) throws Exception {
			return sqlSessionTemplate.delete(str, obj);
		}

		
		public Object saveSchoolCurriculumInfo(String str, Object obj) throws Exception {
			return sqlSessionTemplate.insert(str, obj);
		}

		
		public Object getSchoolCurriculumById(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

		
		public Object editSchoolCurriculum(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

		
		public Object delPreJobTypeBylid(String str, Object obj) throws Exception {
			return sqlSessionTemplate.delete(str, obj);
		}

	
		public Object savePreJobTypeInfo(String str, Object obj) throws Exception {
			return sqlSessionTemplate.insert(str, obj);
		}

		
		public Object getPreJobTypeTypeById(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

		
		public Object editPreJobTypeType(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

		
		public Object delStudentResumeByCid(String str, Object obj) throws Exception {
			return sqlSessionTemplate.delete(str, obj);
		}

		
		public Object saveStudentResumeInfo(String str, Object obj) throws Exception {
			return sqlSessionTemplate.insert(str, obj);
		}

		
		public Object getStudentResumeById(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

		
		public Object editStudentResume(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

	
		public Object editRecruitState(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

		
		public Object showListLabourWorkType(String str) throws Exception {
			return sqlSessionTemplate.selectList(str);
		}

		
		public Object findLabourTypeById(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

		
		
		
		
		public Object findListChapterByCurriculumId(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectList(str, obj);
		}

		
		public Object editChapter(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

		
		public Object addChapter(String str, Object obj) throws Exception {
			return sqlSessionTemplate.insert(str, obj);
		}

	
		public Object editS(String str, Object obj) throws Exception {
			return sqlSessionTemplate.update(str, obj);
		}

		
		public Object getListStudentResume(String str) throws Exception {
			return sqlSessionTemplate.selectList(str);
		}

	
		public Object findCompanyById(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

		
		public Object findCompanyByName(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

	
		public Object ListPreJobType(String str) throws Exception {
			return sqlSessionTemplate.selectList(str);
		}



		public Object findSchoolByName(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}

		
		public Object findSchooMajorByName(String str, Object obj) throws Exception {
			return sqlSessionTemplate.selectOne(str, obj);
		}


		public Object getAllCompany(String str) throws Exception {
			return sqlSessionTemplate.selectList(str);
		}
	
}


